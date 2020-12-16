package advent_of_code_2020;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DayElevenTest {
//    @Test
//    void testExampleRound1() {
//        DayEleven dayEleven = new DayEleven(
//                "L.LL.LL.LL" + "\n" +
//                        "LLLLLLL.LL" + "\n" +
//                        "L.L.L..L.." + "\n" +
//                        "LLLL.LL.LL" + "\n" +
//                        "L.LL.LL.LL" + "\n" +
//                        "L.LLLLL.LL" + "\n" +
//                        "..L.L....." + "\n" +
//                        "LLLLLLLLLL" + "\n" +
//                        "L.LLLLLL.L" + "\n" +
//                        "L.LLLLL.LL"
//        );
//
//        String output = dayEleven.nextRound();
//
//        assertThat(output).isEqualTo(
//                "#.##.##.##" + "\n" +
//                        "#######.##" + "\n" +
//                        "#.#.#..#.." + "\n" +
//                        "####.##.##" + "\n" +
//                        "#.##.##.##" + "\n" +
//                        "#.#####.##" + "\n" +
//                        "..#.#....." + "\n" +
//                        "##########" + "\n" +
//                        "#.######.#" + "\n" +
//                        "#.#####.##"
//        );
//    }
//
//    @Test
//    void testExampleRound2() {
//        DayEleven dayEleven = new DayEleven(
//                "#.##.##.##" + "\n" +
//                        "#######.##" + "\n" +
//                        "#.#.#..#.." + "\n" +
//                        "####.##.##" + "\n" +
//                        "#.##.##.##" + "\n" +
//                        "#.#####.##" + "\n" +
//                        "..#.#....." + "\n" +
//                        "##########" + "\n" +
//                        "#.######.#" + "\n" +
//                        "#.#####.##"
//        );
//
//        String output = dayEleven.nextRound();
//
//        assertThat(output).isEqualTo(
//                "#.LL.L#.##" + "\n" +
//                        "#LLLLLL.L#" + "\n" +
//                        "L.L.L..L.." + "\n" +
//                        "#LLL.LL.L#" + "\n" +
//                        "#.LL.LL.LL" + "\n" +
//                        "#.LLLL#.##" + "\n" +
//                        "..L.L....." + "\n" +
//                        "#LLLLLLLL#" + "\n" +
//                        "#.LLLLLL.L" + "\n" +
//                        "#.#LLLL.##"
//        );
//    }
//
//    @Test
//    void testExampleRound3() {
//        DayEleven dayEleven = new DayEleven(
//                "#.LL.L#.##" + "\n" +
//                        "#LLLLLL.L#" + "\n" +
//                        "L.L.L..L.." + "\n" +
//                        "#LLL.LL.L#" + "\n" +
//                        "#.LL.LL.LL" + "\n" +
//                        "#.LLLL#.##" + "\n" +
//                        "..L.L....." + "\n" +
//                        "#LLLLLLLL#" + "\n" +
//                        "#.LLLLLL.L" + "\n" +
//                        "#.#LLLL.##"
//        );
//
//        String output = dayEleven.nextRound();
//
//        assertThat(output).isEqualTo(
//                "#.##.L#.##" + "\n" +
//                        "#L###LL.L#" + "\n" +
//                        "L.#.#..#.." + "\n" +
//                        "#L##.##.L#" + "\n" +
//                        "#.##.LL.LL" + "\n" +
//                        "#.###L#.##" + "\n" +
//                        "..#.#....." + "\n" +
//                        "#L######L#" + "\n" +
//                        "#.LL###L.L" + "\n" +
//                        "#.#L###.##"
//        );
//    }
//
//    @Test
//    void testFindNumberOfOccupiedSeatsInExample() throws InterruptedException {
//        DayEleven dayEleven = new DayEleven(
//                "L.LL.LL.LL" + "\n" +
//                        "LLLLLLL.LL" + "\n" +
//                        "L.L.L..L.." + "\n" +
//                        "LLLL.LL.LL" + "\n" +
//                        "L.LL.LL.LL" + "\n" +
//                        "L.LLLLL.LL" + "\n" +
//                        "..L.L....." + "\n" +
//                        "LLLLLLLLLL" + "\n" +
//                        "L.LLLLLL.L" + "\n" +
//                        "L.LLLLL.LL"
//        );
//
//        int occupiedSeats = dayEleven.findNumberOfOccupiedSeats();
//
//        assertThat(occupiedSeats).isEqualTo(37);
//    }
//
//    @Test
//    public void answerPart1() throws URISyntaxException, IOException, InterruptedException {
//        assertThat(new DayEleven(Files.readString(Path.of(this.getClass().getClassLoader().getResource("day_eleven.txt").toURI())))
//                .findNumberOfOccupiedSeats()).isEqualTo(2093);
//    }

    @Test
    void countNeighboursPart2Example1() {
        DayEleven dayEleven = new DayEleven(
                ".......#." + "\n" +
                        "...#....." + "\n" +
                        ".#......." + "\n" +
                        "........." + "\n" +
                        "..#L....#" + "\n" +
                        "....#...." + "\n" +
                        "........." + "\n" +
                        "#........" + "\n" +
                        "...#....."
        );

        assertThat(dayEleven.countNeighboursPart2(4, 3)).isEqualTo(8);
    }

    @Test
    void countNeighboursPart2Example2() {
        DayEleven dayEleven = new DayEleven(
                "............." + "\n" +
                        ".L.L.#.#.#.#." + "\n" +
                        ".............",
                5);
        assertThat(dayEleven.countNeighboursPart2(1, 1)).isEqualTo(0);
    }


    @Test
    void countNeighboursPart2Example3() {
        DayEleven dayEleven = new DayEleven(
                ".##.##." + "\n" +
                "#.#.#.#" + "\n" +
                "##...##" + "\n" +
                "...L..." + "\n" +
                "##...##" + "\n" +
                "#.#.#.#" + "\n" +
                ".##.##.",
                5);

        assertThat(dayEleven.countNeighboursPart2(3,3)).isEqualTo(0);
    }

    @Test
    void testNeighbourCountPart2() {
        DayEleven dayEleven = new DayEleven(
                "#.##.##.##\n" +
                        "#######.##\n" +
                        "#.#.#..#..\n" +
                        "####.##.##\n" +
                        "#.##.##.##\n" +
                        "#.#####.##\n" +
                        "..#.#.....\n" +
                        "##########\n" +
                        "#.######.#\n" +
                        "#.#####.##",
                5);

        assertThat(dayEleven.countNeighboursPart2(0,2)).isEqualTo(5);
    }

    @Test
    void testIndividualRoundsPart2() {
        DayEleven dayEleven = new DayEleven(
                "#.##.##.##\n" +
                        "#######.##\n" +
                        "#.#.#..#..\n" +
                        "####.##.##\n" +
                        "#.##.##.##\n" +
                        "#.#####.##\n" +
                        "..#.#.....\n" +
                        "##########\n" +
                        "#.######.#\n" +
                        "#.#####.##",
                5);

        assertThat(dayEleven.nextRound()).isEqualTo(
                "#.LL.LL.L#\n" +
                        "#LLLLLL.LL\n" +
                        "L.L.L..L..\n" +
                        "LLLL.LL.LL\n" +
                        "L.LL.LL.LL\n" +
                        "L.LLLLL.LL\n" +
                        "..L.L.....\n" +
                        "LLLLLLLLL#\n" +
                        "#.LLLLLL.L\n" +
                        "#.LLLLL.L#");
    }

    @Test
    void countOccupiedSeatsPart2Example() throws InterruptedException {
        DayEleven dayEleven = new DayEleven(
                "L.LL.LL.LL" + "\n" +
                        "LLLLLLL.LL" + "\n" +
                        "L.L.L..L.." + "\n" +
                        "LLLL.LL.LL" + "\n" +
                        "L.LL.LL.LL" + "\n" +
                        "L.LLLLL.LL" + "\n" +
                        "..L.L....." + "\n" +
                        "LLLLLLLLLL" + "\n" +
                        "L.LLLLLL.L",
                5
        );

        assertThat(dayEleven.findNumberOfOccupiedSeats()).isEqualTo(26);
    }

    @Test
    void answerToPart2() throws URISyntaxException, IOException, InterruptedException {
        DayEleven dayEleven = new DayEleven(
                Files.readString(Path.of(this.getClass().getClassLoader().getResource("day_eleven.txt").toURI())),
                5
        );

        assertThat(dayEleven.findNumberOfOccupiedSeats()).isEqualTo(1862);
    }
}
