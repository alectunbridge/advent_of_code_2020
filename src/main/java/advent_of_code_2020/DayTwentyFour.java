package advent_of_code_2020;

import java.util.*;
import java.util.stream.Collectors;

public class DayTwentyFour {
    private List<String> lines = new ArrayList<>();
    private Set<BlackTile> blackTiles = new HashSet<>();

    public DayTwentyFour(String... lines) {
        Arrays.stream(lines).forEach(this::parseLine);
    }

    private void parseLine(String line) {
        String result = "";
        int hexX = 0;
        int hexY = 0;
        for (int i = 0; i < line.length();) {
            char nextChar = line.charAt(i);
            if(nextChar == 'e') {
                result += "EAST,";
                hexX += 2;
                i++;
            } else if(nextChar == 'w') {
                result += "WEST,";
                hexX -= 2;
                i++;
            } else {
                String nextTwoChars = line.substring(i, i + 2);
                if(nextTwoChars.equals("nw")) {
                    result += "NORTH_WEST,";
                    hexX -= 1;
                    hexY += 1;
                    i+=2;
                } else if(nextTwoChars.equals("ne")) {
                    result += "NORTH_EAST,";
                    hexX += 1;
                    hexY += 1;
                    i+=2;
                } else if(nextTwoChars.equals("sw")) {
                    result += "SOUTH_WEST,";
                    hexX -= 1;
                    hexY -= 1;
                    i+=2;
                } else if(nextTwoChars.equals("se")) {
                    result += "SOUTH_EAST,";
                    hexX += 1;
                    hexY -= 1;
                    i+=2;
                } else {
                    throw new RuntimeException("can't parse input");
                }
            }
        }
        BlackTile tileLocation = new BlackTile(hexX, hexY);
        if(blackTiles.contains(tileLocation)) {
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

    public Set<BlackTile> getBlackTiles() {
        return blackTiles;
    }
}
