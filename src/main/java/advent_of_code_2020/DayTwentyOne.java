package advent_of_code_2020;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTwentyOne {

    private MultiValuedMap<String, Set<String>> ingredients = new HashSetValuedHashMap<>();

    public DayTwentyOne(String... foods) {
        Pattern foodPattern = Pattern.compile("(.*)\\(contains (.*)\\)");

        for (String food : foods) {

            Matcher foodMatcher = foodPattern.matcher(food);
            if(!foodMatcher.matches()){
                throw new IllegalArgumentException("Unable to parse food: " + food);
            }
            ingredients.put(foodMatcher.group(2), new HashSet<>(Arrays.asList(foodMatcher.group(1).split(" "))));
        }
    }

    public Set<String> getIngredientsByAllergen(String allergen) {
        return ingredients.get(allergen).iterator().next();
    }
}
