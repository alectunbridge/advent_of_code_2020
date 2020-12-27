package advent_of_code_2020;

import java.util.HashSet;
import java.util.Set;

import static java.lang.Integer.parseInt;

public class Field {
    private final String name;

    private Set<Integer> allowedNumbers = new HashSet<>();

    public Field(String name, String from1, String to1, String from2, String to2) {
        this.name = name;
        for (int i = parseInt(from1); i <= parseInt(to1); i++) {
            allowedNumbers.add(i);
        }
        for (int j = parseInt(from2); j <= parseInt(to2); j++) {
            allowedNumbers.add(j);
        }
    }
    public String getName() {
        return name;
    }

    public Set<Integer> getAllowedNumbers() {
        return allowedNumbers;
    }
}
