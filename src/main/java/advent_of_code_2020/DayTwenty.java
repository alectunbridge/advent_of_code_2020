package advent_of_code_2020;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Tile {
    public static final int TOP = 0;
    public static final int RIGHT = 1;
    public static final int BOTTOM = 2;
    public static final int LEFT = 3;
    private final int id;
    private final String[] lines;

    public List<String> getEdges() {
        return Arrays.asList(getTopRow(),getRightEdge(),getBottomRow(),getLeftEdge());
    }

    public Tile(String... lines) {
        this.lines = lines;
        Matcher matcher = Pattern.compile("^Tile (\\d+):$").matcher(lines[0]);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Can't parse id from: " + lines[0]);
        }
        id = Integer.parseInt(matcher.group(1));
    }

    private String extractColumn(int index) {
        return leftEdgeBuilder(index);
    }

    private String leftEdgeBuilder(int index) {
        StringBuilder leftEdgeBuilder = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            leftEdgeBuilder.append(lines[i].charAt(index));
        }
        return leftEdgeBuilder.toString();
    }

    @Override
    public String toString() {
        return Arrays.stream(lines).collect(Collectors.joining("\n"));
    }

    public int getId() {
        return id;
    }

    public String getTopRow() {
        return lines[1];
    }

    public String getBottomRow() {
        return lines[10];
    }

    public String getLeftEdge() {
        return extractColumn(0);
    }

    public String getRightEdge() {
        return extractColumn(9);
    }

    public void reverse() {
        for (int lineNo = 1; lineNo < 11; lineNo++) {
            lines[lineNo] = StringUtils.reverse(lines[lineNo]);
        }
    }

    public void rotate() {
        char[][] oldCharacters = new char[10][10];
        for (int i = 1; i < 11; i++) {
            oldCharacters[i-1] = lines[i].toCharArray();
        }

        char[][] newCharacters = new char[10][10];

        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                newCharacters[y][x] = oldCharacters[10 - x - 1][y];
            }
        }

        for (int lineNo = 1; lineNo < 11; lineNo++) {
            lines[lineNo] = new String(newCharacters[lineNo-1]);
        }
    }
}

public class DayTwenty {

    private MultiValuedMap<String, Tile> tileMap = new HashSetValuedHashMap<>();
    private List<Tile> tiles = new ArrayList<>();

    public DayTwenty() {
    }

    public DayTwenty(String filename) throws IOException, URISyntaxException {
        String[] lines = Files.readAllLines(Path.of(DayTwenty.class.getClassLoader().getResource(filename).toURI())).toArray(new String[0]);
        for (int i = 0; i < 144; i++) {
            Tile tile = new Tile(Arrays.copyOfRange(lines,i*12,i*12+11));
            addTile(tile);
        }
    }

    public void addTile(Tile tile) {
        tiles.add(tile);

        tileMap.put(tile.getTopRow(), tile);
        tileMap.put(StringUtils.reverse(tile.getTopRow()), tile);

        tileMap.put(tile.getRightEdge(), tile);
        tileMap.put(StringUtils.reverse(tile.getRightEdge()), tile);

        tileMap.put(tile.getBottomRow(), tile);
        tileMap.put(StringUtils.reverse(tile.getBottomRow()), tile);

        tileMap.put(tile.getLeftEdge(), tile);
        tileMap.put(StringUtils.reverse(tile.getLeftEdge()), tile);
    }

    public Collection<Tile> getTilesByEdge(String edge) {
        return tileMap.get(edge);
    }

    public List<Tile> findCorners() {
        List<Tile> corners = new ArrayList<>();
        for(Tile tile: tiles){
            int edgesWithNoMatches = 0;
            edgesWithNoMatches += edgeHasNoMatches(tile, tile.getTopRow());
            edgesWithNoMatches += edgeHasNoMatches(tile, tile.getBottomRow());
            edgesWithNoMatches += edgeHasNoMatches(tile, tile.getLeftEdge());
            edgesWithNoMatches += edgeHasNoMatches(tile, tile.getRightEdge());
            if(edgesWithNoMatches == 2){
                corners.add(tile);
            }
        }
        return corners;
    }

    private int edgeHasNoMatches(Tile tile, String edge) {
        Set<Tile> matchingTiles = new HashSet<>();
        matchingTiles.addAll(tileMap.get(edge));
        matchingTiles.addAll(tileMap.get(StringUtils.reverse(edge)));
        matchingTiles.remove(tile);
        if (matchingTiles.isEmpty()){
            return 1;
        }
        return 0;
    }

    public void removeFromMap(Tile tile) {
        for (String edge: tile.getEdges()) {
            tileMap.removeMapping(edge,tile);
            tileMap.removeMapping(StringUtils.reverse(edge),tile);
        }
    }
}
