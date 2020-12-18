package advent_of_code_2020;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayThirteen {

    private int result;
    private List<Integer> buses;

    public DayThirteen(String input) {
        String[] lines = input.split("\n");
        result = Integer.parseInt(lines[0]);
        buses = Arrays.stream(lines[1].split(","))
                .filter(field ->!"x".equals(field))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        DayThirteen dayThirteen = new DayThirteen("1004098\n" +
                "23,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,509,x,x,x,x,x,x,x,x,x,x,x,x,13,17,x,x,x,x,x,x,x,x,x,x,x,x,x,x,29,x,401,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,19");
    }

    public int getResult() {
        return result;
    }

    public List<Integer> getBuses() {
        return buses;
    }
}
