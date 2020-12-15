package advent_of_code_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DayEleven {
    private List<String> grid = new ArrayList<>();

    public DayEleven(String input) {
        grid.addAll(Arrays.asList(input.split("\n")));
    }

    public String takeTurn() {
        return toString();
    }
}
