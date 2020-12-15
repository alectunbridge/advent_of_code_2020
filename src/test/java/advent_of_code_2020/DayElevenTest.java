package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DayElevenTest {
    @Test
    void testExampleRound1() {
        DayEleven dayEleven = new DayEleven(
                   "L.LL.LL.LL" + "\n" +
                        "LLLLLLL.LL" + "\n" +
                        "L.L.L..L.." + "\n" +
                        "LLLL.LL.LL" + "\n" +
                        "L.LL.LL.LL" + "\n" +
                        "L.LLLLL.LL" + "\n" +
                        "..L.L....." + "\n" +
                        "LLLLLLLLLL" + "\n" +
                        "L.LLLLLL.L" + "\n" +
                        "L.LLLLL.LL"
        );

        String output = dayEleven.nextRound();

        assertThat(output).isEqualTo(
                        "#.##.##.##" + "\n" +
                        "#######.##" + "\n" +
                        "#.#.#..#.." + "\n" +
                        "####.##.##" + "\n" +
                        "#.##.##.##" + "\n" +
                        "#.#####.##" + "\n" +
                        "..#.#....." + "\n" +
                        "##########" + "\n" +
                        "#.######.#" + "\n" +
                        "#.#####.##"
        );
    }

    @Test
    void testExampleRound2() {
        DayEleven dayEleven = new DayEleven(
                   "#.##.##.##" + "\n" +
                        "#######.##" + "\n" +
                        "#.#.#..#.." + "\n" +
                        "####.##.##" + "\n" +
                        "#.##.##.##" + "\n" +
                        "#.#####.##" + "\n" +
                        "..#.#....." + "\n" +
                        "##########" + "\n" +
                        "#.######.#" + "\n" +
                        "#.#####.##"
        );

        String output = dayEleven.nextRound();

        assertThat(output).isEqualTo(
                       "#.LL.L#.##" + "\n" +
                       "#LLLLLL.L#" + "\n" +
                       "L.L.L..L.." + "\n" +
                       "#LLL.LL.L#" + "\n" +
                       "#.LL.LL.LL" + "\n" +
                       "#.LLLL#.##" + "\n" +
                       "..L.L....." + "\n" +
                       "#LLLLLLLL#" + "\n" +
                       "#.LLLLLL.L" + "\n" +
                       "#.#LLLL.##"
        );
    }
}
