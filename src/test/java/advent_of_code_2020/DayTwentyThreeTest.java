package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTwentyThreeTest {
    @Test
    void stringRepresentation() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(3,8,9,1,2,5,4,6,7);
        assertThat(dayTwentyThree).asString().isEqualTo("*3 8 9 1 2 5 4 6 7");
    }

    @Test
    void move() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(3,8,9,1,2,5,4,6,7);

        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("3 *2 8 9 1 5 4 6 7");
        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("3 2 *5 4 6 7 8 9 1");
        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("3 4 6 7 2 5 *8 9 1");

        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("*4 6 7 9 1 3 2 5 8");
        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("4 *1 3 6 7 9 2 5 8");
        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("4 1 *9 3 6 7 2 5 8");

        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("4 1 9 *2 5 8 3 6 7");
        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("4 1 5 8 3 9 2 *6 7");
        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("*5 7 4 1 8 3 9 2 6");

        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("5 *8 3 7 4 1 9 2 6");
    }
}
