package advent_of_code_2020;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Integer.parseInt;

public class DayNineteen {

    private final List<String> inputStrings;
    private List<Rule> rules;
    private String masterRule;
    private Map<String, String> cache;

    public DayNineteen(String... rulesAsStrings) {
        Pattern pattern = Pattern.compile("(\\d+): (.*)");
        rules = new ArrayList<>();
        inputStrings = new ArrayList<>();
        cache = new HashMap<>();
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
        for (Rule rule : rules) {
            System.out.println(rule);
        }
    }

    public String getRegex(Rule rule) {
        String ruleRegex = rule.getRegex();
        while (ruleRegex.matches(".*\\d.*")) {
            String[] ruleNumbers = ruleRegex.split(" ");
            Arrays.sort(ruleNumbers, (a,b)->{
                if(a.matches("\\d+") && b.matches("\\d+")){
                    return Integer.parseInt(a)-Integer.parseInt(b);
                }
                return 0;
            });
            for (int i = ruleNumbers.length - 1; i >= 0; i--) {
                String ruleNumber = ruleNumbers[i];
                String subRuleRegex;
                if (ruleNumber.matches("\\d+")) {
                    if(cache.containsKey(ruleNumber)){
                        subRuleRegex = cache.get(ruleNumber);
                    } else {
                        subRuleRegex = rules.get(parseInt(ruleNumber)).getRegex();
                    }
                    String expandedRegex = ruleRegex.replaceAll(ruleNumber, "( " + subRuleRegex + " )");
                    if (!expandedRegex.matches(".*\\d.*")) {
                        cache.put(""+rule.getRuleNo(), expandedRegex);
                        ruleRegex = expandedRegex;
                        break;
                    }
                    ruleRegex = expandedRegex;
                }
            }
        }
        return ruleRegex.replaceAll(" ", "");
    }

    public long getCountOfMatchingStrings() {
        return inputStrings.stream().filter(s -> s.matches(getRegex())).count();
    }

    public String getRegex() {
        if (masterRule == null) {
            for (int i = rules.size()-1; i >= 0; i--) {
                getRegex(rules.get(i));
            }
            masterRule = getRegex(rules.get(0));
        }
        return masterRule;
    }
}
