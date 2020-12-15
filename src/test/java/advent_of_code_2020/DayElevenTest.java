package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DayElevenTest {
    @Test
    void testExampleMove1() {
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

        String output = dayEleven.takeTurn();

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
}
