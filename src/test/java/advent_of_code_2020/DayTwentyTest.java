package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

import static advent_of_code_2020.Tile.RIGHT;
import static advent_of_code_2020.Tile.TOP;
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
        DayTwenty dayTwenty = new DayTwenty("day_twenty.txt");
        List<Tile> corners = dayTwenty.findCorners();

        dayTwenty.setTile(11,0,corners.get(0));
        dayTwenty.fillInRowOrColumn(corners.get(0), TOP, 0);
        for (int rowIndex = 0; rowIndex < 12; rowIndex++) {
            dayTwenty.fillInRowOrColumn(dayTwenty.getTile(rowIndex,0), RIGHT, rowIndex);
        }

        System.out.println(dayTwenty);
    }

    @Test
    void findMonster() {
        assertThat(DayTwenty.findMonster(
        "                  # \n" +
             "#    ##    ##    ###\n" +
             " #  #  #  #  #  #   "
        )).isTrue();
    }
}

