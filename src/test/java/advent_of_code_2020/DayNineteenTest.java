package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class DayNineteenTest {
    @Test
    void parseSingleRule() {
        DayNineteen dayNineteen = new DayNineteen("0: \"a\"");
        assertThat(dayNineteen.getRegex()).isEqualTo("a");
    }

    @Test
    void parseMultipleRules() {
        DayNineteen dayNineteen = new DayNineteen("0: \"1\"", "1: \"b\"");
        assertThat(dayNineteen.getRegex()).isEqualTo("(b)");
    }

    @Test
    void part1Example1() {
        DayNineteen dayNineteen = new DayNineteen(
                "0: 1 2",
                "1: \"a\"",
                "2: 1 3 | 3 1",
                "3: \"b\""
        );
        assertThat(dayNineteen.getRegex()).isEqualTo("(a)((a)(b)|(b)(a))");
    }

    @Test
    void part1Example2() {
        DayNineteen dayNineteen = new DayNineteen(
                "0: 4 1 5",
                "1: 2 3 | 3 2",
                "2: 4 4 | 5 5",
                "3: 4 5 | 5 4",
                "4: \"a\"",
                "5: \"b\""
        );
        assertThat(dayNineteen.getRegex()).isEqualTo("(a)(((a)(a)|(b)(b))((a)(b)|(b)(a))|((a)(b)|(b)(a))((a)(a)|(b)(b)))(b)");
    }

    @Test
    void parseRulesAndInputStrings() {
        DayNineteen dayNineteen = new DayNineteen(
                "0: \"a\"",
                "",
                "a",
                "b");
        assertThat(dayNineteen.getRegex()).isEqualTo("a");
        assertThat(dayNineteen.getCountOfMatchingStrings()).isEqualTo(1L);
    }

    @Test
    void part1ExampleCountValidStrings() {
        DayNineteen dayNineteen = new DayNineteen(
                "0: 4 1 5",
                "1: 2 3 | 3 2",
                "2: 4 4 | 5 5",
                "3: 4 5 | 5 4",
                "4: \"a\"",
                "5: \"b\"",
                "",
                "ababbb",
                "bababa",
                "abbbab",
                "aaabbb",
                "aaaabbb"
        );

        assertThat(dayNineteen.getCountOfMatchingStrings()).isEqualTo(2L);
    }

    @Test
    void part1Answer() throws URISyntaxException, IOException {
        String[] lines = Files.readAllLines(Path.of(this.getClass().getClassLoader().getResource("day_nineteen.txt").toURI())).toArray(new String[0]);
        DayNineteen dayNineteen = new DayNineteen(lines);
        assertThat(dayNineteen.getCountOfMatchingStrings()).isEqualTo(0L);
    }
}
