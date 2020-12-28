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
}