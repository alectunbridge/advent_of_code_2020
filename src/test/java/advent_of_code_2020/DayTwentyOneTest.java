package advent_of_code_2020;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayTwentyOneTest {
    @Test
    void getIngredientsByAllergen() {
        DayTwentyOne dayTwentyOne = new DayTwentyOne(
                "trh fvjkl sbzzf mxmxvkd (contains dairy)",
                "sqjhc fvjkl (contains soy)"
        );
        assertThat(dayTwentyOne
                .getIngredientsByAllergen("dairy"))
                .containsOnly("trh", "fvjkl", "sbzzf", "mxmxvkd");

        assertThat(dayTwentyOne
                .getIngredientsByAllergen("soy"))
                .containsOnly("sqjhc", "fvjkl");
    }

    @Test
    void multipleAllergensPerFoodstuff() {
        DayTwentyOne dayTwentyOne = new DayTwentyOne(
                "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)");
        assertThat(dayTwentyOne.getIngredientsByAllergen("dairy")).containsOnly(
                "mxmxvkd",
                "kfcds",
                "sqjhc",
                "nhms"
        );

        assertThat(dayTwentyOne.getIngredientsByAllergen("fish")).containsOnly(
                "mxmxvkd",
                "kfcds",
                "sqjhc",
                "nhms"
        );
    }

    @Test
    void part1Example() {
        DayTwentyOne dayTwentyOne = new DayTwentyOne(
                "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)",
                "trh fvjkl sbzzf mxmxvkd (contains dairy)",
                "sqjhc fvjkl (contains soy)",
                "sqjhc mxmxvkd sbzzf (contains fish)"
        );

        assertThat(dayTwentyOne.getIngredientsByAllergen("dairy")).containsOnly("mxmxvkd");
        assertThat(dayTwentyOne.getIngredientsByAllergen("fish")).containsOnly("sqjhc");
        assertThat(dayTwentyOne.getIngredientsByAllergen("soy")).containsOnly("fvkl");
    }

}