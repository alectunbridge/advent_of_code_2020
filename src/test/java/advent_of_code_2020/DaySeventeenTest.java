package advent_of_code_2020;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DaySeventeenTest {

    @Test
    @Disabled
    void readInput() {
        DaySeventeen daySeventeen = new DaySeventeen(
                "..#..##.",
                "#.....##",
                "##.#.#.#",
                "..#...#.",
                ".###....",
                "######..",
                ".###..#.",
                "..#..##."
        );
        assertThat(daySeventeen.toString()).isEqualTo(
                "z=0, w=0\n" +
                        "..#..##.\n" +
                        "#.....##\n" +
                        "##.#.#.#\n" +
                        "..#...#.\n" +
                        ".###....\n" +
                        "######..\n" +
                        ".###..#.\n" +
                        "..#..##.\n"
        );
    }

    @Test
    void calculateNeighbours2D() {
        DaySeventeen daySeventeen = new DaySeventeen(
                ".#.",
                "..#",
                "###");

        assertThat(daySeventeen.countNeighbours(0, 0, 0, 0)).isEqualTo(1);
        assertThat(daySeventeen.countNeighbours(0, 0, 0, 1)).isEqualTo(1);
        assertThat(daySeventeen.countNeighbours(0, 0, 0, 2)).isEqualTo(2);

        assertThat(daySeventeen.countNeighbours(0, 0, 1, 0)).isEqualTo(3);
        assertThat(daySeventeen.countNeighbours(0, 0, 1, 1)).isEqualTo(5);
        assertThat(daySeventeen.countNeighbours(0, 0, 1, 2)).isEqualTo(3);

        assertThat(daySeventeen.countNeighbours(0, 0, 2, 0)).isEqualTo(1);
        assertThat(daySeventeen.countNeighbours(0, 0, 2, 1)).isEqualTo(3);
        assertThat(daySeventeen.countNeighbours(0, 0, 2, 2)).isEqualTo(2);
    }

    @Test
    void calculateNeighbours3D() {
        DaySeventeen daySeventeen = new DaySeventeen(
                ".#.",
                "..#",
                "###");

        assertThat(daySeventeen.countNeighbours(0, -1, 0, 0)).isEqualTo(1);
        assertThat(daySeventeen.countNeighbours(0, -1, 0, 1)).isEqualTo(2);
        assertThat(daySeventeen.countNeighbours(0, -1, 0, 2)).isEqualTo(2);

        assertThat(daySeventeen.countNeighbours(0, -1, 1, 0)).isEqualTo(3);
        assertThat(daySeventeen.countNeighbours(0, -1, 1, 1)).isEqualTo(5);
        assertThat(daySeventeen.countNeighbours(0, -1, 1, 2)).isEqualTo(4);

        assertThat(daySeventeen.countNeighbours(0, -1, 2, 0)).isEqualTo(2);
        assertThat(daySeventeen.countNeighbours(0, -1, 2, 1)).isEqualTo(4);
        assertThat(daySeventeen.countNeighbours(0, -1, 2, 2)).isEqualTo(3);
    }

    @Test
    void calculateNeighbours4D() {
        DaySeventeen daySeventeen = new DaySeventeen(
                ".#.",
                "..#",
                "###");

        assertThat(daySeventeen.countNeighbours(-1, 0, 0, 0)).isEqualTo(1);
        assertThat(daySeventeen.countNeighbours(-1, 0, 0, 1)).isEqualTo(2);
        assertThat(daySeventeen.countNeighbours(-1, 0, 0, 2)).isEqualTo(2);
        assertThat(daySeventeen.countNeighbours(-1, 0, 1, 0)).isEqualTo(3);
        assertThat(daySeventeen.countNeighbours(-1, 0, 1, 1)).isEqualTo(5);
        assertThat(daySeventeen.countNeighbours(-1, 0, 1, 2)).isEqualTo(4);
        assertThat(daySeventeen.countNeighbours(-1, 0, 2, 0)).isEqualTo(2);
        assertThat(daySeventeen.countNeighbours(-1, 0, 2, 1)).isEqualTo(4);
        assertThat(daySeventeen.countNeighbours(-1, 0, 2, 2)).isEqualTo(3);
    }

    @Test
    @Disabled
    void exampleCycle() {
        DaySeventeen daySeventeen = new DaySeventeen(
                ".#.",
                "..#",
                "###");
        daySeventeen.cycle();
        assertThat(daySeventeen.toString()).isEqualTo(
                "z=-1, w=0\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#...\n" +
                        "...#.\n" +
                        "..#..\n" +
                        "z=0, w=0\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#.#.\n" +
                        "..##.\n" +
                        "..#..\n" +
                        "z=1, w=0\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#...\n" +
                        "...#.\n" +
                        "..#..\n"
        );

        daySeventeen.cycle();
        assertThat(daySeventeen.toString()).isEqualTo(
                "z=-2, w=0\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        "...#...\n" +
                        ".......\n" +
                        ".......\n" +
                        "z=-1, w=0\n" +
                        ".......\n" +
                        ".......\n" +
                        "...#...\n" +
                        "..#..#.\n" +
                        ".....#.\n" +
                        "..#....\n" +
                        ".......\n" +
                        "z=0, w=0\n" +
                        ".......\n" +
                        ".......\n" +
                        ".##....\n" +
                        ".##....\n" +
                        ".#.....\n" +
                        ".....#.\n" +
                        "..###..\n" +
                        "z=1, w=0\n" +
                        ".......\n" +
                        ".......\n" +
                        "...#...\n" +
                        "..#..#.\n" +
                        ".....#.\n" +
                        "..#....\n" +
                        ".......\n" +
                        "z=2, w=0\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        ".......\n" +
                        "...#...\n" +
                        ".......\n" +
                        ".......\n"
        );

        daySeventeen.cycle();
        assertThat(daySeventeen.toString()).isEqualTo(
                "z=-3, w=0\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        "z=-2, w=0\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        "...##....\n" +
                        "...###...\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        "z=-1, w=0\n" +
                        ".........\n" +
                        ".........\n" +
                        "...#.....\n" +
                        "....#....\n" +
                        ".#.......\n" +
                        "......##.\n" +
                        "..#...#..\n" +
                        "...#.#...\n" +
                        "....#....\n" +
                        "z=0, w=0\n" +
                        ".........\n" +
                        ".........\n" +
                        "....#....\n" +
                        ".........\n" +
                        ".#.......\n" +
                        ".........\n" +
                        "......##.\n" +
                        "..##.#...\n" +
                        "....#....\n" +
                        "z=1, w=0\n" +
                        ".........\n" +
                        ".........\n" +
                        "...#.....\n" +
                        "....#....\n" +
                        ".#.......\n" +
                        "......##.\n" +
                        "..#...#..\n" +
                        "...#.#...\n" +
                        "....#....\n" +
                        "z=2, w=0\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        "...##....\n" +
                        "...###...\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        "z=3, w=0\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n" +
                        ".........\n");
    }

    @Test
    @Disabled
    void testExampleAnswerPart1() {
        DaySeventeen daySeventeen = new DaySeventeen(
                ".#.",
                "..#",
                "###");
        daySeventeen.cycle();
        daySeventeen.cycle();
        daySeventeen.cycle();

        daySeventeen.cycle();
        daySeventeen.cycle();
        daySeventeen.cycle();

        int count = 0;
        for (Character c : daySeventeen.toString().toCharArray()) {
            if ('#' == c) {
                count++;
            }
        }
        assertThat(count).isEqualTo(112);
    }

    @Test
    @Disabled
    void answerPart1() {
        DaySeventeen daySeventeen = new DaySeventeen(
                "..#..##.",
                "#.....##",
                "##.#.#.#",
                "..#...#.",
                ".###....",
                "######..",
                ".###..#.",
                "..#..##."
        );
        daySeventeen.cycle();
        daySeventeen.cycle();
        daySeventeen.cycle();

        daySeventeen.cycle();
        daySeventeen.cycle();
        daySeventeen.cycle();
        int count = 0;
        for (Character c : daySeventeen.toString().toCharArray()) {
            if ('#' == c) {
                count++;
            }
        }
        assertThat(count).isEqualTo(298);

    }

    @Test
    void testCyclePart2() {
        DaySeventeen daySeventeen = new DaySeventeen(
                ".#.",
                "..#",
                "###"
        );
        daySeventeen.cycle();
        assertThat(daySeventeen.toString()).isEqualTo(
                "z=-1, w=-1\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#...\n" +
                        "...#.\n" +
                        "..#..\n" +
                        "\n" +
                        "z=0, w=-1\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#...\n" +
                        "...#.\n" +
                        "..#..\n" +
                        "\n" +
                        "z=1, w=-1\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#...\n" +
                        "...#.\n" +
                        "..#..\n" +
                        "\n" +
                        "z=-1, w=0\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#...\n" +
                        "...#.\n" +
                        "..#..\n" +
                        "\n" +
                        "z=0, w=0\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#.#.\n" +
                        "..##.\n" +
                        "..#..\n" +
                        "\n" +
                        "z=1, w=0\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#...\n" +
                        "...#.\n" +
                        "..#..\n" +
                        "\n" +
                        "z=-1, w=1\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#...\n" +
                        "...#.\n" +
                        "..#..\n" +
                        "\n" +
                        "z=0, w=1\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#...\n" +
                        "...#.\n" +
                        "..#..\n" +
                        "\n" +
                        "z=1, w=1\n" +
                        ".....\n" +
                        ".....\n" +
                        ".#...\n" +
                        "...#.\n" +
                        "..#..\n" +
                        "\n"
        );
    }
}