package advent_of_code_2020;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayNineteen {

    private final Rule rule;

    public DayNineteen(String ruleAsString) {
        Pattern pattern = Pattern.compile("(\\d+): (.*)");
        Matcher matcher = pattern.matcher(ruleAsString);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Can't parse rule from input: " + ruleAsString);
        }
        rule = new Rule(matcher.group(1), matcher.group(2).replaceAll("\"", ""));
    }

    public String getRegExp() {
        return rule.toString();
    }
}
