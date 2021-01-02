package advent_of_code_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayEighteen {

    private String input;

    public DayEighteen(String input) {
        this.input = input;
    }


    public long evaluate() {
        int acc = 0;

        Pattern matchedBracketsPattern = Pattern.compile("(.*)\\(([^()]*)\\)(.*)");
        Matcher matcher = matchedBracketsPattern.matcher(input);

        while (matcher.matches()) {
            input = matcher.group(1) + squish(matcher.group(2)) + matcher.group(3);
            matcher = matchedBracketsPattern.matcher(input);
        }

        return Long.parseLong(squish(input));
    }

    private String squish(String input) {
        Pattern pattern = Pattern.compile("(\\d+) ([+-/*]) (\\d+)(.*)");

        while(input.contains(" ")) {
            Matcher matcher = pattern.matcher(input);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Squish can't match input: " + input);
            }
            long operand1 = Long.parseLong(matcher.group(1));
            long operand2 = Long.parseLong(matcher.group(3));
            switch (matcher.group(2)) {
                case "+":
                    input = String.valueOf(operand1 + operand2) + matcher.group(4);
                    break;
                case "-":
                    input = String.valueOf(operand1 - operand2) + matcher.group(4);
                    break;
                case "*":
                    input = String.valueOf(operand1 * operand2) + matcher.group(4);
                    break;
                case "/":
                    input = String.valueOf(operand1 / operand2) + matcher.group(4);
                    break;
                default:
                    throw new RuntimeException("Can't process operator: " + matcher.group(4));
            }
        }
        return input;
    }
}
