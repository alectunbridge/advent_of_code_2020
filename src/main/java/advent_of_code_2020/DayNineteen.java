package advent_of_code_2020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class DayNineteen {

    private final List<String> inputStrings;
    private List<Rule> rules;
    private String masterRule;

    public DayNineteen(String... rulesAsStrings) {
        Pattern pattern = Pattern.compile("(\\d+): (.*)");
        rules = new ArrayList<>();
        inputStrings = new ArrayList<>();
        for (String ruleAsString : rulesAsStrings) {
            Matcher matcher = pattern.matcher(ruleAsString);
            if (matcher.matches()) {
                rules.add(new Rule(matcher.group(1), matcher.group(2).replaceAll("\"", "")));
            } else {
                if (ruleAsString.matches("")) {
                    //do nowt
                } else if (ruleAsString.matches("[ab]+")) {
                    inputStrings.add(ruleAsString);
                } else {
                    throw new IllegalArgumentException("Can't parse rule from input: " + ruleAsString);
                }
            }
        }
        rules.sort(Comparator.comparing(Rule::getRuleNo));
    }

    public String getRegex() {
        if(masterRule == null) {
            masterRule = rules.get(0).getRegex();
            int count = 0;
            while (masterRule.matches(".*\\d.*")) {
                count++;
                System.out.println(count);
                String[] ruleNumbers = masterRule.split(" ");
                Arrays.sort(ruleNumbers);
                for (int i = ruleNumbers.length - 1; i >= 0; i--) {
                    String ruleNumber = ruleNumbers[i];
                    if (ruleNumber.matches("\\d+")) {
                        masterRule = masterRule.replaceAll(ruleNumber, "( " + rules.get(parseInt(ruleNumber)).getRegex() + " )");
                    }
                }
            }
            return masterRule.replaceAll(" ", "");
        }
        return masterRule.replaceAll(" ", "");
    }

    public long getCountOfMatchingStrings() {
        return inputStrings.stream().filter(s->s.matches(getRegex())).count();
    }
}
