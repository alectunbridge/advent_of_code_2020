package advent_of_code_2020;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DayFifteenTest {

    @Test
    void exampleTest() {
        DayFifteen dayFifteen = new DayFifteen(0, 3, 6);

        assertThat(dayFifteen.takeTurn()).isEqualTo(0);
        assertThat(dayFifteen.takeTurn()).isEqualTo(3);
        assertThat(dayFifteen.takeTurn()).isEqualTo(6);
        assertThat(dayFifteen.takeTurn()).isEqualTo(0);
        assertThat(dayFifteen.takeTurn()).isEqualTo(3);
        assertThat(dayFifteen.takeTurn()).isEqualTo(3);
        assertThat(dayFifteen.takeTurn()).isEqualTo(1);
        assertThat(dayFifteen.takeTurn()).isEqualTo(0);
        assertThat(dayFifteen.takeTurn()).isEqualTo(4);
        assertThat(dayFifteen.takeTurn()).isEqualTo(0);
    }

    @Test
    void example2020thNumber0_3_6() {
        DayFifteen dayFifteen = new DayFifteen(0, 3, 6);

        assertThat(dayFifteen.find2020thNumber()).isEqualTo(436);
    }

    @Test
    void example2020thNumbers1_3_2() {
        DayFifteen dayFifteen = new DayFifteen(1, 3, 2);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(1);
    }

    @Test
    void example2020thNumbers2_1_3() {
        DayFifteen dayFifteen = new DayFifteen(2, 1, 3);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(10);
    }

    @Test
    void example2020thNumbers1_2_3() {
        DayFifteen dayFifteen = new DayFifteen(1, 2, 3);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(27);
    }

    @Test
    void example2020thNumbers2_3_1() {
        DayFifteen dayFifteen = new DayFifteen(2, 3, 1);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(78);
    }

    @Test
    void example2020thNumbers3_2_1() {
        DayFifteen dayFifteen = new DayFifteen(3, 2, 1);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(438);
    }

    @Test
    void example2020thNumbers3_1_2() {
        DayFifteen dayFifteen = new DayFifteen(3, 1, 2);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(1836);
    }

    @Test
    void partOneAnswer() {
        DayFifteen dayFifteen = new DayFifteen(2, 0, 6, 12, 1, 3);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(1428);
    }

    @Test
    void partTwoExample() {
        DayFifteen dayFifteen = new DayFifteen(0, 3, 6);
        assertThat(dayFifteen.find30_000_000thNumber()).isEqualTo(175594);
    }

    @Test
    void partTwoExample1() {
        assertThat(new DayFifteen(1, 3, 2).find30_000_000thNumber()).isEqualTo(2578);
    }

    @Test
    void partTwoExample2() {
        assertThat(new DayFifteen(2, 1, 3).find30_000_000thNumber()).isEqualTo(3544142);
    }

    @Test
    void partTwoExample3() {
        assertThat(new DayFifteen(1, 2, 3).find30_000_000thNumber()).isEqualTo(261214);
    }

    @Test
    void partTwoExample4() {
        assertThat(new DayFifteen(2, 3, 1).find30_000_000thNumber()).isEqualTo(6895259);
    }

    @Test
    void partTwoExample5() {
        assertThat(new DayFifteen(3, 1, 2).find30_000_000thNumber()).isEqualTo(362);
    }

    @Test
    void partTwoExample6() {
        assertThat(new DayFifteen(3, 2, 1).find30_000_000thNumber()).isEqualTo(18);
    }

    @Test
    void partTwoAnswer(){
        assertThat(new DayFifteen(2,0,6,12,1,3).find30_000_000thNumber()).isEqualTo(3718541);
    }
}