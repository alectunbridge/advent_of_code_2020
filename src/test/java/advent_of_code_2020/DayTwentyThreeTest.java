package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTwentyThreeTest {
    @Test
    void stringRepresentation() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(3, 8, 9, 1, 2, 5, 4, 6, 7);
        assertThat(dayTwentyThree).asString().isEqualTo("*3 8 9 1 2 5 4 6 7");
    }

    @Test
    void move() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(3, 8, 9, 1, 2, 5, 4, 6, 7);

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

        assertThat(dayTwentyThree.answer()).isEqualTo("92658374");

        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("5 8 *1 9 2 6 3 7 4");
        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("5 8 9 2 6 1 *3 7 4");
    }

    @Test
    void example100Moves() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(3, 8, 9, 1, 2, 5, 4, 6, 7);
        for (int i = 0; i < 100; i++) {
            dayTwentyThree.move();
        }
        System.out.println(dayTwentyThree);
        assertThat(dayTwentyThree.answer()).isEqualTo("67384529");
    }

    @Test
    void insertAtEnd() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(7, 2, 5, 8, 4, 1, 9, 3, 6);
        assertThat(dayTwentyThree).asString().isEqualTo("*7 2 5 8 4 1 9 3 6");

        dayTwentyThree.move();
        assertThat(dayTwentyThree).asString().isEqualTo("7 *4 1 9 3 6 2 5 8");
    }

    @Test
    void part1Solution() {
        DayTwentyThree dayTwentyThree = new DayTwentyThree(4,7,6,1,3,8,2,5,9);
        for (int i = 0; i < 100; i++) {
            dayTwentyThree.move();
        }
        assertThat(dayTwentyThree.answer()).isEqualTo("97245386");
    }

    @Test
    void part2Example() {
        DayTwentyThree dayTwentyThreePartTwo = new DayTwentyThreePartTwo(3, 8, 9, 1, 2, 5, 4, 6, 7);
        assertThat(dayTwentyThreePartTwo.getCups()).hasSize(1_000_000);
        for (int i = 0; i < 10_000_000; i++) {
            dayTwentyThreePartTwo.move();
        }
        assertThat(dayTwentyThreePartTwo.answer()).isEqualTo("934001");
    }
}
