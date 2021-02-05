package advent_of_code_2020;

import org.apache.commons.collections4.MultiValuedMap;
import org.apache.commons.collections4.multimap.HashSetValuedHashMap;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayTwentyOne {

    private Set<String> uniqueIngredients = new HashSet<>();
    private MultiValuedMap<String, Set<String>> allergenToIngredientsMap = new HashSetValuedHashMap<>();
    private Map<String, String> foundAllergens = new HashMap<>();

    public DayTwentyOne(String... foods) {
        Pattern foodPattern = Pattern.compile("(.*)\\(contains (.*)\\)");

        for (String food : foods) {
            Matcher foodMatcher = foodPattern.matcher(food);
            if (!foodMatcher.matches()) {
                throw new IllegalArgumentException("Unable to parse food: " + food);
            }
            String[] allergens = foodMatcher.group(2).replaceAll(" ", "").split(",");
            for (String allergen : allergens) {
                HashSet<String> ingredients = new HashSet<>(Arrays.asList(foodMatcher.group(1).split(" ")));
                uniqueIngredients.addAll(ingredients);
                allergenToIngredientsMap.put(allergen, ingredients);
            }
        }
    }

    public Set<String> getIngredientsByAllergen(String allergen) {
        return allergenToIngredientsMap.get(allergen).iterator().next();
    }

    public Map<String,String> findAllergens() {
        while (allergenToIngredientsMap.keySet().size() != foundAllergens.size()) {
            for (String allergen : allergenToIngredientsMap.keySet()) {
                Set<String> intersection = new HashSet<>(allergenToIngredientsMap.get(allergen).iterator().next());
                for (Set<String> ingredients : allergenToIngredientsMap.get(allergen)) {
                    intersection.retainAll(ingredients);
                }
                intersection.removeAll(foundAllergens.values());
                if (intersection.size() == 1) {
                    foundAllergens.put(allergen, intersection.iterator().next());
                }
            }
        }
        return foundAllergens;
    }


    public Set<String> getAllergenFreeIngredients() {
        Set<String> intersection = new HashSet<>(uniqueIngredients);
        intersection.removeAll(foundAllergens.values());
        return intersection;
    }
}
