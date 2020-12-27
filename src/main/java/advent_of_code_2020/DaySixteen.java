package advent_of_code_2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class DaySixteen {
    public static final Pattern RANGE_PATTERN = Pattern.compile("[^\\d]*(\\d+)-(\\d+) or (\\d+)-(\\d+)");

    private Set<Integer> allowedNumbers = new HashSet<>();
    private boolean readingNearbyTickets = false;
    private int total;

    public DaySixteen(String... input) {
        for (String line : input) {
            Matcher rangeMatcher = RANGE_PATTERN.matcher(line);
            if(rangeMatcher.matches()){
                for (int i = parseInt(rangeMatcher.group(1)); i <= parseInt(rangeMatcher.group(2)); i++) {
                    allowedNumbers.add(i);
                }
                for (int j = parseInt(rangeMatcher.group(3)); j <= parseInt(rangeMatcher.group(4)); j++) {
                    allowedNumbers.add(j);
                }
            } else if (readingNearbyTickets){
                Arrays.stream(line.split(","))
                        .map(Integer::valueOf)
                        .filter(number -> !allowedNumbers.contains(number))
                        .forEach(number -> total+=number);
            } else if("nearby tickets:".equals(line)){
                readingNearbyTickets = true;
            }
        }
    }

    public int partOneAnswer() {
        return total;
    }
}
