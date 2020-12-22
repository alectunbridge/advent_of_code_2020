package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayThirteenTest {

    @Test
    void testPart1Example() {
        DayThirteen dayThirteen = new DayThirteen("939",
                "7,13,x,x,59,x,31,19");
        assertThat(dayThirteen.getArrivalTime()).isEqualTo(939);
        assertThat(dayThirteen.getBuses()).containsExactly(7,13,59,31,19);
        assertThat(dayThirteen.getAnswer()).isEqualTo(295);
    }
}