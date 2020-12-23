package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static advent_of_code_2020.DayFourteen.*;
import static org.assertj.core.api.Assertions.assertThat;

class DayFourteenTest {
    @Test
    void parseMask() {
        DayFourteen dayFourteen = new DayFourteen(new MemInstructionExecutorPart1(), "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
        assertThat(dayFourteen.getMask()).isEqualTo("XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X");
    }

    @Test
    void parseWriteOperation() {
        DayFourteen dayFourteen = new DayFourteen(new MemInstructionExecutorPart1(), "mem[36932] = 186083");
        assertThat(dayFourteen.getLocation(36932)).isEqualTo(186083);
    }

    @Test
    void parseWriteWithMask() {
        DayFourteen dayFourteen = new DayFourteen(new MemInstructionExecutorPart1(), "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
        "mem[8] = 11");

        assertThat(dayFourteen.getLocation(8)).isEqualTo(73);
    }

    @Test
    void testPartOneExample() {
        DayFourteen dayFourteen = new DayFourteen(new MemInstructionExecutorPart1(), "mask = XXXXXXXXXXXXXXXXXXXXXXXXXXXXX1XXXX0X",
                "mem[8] = 11",
                "mem[7] = 101",
                "mem[8] = 0");

        assertThat(dayFourteen.sumMemoryContents()).isEqualTo(165);
    }
}