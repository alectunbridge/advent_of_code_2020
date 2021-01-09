package advent_of_code_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class DayNineteen {

    private List<Rule> rules;

    public DayNineteen(String... rulesAsStrings) {
        Pattern pattern = Pattern.compile("(\\d+): (.*)");
        rules = new ArrayList<>();
        for (String ruleAsString : rulesAsStrings) {
            Matcher matcher = pattern.matcher(ruleAsString);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Can't parse rule from input: " + ruleAsString);
            }
            rules.add(new Rule(matcher.group(1), matcher.group(2).replaceAll("\"", "")));
        }
        rules.sort(Comparator.comparing(Rule::getRuleNo));
    }

    public String getRegex() {
        String masterRule = rules.get(0).getRegex();
        while (masterRule.matches(".*\\d.*")){
            String[] ruleNumbers = masterRule.split(" ");
            Arrays.sort(ruleNumbers);
            for (int i = ruleNumbers.length-1; i>=0; i--) {
                String ruleNumber = ruleNumbers[i];
                if (ruleNumber.matches("\\d+")) {
                    masterRule = masterRule.replaceAll(ruleNumber, "( "+rules.get(parseInt(ruleNumber)).getRegex()+" )");
                }
            }
        }
        return masterRule.replaceAll(" ","");
    }
}
