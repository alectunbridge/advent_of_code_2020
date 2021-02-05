package advent_of_code_2020;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.util.Arrays;
import java.util.Collection;
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
            String[] allergens = foodMatcher.group(2).replaceAll(" ","").split(",");
            for (String allergen : allergens) {
                ingredients.put(allergen, new HashSet<>(Arrays.asList(foodMatcher.group(1).split(" "))));
            }
        }
    }

    public Set<String> getIngredientsByAllergen(String allergen) {
        Collection<Set<String>> allIngredientsForAllergen = ingredients.get(allergen);
        Set<String> intersection = new HashSet<>(allIngredientsForAllergen.iterator().next());
        for (Set<String> ingredients : allIngredientsForAllergen) {
            intersection.retainAll(ingredients);
        }
        return intersection;
    }
}
