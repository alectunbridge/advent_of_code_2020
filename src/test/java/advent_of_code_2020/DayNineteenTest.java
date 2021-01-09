package advent_of_code_2020;

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
        assertThat(dayNineteen.getRegex()).isEqualTo("b");
    }
}
