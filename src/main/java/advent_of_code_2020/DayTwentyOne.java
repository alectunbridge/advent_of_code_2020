package advent_of_code_2020;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTwentyOne {

    private final Set<String> ingredients;

    public DayTwentyOne(String food) {
        Pattern foodPattern = Pattern.compile("(.*)\\(contains (.*)\\)");
        Matcher foodMatcher = foodPattern.matcher(food);
        if(!foodMatcher.matches()){
            throw new IllegalArgumentException("Unable to parse food: " + food);
        }
        ingredients = new HashSet<>(Arrays.asList(foodMatcher.group(1).split(" ")));
    }

    public Set<String> getIngredientsByAllergen(String dairy) {
        return ingredients;
    }
}
