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
    private final List<String> edges;
    private String topRow;
    private String bottomRow;
    private String leftEdge;
    private String rightEdge;


    public List<String> getEdges() {
        return edges;
    }

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

        edges = new ArrayList<>();
        edges.add(topRow);
        edges.add(rightEdge);
        edges.add(bottomRow);
        edges.add(leftEdge);
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

    public void flipLeftRight() {
        edges.set(TOP, StringUtils.reverse(edges.get(TOP)));
        edges.set(BOTTOM, StringUtils.reverse(edges.get(BOTTOM)));
        String right = edges.get(RIGHT);
        String left = edges.get(LEFT);
        edges.set(LEFT, right);
        edges.set(RIGHT, left);
    }

    public void flipTopToBottom() {
        String top = edges.get(TOP);
        String bottom = edges.get(BOTTOM);
        edges.set(TOP,bottom);
        edges.set(BOTTOM,top);

        edges.set(LEFT, StringUtils.reverse(edges.get(LEFT)));
        edges.set(RIGHT, StringUtils.reverse(edges.get(RIGHT)));
    }

    public void reverse() {
        for (int lineNo = 1; lineNo < 11; lineNo++) {
            lines[lineNo] = StringUtils.reverse(lines[lineNo]);
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
}
