package advent_of_code_2020;

public class Rule {
    private final int ruleNo;
    private final String regex;

    public Rule(String ruleNo, String regex) {
        this.ruleNo = Integer.parseInt(ruleNo);
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public int getRuleNo() {
        return ruleNo;
    }

    @Override
    public String toString() {
        return ruleNo + ": " + regex;
    }
}
