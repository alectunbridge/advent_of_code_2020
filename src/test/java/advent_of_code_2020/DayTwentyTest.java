package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static org.apache.commons.lang3.StringUtils.reverse;
import static org.assertj.core.api.Assertions.assertThat;

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
        tileArray[11][0] = tileToMatch;
        int tileToMatchEdgeIndex = Tile.TOP;
        for (int i = 10; i >= 0; i--) {
            List<String> tileToMatchEdges = tileToMatch.getEdges();
            String tileToMatchEdge = tileToMatchEdges.get(tileToMatchEdgeIndex);
            Set<Tile> matchingTiles = new HashSet<>();
            matchingTiles.addAll(dayTwenty.getTilesByEdge(tileToMatchEdge));
            matchingTiles.addAll(dayTwenty.getTilesByEdge(reverse(tileToMatchEdge)));
            matchingTiles.remove(tileToMatch);
            if (matchingTiles.size() == 1) {
                Tile neighbour = matchingTiles.iterator().next();
                for (int noOfRotations = 0; noOfRotations < 8 ; noOfRotations++) {
                    if (tileToMatchEdge.equals(neighbour.getBottomRow())) {
                        tileArray[i][0] = neighbour;
                        dayTwenty.removeFromMap(neighbour);
                        tileToMatch = neighbour;
                        break;
                    } else {
                        neighbour.rotate();
                    }
                    if(noOfRotations == 3){
                        neighbour.reverse();
                    }
                }
            } else {
                throw new RuntimeException("no unique match");
            }
        }
        for (Tile[] tile : tileArray) {
            if (tile[0] != null) {
                System.out.println(tile[0]);
            }
        }
        System.out.println(
                Arrays.stream(tileArray).filter(t->t[0]!=null).count());
    }
}
