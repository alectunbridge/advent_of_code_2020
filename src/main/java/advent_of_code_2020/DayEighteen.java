package advent_of_code_2020;

import org.apache.commons.math3.FieldElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

import static java.lang.Integer.parseInt;

public class DayEighteen {

    private final String[] terms;

    public DayEighteen(String input) {
        terms = input.split(" ");
    }

    public int sum() {
        BiFunction<Integer,Integer,Integer> function = (a,b) -> a+b;
        int total = 0;
        Integer newNumber = null;
        for (String term : terms) {
            switch (term) {
                case "+":
                    function = (a,b)-> a+b;
                    break;
                case "-":
                    function = (a,b) -> a-b;
                    break;
                case "*":
                    function = (a,b) -> a*b;
                    break;
                case "/":
                    function = (a,b) -> a/b;
                    break;
                default:
                    try {
                        newNumber = parseInt(term);
                    } catch (NumberFormatException e) {

                    }
                    break;
            }
            if(function != null && newNumber != null){
                total = function.apply(total,newNumber);
                function = null;
                newNumber = null;
            }
        }
        return total;
    }
}
