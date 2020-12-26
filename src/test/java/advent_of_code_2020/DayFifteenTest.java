package advent_of_code_2020;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class DayFifteenTest {
    
    @Test
    void exampleTest(){
        DayFifteen dayFifteen = new DayFifteen(0,3,6);

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
    void example2020thNumber0_3_6(){
        DayFifteen dayFifteen = new DayFifteen(0,3,6);

        assertThat(dayFifteen.find2020thNumber()).isEqualTo(436);
    }

    @Test
    void example2020thNumbers1_3_2(){
        DayFifteen dayFifteen = new DayFifteen(1,3,2);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(1);
    }

    @Test
    void example2020thNumbers2_1_3(){
        DayFifteen dayFifteen = new DayFifteen(2,1,3);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(10);
    }

    @Test
    void example2020thNumbers1_2_3(){
        DayFifteen dayFifteen = new DayFifteen(1,2,3);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(27);
    }

    @Test
    void example2020thNumbers2_3_1(){
        DayFifteen dayFifteen = new DayFifteen(2,3,1);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(78);
    }

    @Test
    void example2020thNumbers3_2_1(){
        DayFifteen dayFifteen = new DayFifteen(3,2,1);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(438);
    }

    @Test
    void example2020thNumbers3_1_2(){
        DayFifteen dayFifteen = new DayFifteen(3,1,2);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(1836);
    }

    @Test
    void partOneAnswer(){
        DayFifteen dayFifteen = new DayFifteen(2,0,6,12,1,3);
        assertThat(dayFifteen.find2020thNumber()).isEqualTo(0);
    }

}