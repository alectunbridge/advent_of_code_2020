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
}