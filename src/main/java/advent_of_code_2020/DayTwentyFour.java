package advent_of_code_2020;

import java.util.*;
import java.util.stream.Collectors;

public class DayTwentyFour {
    private List<String> lines = new ArrayList<>();
    private Set<HexTile> blackTiles = new HashSet<>();

    public DayTwentyFour(String... lines) {
        Arrays.stream(lines).forEach(this::parseLine);
    }

    private void parseLine(String line) {
        String result = "";
        int hexX = 0;
        int hexY = 0;
        for (int i = 0; i < line.length(); ) {
            char nextChar = line.charAt(i);
            if (nextChar == 'e') {
                result += "EAST,";
                hexX += 2;
                i++;
            } else if (nextChar == 'w') {
                result += "WEST,";
                hexX -= 2;
                i++;
            } else {
                String nextTwoChars = line.substring(i, i + 2);
                if (nextTwoChars.equals("nw")) {
                    result += "NORTH_WEST,";
                    hexX -= 1;
                    hexY += 1;
                    i += 2;
                } else if (nextTwoChars.equals("ne")) {
                    result += "NORTH_EAST,";
                    hexX += 1;
                    hexY += 1;
                    i += 2;
                } else if (nextTwoChars.equals("sw")) {
                    result += "SOUTH_WEST,";
                    hexX -= 1;
                    hexY -= 1;
                    i += 2;
                } else if (nextTwoChars.equals("se")) {
                    result += "SOUTH_EAST,";
                    hexX += 1;
                    hexY -= 1;
                    i += 2;
                } else {
                    throw new RuntimeException("can't parse input");
                }
            }
        }
        HexTile tileLocation = new HexTile(hexX, hexY);
        if (blackTiles.contains(tileLocation)) {
            blackTiles.remove(tileLocation);
        } else {
            blackTiles.add(tileLocation);
        }
        this.lines.add(result);
    }

    @Override
    public String toString() {
        return lines.stream().map(Object::toString).collect(Collectors.joining("\n"));
    }

    public Set<HexTile> getBlackTiles() {
        return blackTiles;
    }

    public void flip() {
        Set<HexTile> newBlackTiles = new HashSet<>();

        for (HexTile blackTile : blackTiles) {
            int neighbourCount = getBlackNeighbours(blackTile);
            if (neighbourCount > 0 && neighbourCount <= 2) {
                newBlackTiles.add(blackTile);
            }
            Set<HexTile> whiteNeighbours = getWhiteNeighbours(blackTile);
            for (HexTile whiteNeighbour : whiteNeighbours) {
                if(getBlackNeighbours(whiteNeighbour) == 2) {
                    newBlackTiles.add(whiteNeighbour);
                }
            }
        }
        blackTiles = newBlackTiles;
    }

    int getBlackNeighbours(HexTile hexTile) {
        int neighbours = 0;
        List<HexTile> potentialNeighbours =
                Arrays.asList(
                        hexTile.northEast(),
                        hexTile.east(),
                        hexTile.southEast(),
                        hexTile.southWest(),
                        hexTile.west(),
                        hexTile.northWest());

        for (HexTile tile : potentialNeighbours) {
            if (this.blackTiles.contains(tile)) {
                neighbours++;
            }
        }

        return neighbours;
    }

    Set<HexTile> getWhiteNeighbours(HexTile hexTile){
        Set<HexTile> whiteNeighbours = new HashSet<>();
        List<HexTile> neighbours =
                Arrays.asList(
                        hexTile.northEast(),
                        hexTile.east(),
                        hexTile.southEast(),
                        hexTile.southWest(),
                        hexTile.west(),
                        hexTile.northWest());

        for (HexTile tile : neighbours) {
            if (!this.blackTiles.contains(tile)) {
                whiteNeighbours.add(tile);
            }
        }

        return whiteNeighbours;
    }
}
