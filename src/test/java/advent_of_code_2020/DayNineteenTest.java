package advent_of_code_2020;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
}
