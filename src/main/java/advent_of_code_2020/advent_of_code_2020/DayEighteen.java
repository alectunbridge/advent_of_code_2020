package advent_of_code_2020;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayEighteen {

    private String input;
    public static final Pattern MATCHED_BRACKETS_PATTERN = Pattern.compile("(.*)\\(([^()]*)\\)(.*)");

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

        while (input.contains(" ")) {
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
                case "*":
                    input = String.valueOf(operand1 * operand2) + matcher.group(4);
                    break;
                default:
                    throw new RuntimeException("Can't process operator: " + matcher.group(4));
            }
        }
        return input;
    }

    public long evaluate2(){
        return evaluate2(input);
    }

    public long evaluate2(String input) {
        Matcher matcher = MATCHED_BRACKETS_PATTERN.matcher(input);
        while (matcher.matches()) {
            input = matcher.group(1) + squish2(matcher.group(2)) + matcher.group(3);
            matcher = MATCHED_BRACKETS_PATTERN.matcher(input);
        }

        return Long.parseLong(squish2(input));
    }

    private String squish2(String input) {
        Matcher additionMatcher = Pattern.compile("(.*[^\\d])(\\d+ \\+ \\d+)(.*)").matcher(input);
        String rebracketedInput = "";
        while(additionMatcher.find() && additionMatcher.group(2).length() != input.length()){
            rebracketedInput += additionMatcher.group(1);
            rebracketedInput += "("+additionMatcher.group(2)+")";
            rebracketedInput += additionMatcher.group(3);
        }

        if(rebracketedInput.contains("(")){
            return String.valueOf(evaluate2(rebracketedInput));
        }

        Pattern addOrMultiplyPattern = Pattern.compile("(\\d+) ([+*]) (\\d+)(.*)");
        while (input.contains(" ")) {
            Matcher matcher = addOrMultiplyPattern.matcher(input);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Squish can't match input: " + input);
            }
            long operand1 = Long.parseLong(matcher.group(1));
            long operand2 = Long.parseLong(matcher.group(3));
            switch (matcher.group(2)) {
                case "+":
                    input = operand1 + operand2 + matcher.group(4);
                    break;
                case "*":
                    input = operand1 * operand2 + matcher.group(4);
                    break;
                default:
                    throw new RuntimeException("Can't process operator: " + matcher.group(4));
            }
        }
        return input;
    }
}
