package advent_of_code_2020;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

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
        DayTwenty dayTwenty = new DayTwenty("day_twenty.txt");
        List<Tile> corners = dayTwenty.findCorners();

        dayTwenty.setTile(11, 0, corners.get(0));
        dayTwenty.fillInRowOrColumn(corners.get(0), TOP, 0);
        for (int rowIndex = 0; rowIndex < 12; rowIndex++) {
            dayTwenty.fillInRowOrColumn(dayTwenty.getTile(rowIndex, 0), RIGHT, rowIndex);
        }

        System.out.println("Monsters found: " + DayTwenty.findMonsters(dayTwenty.toString()));
        String[] wholeGridAsStringArray = dayTwenty.toString().split("\n");

        int monsters = 0;
        WEIRD: while(true) {
            for (int i = 0; i < 3; i++) {
                DayTwenty.rotate(wholeGridAsStringArray);
                monsters = DayTwenty.findMonsters(Arrays.stream(wholeGridAsStringArray).collect(Collectors.joining("\n")));
                if(monsters !=0){
                    break WEIRD;
                }
            }

            for (int lineNo = 0; lineNo < wholeGridAsStringArray.length; lineNo++) {
                wholeGridAsStringArray[lineNo] = StringUtils.reverse(wholeGridAsStringArray[lineNo]);
            }
            monsters = DayTwenty.findMonsters(Arrays.stream(wholeGridAsStringArray).collect(Collectors.joining("\n")));
            if(monsters !=0){
                break WEIRD;
            }

            for (int i = 0; i < 3; i++) {
                DayTwenty.rotate(wholeGridAsStringArray);
                monsters = DayTwenty.findMonsters(Arrays.stream(wholeGridAsStringArray).collect(Collectors.joining("\n")));
                if(monsters !=0){
                    break WEIRD;
                }
            }
        }

        int totalHashes = 0;
        for (String line : wholeGridAsStringArray) {
            totalHashes += line.chars().filter(c->'#'==c).count();
        }

        int totalDots = 0;
        for (String line : wholeGridAsStringArray) {
            totalDots += line.chars().filter(c->'.'==c).count();
        }

        System.out.println(totalHashes - monsters*15);
    }

    @Test
    void findMonster() {
        assertThat(DayTwenty.findMonsters(
                "                  # \n" +
                        "#    ##    ##    ###\n" +
                        " #  #  #  #  #  #   "
        )).isEqualTo(1);
    }

    @Test
    void findMultipleMonsters() {
        assertThat(DayTwenty.findMonsters(
                        "                        #    " + "                  #    " + "\n" +
                        "      #    ##    ##    ###   " + "#    ##    ##    ###   " + "\n" +
                        "       #  #  #  #  #  #      " + " #  #  #  #  #  #      " + "\n" +
                        "                     #    " + "                  #       " + "\n" +
                        "   #    ##    ##    ###   " + "#    ##    ##    ###      " + "\n" +
                        "    #  #  #  #  #  #      " + " #  #  #  #  #  #         " + "\n"

        )).isEqualTo(4);
    }

    @Test
    void exampleMonsterCount() {
        String input =
        ".#.#..#.##...#.##..#####" + "\n" +
        "###....#.#....#..#......" + "\n" +
        "##.##.###.#.#..######..." + "\n" +
        "###.#####...#.#####.#..#" + "\n" +
        "##.#....#.##.####...#.##" + "\n" +
        "...########.#....#####.#" + "\n" +
        "....#..#...##..#.#.###.." + "\n" +
        ".####...#..#.....#......" + "\n" +
        "#..#.##..#..###.#.##...." + "\n" +
        "#.####..#.####.#.#.###.." + "\n" +
        "###.#.#...#.######.#..##" + "\n" +
        "#.####....##..########.#" + "\n" +
        "##..##.#...#...#.#.#.#.." + "\n" +
        "...#..#..#.#.##..###.###" + "\n" +
        ".#.#....#.##.#...###.##." + "\n" +
        "###.#...#..#.##.######.." + "\n" +
        ".#.#.###.##.##.#..#.##.." + "\n" +
        ".####.###.#...###.#..#.#" + "\n" +
        "..#.#..#..#.#.#.####.###" + "\n" +
        "#..####...#.#.#.###.###." + "\n" +
        "#####..#####...###....##" + "\n" +
        "#.##..#..#...#..####...#" + "\n" +
        ".#.###..##..##..####.##." + "\n" +
        "...###...##...#...#..###";
        assertThat(DayTwenty.findMonsters(input)).isEqualTo(2);


    }
}

