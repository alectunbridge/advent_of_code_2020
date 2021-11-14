package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTwentyThreeTest {
    @Test
    void name() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(3,8,9,1,2,5,4,6,7);
        assertThat(dayTwentyThree).asString().isEqualTo("3 8 9 1 2 5 4 6 7");
    }
}
