package advent_of_code_2020;

import org.junit.jupiter.api.Test;

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

    @Test
    void testPart2Example() {
        DayFourteen dayFourteen = new DayFourteen(new MemInstructionExecutorPart2(),
                "mask = 000000000000000000000000000000X1001X",
                "mem[42] = 100");

        assertThat(dayFourteen.getLocation(42)).isEqualTo(0);
        assertThat(dayFourteen.getLocation(26)).isEqualTo(100);
        assertThat(dayFourteen.getLocation(27)).isEqualTo(100);
        assertThat(dayFourteen.getLocation(58)).isEqualTo(100);
        assertThat(dayFourteen.getLocation(59)).isEqualTo(100);
    }

    @Test
    void maskingForPart2() {
        MemInstructionExecutorPart2 memInstructionExecutorPart2 = new MemInstructionExecutorPart2();
        assertThat(memInstructionExecutorPart2.replaceXs("XX")).containsExactly("00", "01", "10", "11");
    }
}