package advent_of_code_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayTwentyThree {
    private List<Integer> cups;

    public DayTwentyThree(Integer... cups) {
        this.cups = new ArrayList<>();
        this.cups.addAll(Arrays.asList(cups));
    }

    @Override
    public String toString() {
        return cups.stream().map(Object::toString).collect(Collectors.joining(" "));
    }
}
