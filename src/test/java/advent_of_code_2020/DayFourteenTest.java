package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayFourteenTest {
    @Test
    void parseMask() {
        DayFourteen dayFourteen = new DayFourteen("mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
        assertThat(dayFourteen.getMask()).isEqualTo("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
    }

    @Test
    void parseWriteOperation() {
        DayFourteen dayFourteen = new DayFourteen("mem[36932] = 186083");
        assertThat(dayFourteen.getLocation(36932)).isEqualTo(186083);
    }
}