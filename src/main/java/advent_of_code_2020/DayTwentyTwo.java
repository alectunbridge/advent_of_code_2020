package advent_of_code_2020;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class DayTwentyTwo {

    private Deque<Integer> playerOneDeck;
    private Deque<Integer> playerTwoDeck;
    private List<String> previousStates;

    public DayTwentyTwo(String... lines) {
        previousStates = new ArrayList<>();
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

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Player 1:\n");
        playerOneDeck.forEach(card->result.append(card+"\n"));
        result.append("Player 2:\n");
        playerTwoDeck.forEach(card->result.append(card+"\n"));
        return result.toString();
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

    public int completeRecursiveGame() {
        int roundCount = 1;
        Integer winningPlayerNo = null;
        do{
            winningPlayerNo = playRecursiveRound();
            roundCount++;
        } while (winningPlayerNo == null);


        int score = 0;
        Deque<Integer> winnersDeck;
        if(winningPlayerNo==1){
            winnersDeck = playerOneDeck;
        } else {
            winnersDeck = playerTwoDeck;
        }
        int multiplier = winnersDeck.size();
        for (Integer cardValue : winnersDeck) {
            score += cardValue * multiplier;
            multiplier--;
        }

        return score;
    }

    private Integer playRecursiveRound() {
        System.out.println(this);
        String currentState = playerOneDeck.toString() + playerTwoDeck.toString();
        if(previousStates.contains(currentState)){
            return 1;
        } else {
            previousStates.add(currentState);
        }

        Integer playerOneCard = drawPlayer1();
        Integer playerTwoCard = drawPlayer2();

        if(playerOneDeck.size()<playerOneCard || playerTwoDeck.size()<playerTwoCard) {
            if (playerOneCard > playerTwoCard) {
                playerOneDeck.addLast(playerOneCard);
                playerOneDeck.addLast(playerTwoCard);
            } else {
                playerTwoDeck.addLast(playerTwoCard);
                playerTwoDeck.addLast(playerOneCard);
            }
        } else {
            //recurse
            System.out.println("recurse");
            StringBuilder result = new StringBuilder();
            result.append("Player 1:\n");
            playerOneDeck.stream().limit(playerOneCard).forEach(card->result.append(card+"\n"));
            result.append("Player 2:\n");
            playerTwoDeck.stream().limit(playerTwoCard).forEach(card->result.append(card+"\n"));
            String s = result.toString();
            String[] split = s.replaceAll("[]\\]\\[]", "").split("\n");
            int winnerOfSubGame =  new DayTwentyTwo(split).completeRecursiveGame();
            if (winnerOfSubGame==1) {
                playerOneDeck.addLast(playerOneCard);
                playerOneDeck.addLast(playerTwoCard);
            } else {
                playerTwoDeck.addLast(playerTwoCard);
                playerTwoDeck.addLast(playerOneCard);
            }
        }

        Integer winnersDeck = null;
        if(playerOneDeck.isEmpty()){
            winnersDeck = 2;
        }
        if(playerTwoDeck.isEmpty()) {
            winnersDeck = 1;
        }

        return winnersDeck;
    }
}
