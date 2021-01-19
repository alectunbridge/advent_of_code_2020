package advent_of_code_2020;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Tile {
    private final int id;
    private String topRow;
    private String bottomRow;
    private String leftEdge;
    private String rightEdge;

    public Tile(String... lines){
        Matcher matcher = Pattern.compile("^Tile (\\d+):$").matcher(lines[0]);
        if(!matcher.matches()){
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

}
