package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayNineteenTest {
    @Test
    void parseRule() {
        DayNineteen dayNineteen = new DayNineteen("0: \"a\"");
        assertThat(dayNineteen.getRegExp()).isEqualTo("a");
    }
}
