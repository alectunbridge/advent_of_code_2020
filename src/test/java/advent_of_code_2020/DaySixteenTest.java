package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class DaySixteenTest {

    @Test
    void partOneExample() {
        DaySixteen daySixteen = new DaySixteen(
                "class: 1-3 or 5-7",
                "row: 6-11 or 33-44",
                "seat: 13-40 or 45-50",
                "",
                "your ticket:",
                "7,1,14",
                "",
                "nearby tickets:",
                "7,3,47",
                "40,4,50",
                "55,2,20",
                "38,6,12"
        );

        assertThat(daySixteen.partOneAnswer()).isEqualTo(71);
    }

    @Test
    void partOneAnswer() throws URISyntaxException, IOException {
        DaySixteen daySixteen = new DaySixteen(
                Files.readAllLines(
                        Path.of(this.getClass().getClassLoader().getResource("day_sixteen.txt").toURI())).toArray(new String[0]));
        assertThat(daySixteen.partOneAnswer()).isEqualTo(0);
    }

    @Test
    void partTwoExample() {
        DaySixteen daySixteen = new DaySixteen(
                "class: 0-1 or 4-19",
                "row: 0-5 or 8-19",
                "seat: 0-13 or 16-19",
                "",
                "your ticket:",
                "11,12,13",
                "",
                "nearby tickets:",
                "3,9,18",
                "15,1,5",
                "5,14,9");
        assertThat(daySixteen.findFieldOrder()).containsExactly("row", "class", "seat");
    }

    @Test
    void fieldOrderCheck() {
        DaySixteen daySixteen = new DaySixteen(
                "departure a: 1-3 or 10-10",
                "departure b: 1-3 or 20-20",
                "departure c: 1-3 or 30-30",
                "",
                "your ticket:",
                "3,2,1",
                "",
                "nearby tickets:",
                "1,1,20",
                "2,2,20",
                "3,10,20",
                "99,99,99");
        assertThat(daySixteen.findFieldOrder()).containsExactly("departure c","departure a","departure b");
//        assertThat(daySixteen.partTwoAnswer()).isEqualTo(6);
    }

    @Test
    void part2Answer() throws URISyntaxException, IOException {
        DaySixteen daySixteen = new DaySixteen(
                Files.readAllLines(
                        Path.of(this.getClass().getClassLoader().getResource("day_sixteen.txt").toURI())).toArray(new String[0]));
        assertThat(daySixteen.partTwoAnswer()).isEqualTo(3021381607403L);
    }
}
