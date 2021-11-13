package advent_of_code_2020;

public class Result {
    private Integer winningPlayerNo;
    private int score;

    public Result(Integer winningPlayerNo, int score) {
        this.winningPlayerNo = winningPlayerNo;
        this.score = score;
    }

    public Integer getWinningPlayerNo() {
        return winningPlayerNo;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Result{" +
                "winningPlayerNo=" + winningPlayerNo +
                ", score=" + score +
                '}';
    }
}
