package advent_of_code_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

import static java.lang.Integer.parseInt;

public class DayEighteen {

    private List<Character> terms = new ArrayList<>();

    public DayEighteen(String input) {
        for (char c : input.toCharArray()) {
            if(c != ' '){
                terms.add(c);
            }
        }
    }

    public DayEighteen(List<Character> terms) {
        this.terms = terms;
    }

    public int evaluate() {
        BiFunction<Integer, Integer, Integer> function = (a, b) -> a + b;
        int acc = 0;
        Integer newNumber = null;
        for (int i = 0; i < terms.size(); i++) {
            char term = terms.get(i);
            switch (term) {
                case '+':
                    function = (a, b) -> a + b;
                    break;
                case '-':
                    function = (a, b) -> a - b;
                    break;
                case '*':
                    function = (a, b) -> a * b;
                    break;
                case '/':
                    function = (a, b) -> a / b;
                    break;
                case '(':
                    //push onto stack
                    return function.apply(acc, new DayEighteen(terms.subList(i+1,terms.size())).evaluate());
                case ')':
                    //do nowt;
                    break;
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    try {
                        newNumber = parseInt(Character.toString(term));
                    } catch (NumberFormatException e) {

                    }
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected token in input: " + term);
            }
            if (function != null && newNumber != null) {
                acc = function.apply(acc, newNumber);
                function = null;
                newNumber = null;
            }
        }
        return acc;
    }
}
