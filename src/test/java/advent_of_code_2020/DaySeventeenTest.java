package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DaySeventeenTest {

    @Test
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

        assertThat(daySeventeen.countNeighbours(0, 0,0)).isEqualTo(1);
        assertThat(daySeventeen.countNeighbours(0, 0,1)).isEqualTo(1);
        assertThat(daySeventeen.countNeighbours(0, 0,2)).isEqualTo(2);

        assertThat(daySeventeen.countNeighbours(0, 1,0)).isEqualTo(3);
        assertThat(daySeventeen.countNeighbours(0, 1,1)).isEqualTo(5);
        assertThat(daySeventeen.countNeighbours(0, 1,2)).isEqualTo(3);

        assertThat(daySeventeen.countNeighbours(0, 2,0)).isEqualTo(1);
        assertThat(daySeventeen.countNeighbours(0, 2,1)).isEqualTo(3);
        assertThat(daySeventeen.countNeighbours(0, 2,2)).isEqualTo(2);
    }

    @Test
    void calculateNeighbours3D() {
        DaySeventeen daySeventeen = new DaySeventeen(
                ".#.",
                "..#",
                "###");

        assertThat(daySeventeen.countNeighbours(-1, 0,0)).isEqualTo(1);
        assertThat(daySeventeen.countNeighbours(-1, 0,1)).isEqualTo(2);
        assertThat(daySeventeen.countNeighbours(-1, 0,2)).isEqualTo(2);

        assertThat(daySeventeen.countNeighbours(-1, 1,0)).isEqualTo(3);
        assertThat(daySeventeen.countNeighbours(-1, 1,1)).isEqualTo(5);
        assertThat(daySeventeen.countNeighbours(-1, 1,2)).isEqualTo(4);

        assertThat(daySeventeen.countNeighbours(-1, 2,0)).isEqualTo(2);
        assertThat(daySeventeen.countNeighbours(-1, 2,1)).isEqualTo(4);
        assertThat(daySeventeen.countNeighbours(-1, 2,2)).isEqualTo(3);
    }
}