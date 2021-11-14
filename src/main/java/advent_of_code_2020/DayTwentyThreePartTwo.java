package advent_of_code_2020;

import java.util.Arrays;

public class DayTwentyThreePartTwo extends DayTwentyThree {
    public DayTwentyThreePartTwo(Integer... cups) {
        super();
        this.cups.addAll(Arrays.asList(cups));
        int nextCup = Arrays.stream(cups).mapToInt(c->c).max().orElse(1) + 1;
        for (;  nextCup<=1_000_000 ; nextCup++) {
            this.cups.add(nextCup);
        }
    }

    @Override
    public String answer() {
        return cups.get(cups.indexOf(1)+1).toString();
    }
}
