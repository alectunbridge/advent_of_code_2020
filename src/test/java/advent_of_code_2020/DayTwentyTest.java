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
        DayTwenty dayTwenty = new DayTwenty("day_twenty.txt");
        List<Tile> corners = dayTwenty.findCorners();
        Tile firstCorner = corners.get(0);
        List<String> firstCornerEdges = firstCorner.getEdges();
        for (int cornerEdgeIndex = Tile.TOP; cornerEdgeIndex < Tile.LEFT; cornerEdgeIndex++) {
            String cornerEdge = firstCornerEdges.get(cornerEdgeIndex);
            Set<Tile> matchingTiles = new HashSet<>();
            matchingTiles.addAll(dayTwenty.getTilesByEdge(cornerEdge));
            matchingTiles.addAll(dayTwenty.getTilesByEdge(reverse(cornerEdge)));
            matchingTiles.remove(firstCorner);
            if (matchingTiles.size() == 1) {
                Tile neighbour = matchingTiles.iterator().next();
                List<String> neighbourEdges = neighbour.getEdges();
                for (int neighbourEdgeIndex = Tile.TOP; neighbourEdgeIndex <= Tile.LEFT; neighbourEdgeIndex++) {
                    if (cornerEdge.equals(neighbourEdges.get(neighbourEdgeIndex))) {
                        System.out.println(cornerEdgeIndex + " " + neighbourEdgeIndex);
                        System.out.println(firstCorner);
                        System.out.println(neighbour);
                    } else if (cornerEdge.equals(reverse(neighbourEdges.get(neighbourEdgeIndex)))) {
                        System.out.println(cornerEdgeIndex + " " + neighbourEdgeIndex);
                        System.out.println(firstCorner);
                        System.out.println("Flipped");
                        System.out.println(neighbour);
                    }
                }
            }
        }
    }
}
