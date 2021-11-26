package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class DayTwentyFiveTest {

    @Test
    void transform() {
        DayTwentyFive dayTwentyFive = new DayTwentyFive();
        assertThat(dayTwentyFive.findLoopSize(7, 5764801)).isEqualTo(8);
        assertThat(dayTwentyFive.findLoopSize(7, 17807724)).isEqualTo(11);
        assertThat(dayTwentyFive.calculateEncryptionKey(5764801, 11)).isEqualTo(14897079);
        assertThat(dayTwentyFive.calculateEncryptionKey(17807724, 8)).isEqualTo(14897079);
    }

    @Test
    void solutionPart1() {
        DayTwentyFive dayTwentyFive = new DayTwentyFive();
        assertThat(dayTwentyFive.findLoopSize(7, 1614360)).isEqualTo(1182212);
        assertThat(dayTwentyFive.findLoopSize(7, 7734663)).isEqualTo(4744857);
        assertThat(dayTwentyFive.calculateEncryptionKey(1614360, 4744857)).isEqualTo(5414549);
        assertThat(dayTwentyFive.calculateEncryptionKey(7734663, 1182212)).isEqualTo(5414549);

    }
}
