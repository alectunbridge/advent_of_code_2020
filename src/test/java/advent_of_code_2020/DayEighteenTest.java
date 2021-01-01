package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DayEighteenTest {
    @Test
    void partOneExampleNoBrackets() {
        DayEighteen dayEighteen = new DayEighteen(
                "1 + 2 * 3 + 4 * 5 + 6"
        );
        assertThat(dayEighteen.sum()).isEqualTo(71);
    }
}