package advent_of_code_2020;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.StringUtils.*;

class Tile {
    private final int id;
    private final String[] lines;
    private String topRow;
    private String bottomRow;
    private String leftEdge;
    private String rightEdge;


    public Tile(String... lines) {
        this.lines = lines;
        Matcher matcher = Pattern.compile("^Tile (\\d+):$").matcher(lines[0]);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Can't parse id from: " + lines[0]);
        }
        id = Integer.parseInt(matcher.group(1));
        topRow = lines[1];
        bottomRow = lines[10];

        StringBuilder leftEdgeBuilder = new StringBuilder();
        StringBuilder rightEdgeBuilder = new StringBuilder();
        for (int i = 1; i < lines.length; i++) {
            leftEdgeBuilder.append(lines[i].charAt(0));
            rightEdgeBuilder.append(lines[i].charAt(9));
        }
        leftEdge = leftEdgeBuilder.toString();
        rightEdge = rightEdgeBuilder.toString();
    }

    @Override
    public String toString() {
        return Arrays.stream(lines).collect(Collectors.joining("\n"));
    }

    public int getId() {
        return id;
    }

    public String getTopRow() {
        return topRow;
    }

    public String getBottomRow() {
        return bottomRow;
    }

    public String getLeftEdge() {
        return leftEdge;
    }

    public String getRightEdge() {
        return rightEdge;
    }
}

public class DayTwenty {

    private MultiValuedMap<String, Tile> tileMap = new HashSetValuedHashMap<>();
    private List<Tile> tiles = new ArrayList<>();

    public void addTile(Tile tile) {
        tiles.add(tile);

        tileMap.put(tile.getTopRow(), tile);
        tileMap.put(reverse(tile.getTopRow()), tile);

        tileMap.put(tile.getRightEdge(), tile);
        tileMap.put(reverse(tile.getRightEdge()), tile);

        tileMap.put(tile.getBottomRow(), tile);
        tileMap.put(reverse(tile.getBottomRow()), tile);

        tileMap.put(tile.getLeftEdge(), tile);
        tileMap.put(reverse(tile.getLeftEdge()), tile);
    }

    public Collection<Tile> getTileByEdge(String edge) {
        return tileMap.get(edge);
    }

    public List<Tile> solve() {
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
        matchingTiles.addAll(tileMap.get(reverse(edge)));
        matchingTiles.remove(tile);
        if (matchingTiles.isEmpty()){
            return 1;
        }
        return 0;
    }
}
