package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

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
}
