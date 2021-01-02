package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DayEighteenTest {
    @Test
    void splitInput() {
        DayEighteen dayEighteen = new DayEighteen("1 + (2 + 3)");
        assertThat(dayEighteen.evaluate()).isEqualTo(6);
    }

    @Test
    void partOneExampleNoBrackets() {
        DayEighteen dayEighteen = new DayEighteen(
                "1 + 2 * 3 + 4 * 5 + 6"
        );
        assertThat(dayEighteen.evaluate()).isEqualTo(71);
    }

    @Test
    void partOneSingleSetOfBrackets() {
        DayEighteen dayEighteen = new DayEighteen(
                "1 + (2 * 3)"
        );
        assertThat(dayEighteen.evaluate()).isEqualTo(7);
    }

    @Test
    void partOneExampleWithBrackets() {
        DayEighteen dayEighteen = new DayEighteen(
                "1 + (2 * 3) + (4 * (5 + 6))"
        );
        assertThat(dayEighteen.evaluate()).isEqualTo(51);
    }

    @Test
    void part1FurtherExamples1() {
        assertThat(new DayEighteen("2 * 3 + (4 * 5)").evaluate()).isEqualTo(26);
    }

    @Test
    void part1FurtherExamples2() {
        assertThat(new DayEighteen("5 + (8 * 3 + 9 + 3 * 4 * 3)").evaluate()).isEqualTo(437);
    }

    @Test
    void part1FurtherExamples3() {
        assertThat(new DayEighteen("5 * 9 * (7 * 3 * 3 + 9 * 3 + (8 + 6 * 4))").evaluate()).isEqualTo(12240);
    }

    @Test
    void part1FurtherExamples4() {
        assertThat(new DayEighteen("((2 + 4 * 9) * (6 + 9 * 8 + 6) + 6) + 2 + 4 * 2").evaluate()).isEqualTo(13632);
    }

    @Test
    void part1BrokenExampleSubsection1() {
        assertThat(new DayEighteen("(2 + 4 * 9) * (6 + 9 * 8 + 6) + 6").evaluate()).isEqualTo(6810);
    }

    @Test
    void part1BrokenExampleSubsection2() {
        assertThat(new DayEighteen("1 + 2 * (3 + 4) + 5").evaluate()).isEqualTo(26);
    }

    @Test
    void part1Answer() throws URISyntaxException, IOException {
        List<String> lines = Files.readAllLines(Path.of(this.getClass().getClassLoader().getResource("day_eighteen.txt").toURI()));
        long total = 0;
        for (String line : lines) {
            total += new DayEighteen(line).evaluate();
        }
        assertThat(total).isEqualTo(29839238838303L);
    }

    @Test
    void part2Example1() {
        assertThat(new DayEighteen("2 * 3 + (4 * 5)").evaluate2()).isEqualTo(46);
    }
}