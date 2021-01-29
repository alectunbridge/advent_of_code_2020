package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

import static advent_of_code_2020.Tile.RIGHT;
import static advent_of_code_2020.Tile.TOP;
import static org.apache.commons.lang3.StringUtils.reverse;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;

public class DayTwentyTest {

    @Test
    void parseTile() {
        Tile tile = new Tile(
                "Tile 3469:",
                ".##..#.#.#",
                "##..#...##",
                "...#..##.#",
                "....#.#..#",
                "#..#.##...",
                ".#.##.#.##",
                "..#.#.....",
                "..###.#..#",
                "#.##.#...#",
                "....#...##"
        );

        assertThat(tile.getId()).isEqualTo(3469);
        assertThat(tile.getTopRow()).isEqualTo(".##..#.#.#");
        assertThat(tile.getBottomRow()).isEqualTo("....#...##");
        assertThat(tile.getLeftEdge()).isEqualTo(".#..#...#.");
        assertThat(tile.getRightEdge()).isEqualTo("####.#.###");
    }

    @Test
    void flipTile() {
        Tile tile = new Tile(
                "Tile 3469:",
                ".##..#.#.#",
                "##..#...##",
                "...#..##.#",
                "....#.#..#",
                "#..#.##...",
                ".#.##.#.##",
                "..#.#.....",
                "..###.#..#",
                "#.##.#...#",
                "....#...##"
        );
        tile.reverse();
        assertThat(tile.toString()).isEqualTo(
                "Tile 3469:\n" +
                        "#.#.#..##.\n" +
                        "##...#..##\n" +
                        "#.##..#...\n" +
                        "#..#.#....\n" +
                        "...##.#..#\n" +
                        "##.#.##.#.\n" +
                        ".....#.#..\n" +
                        "#..#.###..\n" +
                        "#...#.##.#\n" +
                        "##...#....");
    }

    @Test
    void rotateTile() {
        Tile tile = new Tile(
                "Tile 3469:",
                ".##..#.#.#",
                "##..#...##",
                "...#..##.#",
                "....#.#..#",
                "#..#.##...",
                ".#.##.#.##",
                "..#.#.....",
                "..###.#..#",
                "#.##.#...#",
                "....#...##"
        );
        tile.rotate();
        assertThat(tile.toString()).isEqualTo(
                "Tile 3469:\n" +
                        ".#...#..#.\n" +
                        "....#...##\n" +
                        ".###.....#\n" +
                        ".##.##.#..\n" +
                        "#.###.#.#.\n" +
                        ".#...#...#\n" +
                        "..#.####..\n" +
                        ".......#.#\n" +
                        "#...#...#.\n" +
                        "###.#.####"
        );
    }

    @Test
    void hashTiles() {
        DayTwenty dayTwenty = new DayTwenty();
        Tile tile = new Tile(
                "Tile 3469:",
                ".##..#.#.#",
                "##..#...##",
                "...#..##.#",
                "....#.#..#",
                "#..#.##...",
                ".#.##.#.##",
                "..#.#.....",
                "..###.#..#",
                "#.##.#...#",
                "....#...##"
        );
        dayTwenty.addTile(tile);

        assertThat(dayTwenty.getTilesByEdge(".##..#.#.#")).containsExactly(tile);
        assertThat(dayTwenty.getTilesByEdge(reverse(".##..#.#.#"))).containsExactly(tile);

        assertThat(dayTwenty.getTilesByEdge("####.#.###")).containsExactly(tile);
        assertThat(dayTwenty.getTilesByEdge(reverse("####.#.###"))).containsExactly(tile);

        assertThat(dayTwenty.getTilesByEdge("....#...##")).containsExactly(tile);
        assertThat(dayTwenty.getTilesByEdge(reverse("....#...##"))).containsExactly(tile);

        assertThat(dayTwenty.getTilesByEdge(".#..#...#.")).containsExactly(tile);
        assertThat(dayTwenty.getTilesByEdge(reverse(".#..#...#."))).containsExactly(tile);
    }

    @Test
    void addAllTilesFromExample() {
        DayTwenty dayTwenty = new DayTwenty();
        String[] lines = {
                "Tile 2311:",
                "..##.#..#.",
                "##..#.....",
                "#...##..#.",
                "####.#...#",
                "##.##.###.",
                "##...#.###",
                ".#.#.#..##",
                "..#....#..",
                "###...#.#.",
                "..###..###",
                "",
                "Tile 1951:",
                "#.##...##.",
                "#.####...#",
                ".....#..##",
                "#...######",
                ".##.#....#",
                ".###.#####",
                "###.##.##.",
                ".###....#.",
                "..#.#..#.#",
                "#...##.#..",
                "",
                "Tile 1171:",
                "####...##.",
                "#..##.#..#",
                "##.#..#.#.",
                ".###.####.",
                "..###.####",
                ".##....##.",
                ".#...####.",
                "#.##.####.",
                "####..#...",
                ".....##...",
                "",
                "Tile 1427:",
                "###.##.#..",
                ".#..#.##..",
                ".#.##.#..#",
                "#.#.#.##.#",
                "....#...##",
                "...##..##.",
                "...#.#####",
                ".#.####.#.",
                "..#..###.#",
                "..##.#..#.",
                "",
                "Tile 1489:",
                "##.#.#....",
                "..##...#..",
                ".##..##...",
                "..#...#...",
                "#####...#.",
                "#..#.#.#.#",
                "...#.#.#..",
                "##.#...##.",
                "..##.##.##",
                "###.##.#..",
                "",
                "Tile 2473:",
                "#....####.",
                "#..#.##...",
                "#.##..#...",
                "######.#.#",
                ".#...#.#.#",
                ".#########",
                ".###.#..#.",
                "########.#",
                "##...##.#.",
                "..###.#.#.",
                "",
                "Tile 2971:",
                "..#.#....#",
                "#...###...",
                "#.#.###...",
                "##.##..#..",
                ".#####..##",
                ".#..####.#",
                "#..#.#..#.",
                "..####.###",
                "..#.#.###.",
                "...#.#.#.#",
                "",
                "Tile 2729:",
                "...#.#.#.#",
                "####.#....",
                "..#.#.....",
                "....#..#.#",
                ".##..##.#.",
                ".#.####...",
                "####.#.#..",
                "##.####...",
                "##..#.##..",
                "#.##...##.",
                "",
                "Tile 3079:",
                "#.#.#####.",
                ".#..######",
                "..#.......",
                "######....",
                "####.#..#.",
                ".#...#.##.",
                "#.#####.##",
                "..#.###...",
                "..#.......",
                "..#.###..."
        };
        for (int i = 0; i < 9; i++) {
            Tile tile = new Tile(Arrays.copyOfRange(lines, i * 12, i * 12 + 11));
            dayTwenty.addTile(tile);
        }
        assertThat(dayTwenty.findCorners().stream().mapToLong(Tile::getId).reduce(1, (a, b) -> a * b)).isEqualTo(20899048083289L);
    }

    @Test
    void part1Solution() throws URISyntaxException, IOException {
        DayTwenty dayTwenty = new DayTwenty("day_twenty.txt");
        List<Tile> corners = dayTwenty.findCorners();
        assertThat(corners.stream().mapToLong(Tile::getId).reduce(1, (a, b) -> a * b)).isEqualTo(140656720229539L);
    }

    @Test
    void part2Solution() throws IOException, URISyntaxException {
        Tile[][] tileArray = new Tile[12][12];
        DayTwenty dayTwenty = new DayTwenty("day_twenty.txt");
        List<Tile> corners = dayTwenty.findCorners();

        Tile tileToMatch = corners.get(0);
        dayTwenty.removeFromMap(tileToMatch);
        int direction = TOP;
        tileArray[11][0] = tileToMatch;

        fillInRowOrColumn(tileArray, dayTwenty, tileToMatch, direction, 0);
        for (int rowIndex = 0; rowIndex < 12; rowIndex++) {
            fillInRowOrColumn(tileArray, dayTwenty, tileArray[rowIndex][0], RIGHT, rowIndex);
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < 120; i++) {
            for (int j = 0; j < 120; j++) {
                output.append(tileArray[i/10][j/10].getCharacter(i%10,j%10));
            }
            output.append("\n");
        }
        System.out.println(output);
    }

    private void fillInRowOrColumn(Tile[][] tileArray, DayTwenty dayTwenty, Tile tileToMatch, int direction, int startIndex) {
        int indexStart = 0;
        int increment = 0;
        Predicate<Integer> predicate = null;
        if(direction == TOP){
            indexStart = 10;
            increment = -1;
            predicate = index -> index >= 0;
        } else if (direction == RIGHT){
            indexStart = 1;
            increment = 1;
            predicate = index -> index < 12;
        }
        for (int rowOrColumnIndex = indexStart; predicate.test(rowOrColumnIndex); rowOrColumnIndex += increment) {
            Tile neighbour = dayTwenty.getUniqueMatch(tileToMatch, direction);
            rotateAndFlipTile(tileToMatch, direction, neighbour);
            
            dayTwenty.removeFromMap(neighbour);
            if(direction == TOP){
                tileArray[rowOrColumnIndex][startIndex] = neighbour;
            } else if (direction == RIGHT){
                tileArray[startIndex][rowOrColumnIndex] = neighbour;
            }
            tileToMatch = neighbour;
        }
    }

    private void rotateAndFlipTile(Tile tileToMatch, int tileToMatchEdgeIndex, Tile neighbour) {
        for (int noOfRotations = 0; noOfRotations < 8; noOfRotations++) {
            if (tileToMatch.getEdges().get(tileToMatchEdgeIndex).equals(neighbour.getEdges().get((tileToMatchEdgeIndex + 2) % 4))) {
                break;
            } else {
                neighbour.rotate();
            }
            if (noOfRotations == 3) {
                neighbour.reverse();
            }
        }
    }
}

