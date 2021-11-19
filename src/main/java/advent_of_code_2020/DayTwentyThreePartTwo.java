package advent_of_code_2020;

import java.util.Arrays;

public class DayTwentyThreePartTwo extends DayTwentyThree {
    public DayTwentyThreePartTwo(Integer... cups) {
        super(cups);
        int nextCup = Arrays.stream(cups).mapToInt(c->c).max().orElse(1) + 1;
        this.cups.put(cups[cups.length-1],nextCup);
        for (;  nextCup<1_000_000 ; nextCup++) {
            this.cups.put(nextCup, nextCup+1);
        }
        this.cups.put(1_000_000, cups[0]);
    }

    @Override
    public String answer() {
        int firstCupAfterOne = cups.get(1);
        int secondCupAfterOne = cups.get(firstCupAfterOne);
        return Long.toString(((long)firstCupAfterOne)*secondCupAfterOne);
    }
}
