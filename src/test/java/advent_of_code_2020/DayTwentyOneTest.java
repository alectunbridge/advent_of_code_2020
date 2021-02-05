package advent_of_code_2020;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DayTwentyOneTest {
    @Test
    void createMap() {
        assertThat(new DayTwentyOne("trh fvjkl sbzzf mxmxvkd (contains dairy)")
                .getIngredientsByAllergen("dairy"))
                .containsExactly("trh fvjkl sbzzf mxmxvkd");
    }
}