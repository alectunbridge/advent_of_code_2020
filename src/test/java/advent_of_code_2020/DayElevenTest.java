package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

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

    @Test
    void testExampleRound3() {
        DayEleven dayEleven = new DayEleven(
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

        String output = dayEleven.nextRound();

        assertThat(output).isEqualTo(
                "#.##.L#.##" + "\n" +
                        "#L###LL.L#" + "\n" +
                        "L.#.#..#.." + "\n" +
                        "#L##.##.L#" + "\n" +
                        "#.##.LL.LL" + "\n" +
                        "#.###L#.##" + "\n" +
                        "..#.#....." + "\n" +
                        "#L######L#" + "\n" +
                        "#.LL###L.L" + "\n" +
                        "#.#L###.##"
        );
    }

    @Test
    void testFindNumberOfOccupiedSeatsInExample() {
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

        int occupiedSeats = dayEleven.findNumberOfOccupiedSeats();

        assertThat(occupiedSeats).isEqualTo(37);
    }

    @Test
    public void answerPart1() throws URISyntaxException, IOException {
        assertThat(new DayEleven(Files.readString(Path.of(this.getClass().getClassLoader().getResource("day_eleven.txt").toURI())))
                .findNumberOfOccupiedSeats()).isEqualTo(2093);
    }

}
