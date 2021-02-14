package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DayTwentyTwoTest {
    @Test
    void draw() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo(
                "Player 1:",
                "9",
                "2",
                "6",
                "3",
                "1",
                "",
                "Player 2:",
                "5",
                "8",
                "4",
                "7",
                "10"
        );
        assertThat(dayTwentyTwo.drawPlayer1()).isEqualTo(9);
        assertThat(dayTwentyTwo.getPlayerOneDeck()).containsExactly(2, 6, 3, 1);
        assertThat(dayTwentyTwo.drawPlayer2()).isEqualTo(5);
        assertThat(dayTwentyTwo.getPlayerTwoDeck()).containsExactly(8, 4, 7, 10);
    }

    @Test
    void playARoundPlayerOneWins() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo(
                "Player 1:",
                "9",
                "2",
                "6",
                "3",
                "1",
                "",
                "Player 2:",
                "5",
                "8",
                "4",
                "7",
                "10"
        );

        dayTwentyTwo.playRound();

        assertThat(dayTwentyTwo.getPlayerOneDeck()).containsExactly(
                2, 6, 3, 1, 9, 5
        );
        assertThat(dayTwentyTwo.getPlayerTwoDeck()).containsExactly(
                8, 4, 7, 10
        );
    }

    @Test
    void playARoundPlayerTwoWins() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo(
                "Player 1:",
                "2",
                "6",
                "3",
                "1",
                "9",
                "5",
                "",
                "Player 2:",
                "8",
                "4",
                "7",
                "10"
        );

        dayTwentyTwo.playRound();

        assertThat(dayTwentyTwo.getPlayerOneDeck()).containsExactly(
                6, 3, 1, 9, 5
        );
        assertThat(dayTwentyTwo.getPlayerTwoDeck()).containsExactly(
                4, 7, 10, 8, 2
        );
    }

    @Test
    void playGame() {
        DayTwentyTwo dayTwentyTwo = new DayTwentyTwo(
                "Player 1:",
                "9",
                "2",
                "6",
                "3",
                "1",
                "",
                "Player 2:",
                "5",
                "8",
                "4",
                "7",
                "10"
        );

        assertThat(dayTwentyTwo.completeGame()).isEqualTo(29);
    }

}
