package advent_of_code_2020;


import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

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

        assertThat(dayTwentyOne.findAllergens()).containsExactlyInAnyOrderEntriesOf(
                Map.of(
                        "fish", "sqjhc",
                        "dairy", "mxmxvkd",
                        "soy", "fvjkl"
                )
        );

        assertThat(dayTwentyOne.getAllergenFreeIngredients()).containsOnly(
                "kfcds", "nhms", "sbzzf", "trh"
        );

        assertThat(dayTwentyOne.getCountOfAllergenFreeIngredientOccurences()).isEqualTo(5);
    }

    @Test
    void part1Solution() throws URISyntaxException, IOException {
        DayTwentyOne dayTwentyOne = new DayTwentyOne(
                Files.readAllLines(Path.of(this.getClass().getClassLoader().getResource("day_twenty_one.txt").toURI())).toArray(new String[0]));
        dayTwentyOne.findAllergens();
        assertThat(dayTwentyOne.getCountOfAllergenFreeIngredientOccurences()).isEqualTo(2211);
    }

    @Test
    void part2Example() {
        DayTwentyOne dayTwentyOne = new DayTwentyOne(
                "mxmxvkd kfcds sqjhc nhms (contains dairy, fish)",
                "trh fvjkl sbzzf mxmxvkd (contains dairy)",
                "sqjhc fvjkl (contains soy)",
                "sqjhc mxmxvkd sbzzf (contains fish)"
        );

        dayTwentyOne.findAllergens();
        assertThat(dayTwentyOne.getDangerousIngredientsByAllergenAlphabetically()).isEqualTo(
                "mxmxvkd,sqjhc,fvjkl"
        );
    }

    @Test
    void part2Solution() throws URISyntaxException, IOException {
        DayTwentyOne dayTwentyOne = new DayTwentyOne(
                Files.readAllLines(Path.of(this.getClass().getClassLoader().getResource("day_twenty_one.txt").toURI())).toArray(new String[0]));
        dayTwentyOne.findAllergens();
        assertThat(dayTwentyOne.getDangerousIngredientsByAllergenAlphabetically()).isEqualTo("vv,nlxsmb,rnbhjk,bvnkk,ttxvphb,qmkz,trmzkcfg,jpvz");
    }
}
