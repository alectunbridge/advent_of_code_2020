package advent_of_code_2020;

import java.util.ArrayDeque;
import java.util.Deque;

public class DayTwentyTwo {

    private Deque<Integer> playerOneDeck;
    private Deque<Integer> playerTwoDeck;

    public DayTwentyTwo(String... lines) {
        playerOneDeck = new ArrayDeque<>();
        playerTwoDeck = new ArrayDeque<>();

        Deque<Integer> activeDeck = null;
        for (String line : lines) {
            if ("Player 1:".equals(line)) {
                activeDeck = playerOneDeck;
            } else if ("Player 2:".equals(line)) {
                activeDeck = playerTwoDeck;
            } else if (!line.isBlank()) {
                activeDeck.add(Integer.valueOf(line));
            }
        }
    }

    public int drawPlayer1() {
        return playerOneDeck.remove();
    }

    public int drawPlayer2() {
        return playerTwoDeck.remove();
    }

    public boolean playRound() {
        Integer playerOneCard = drawPlayer1();
        Integer playerTwoCard = drawPlayer2();

        if (playerOneCard > playerTwoCard) {
            playerOneDeck.addLast(playerOneCard);
            playerOneDeck.addLast(playerTwoCard);
        } else {
            playerTwoDeck.addLast(playerTwoCard);
            playerTwoDeck.addLast(playerOneCard);
        }
        return playerOneDeck.isEmpty() || playerTwoDeck.isEmpty();
    }

    public Deque<Integer> getPlayerOneDeck() {
        return playerOneDeck;
    }

    public Deque<Integer> getPlayerTwoDeck() {
        return playerTwoDeck;
    }

    public int completeGame() {
        int roundCount = 1;
        while (!playRound()) {
            roundCount++;
        }

        Deque<Integer> winnersDeck = null;
        if(playerOneDeck.isEmpty()){
            winnersDeck = playerTwoDeck;
        } else {
            winnersDeck = playerOneDeck;
        }

        int score = 0;
        int multiplier = winnersDeck.size();
        for (Integer cardValue : winnersDeck) {
            score += cardValue * multiplier;
            multiplier--;
        }

        return score;
    }
}
