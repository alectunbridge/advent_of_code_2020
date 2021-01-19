package advent_of_code_2020;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.apache.commons.lang3.StringUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

public class DayTwentyTest {

    @Test
    void parseTile() {
        Tile tile = new Tile(
                "Tile 3469:",
                ".##..#.#.#",
                "##..#...##",
                "...#..##.#",
                "....#.#..#",
                "#..#.##...",
                ".#.##.#.##",
                "..#.#.....",
                "..###.#..#",
                "#.##.#...#",
                "....#...##"
        );

        assertThat(tile.getId()).isEqualTo(3469);
        assertThat(tile.getTopRow()).isEqualTo(".##..#.#.#");
        assertThat(tile.getBottomRow()).isEqualTo("....#...##");
        assertThat(tile.getLeftEdge()).isEqualTo(".#..#...#.");
        assertThat(tile.getRightEdge()).isEqualTo("####.#.###");
    }

    @Test
    void hashTiles() {
        DayTwenty dayTwenty = new DayTwenty();
        Tile tile = new Tile(
                "Tile 3469:",
                ".##..#.#.#",
                "##..#...##",
                "...#..##.#",
                "....#.#..#",
                "#..#.##...",
                ".#.##.#.##",
                "..#.#.....",
                "..###.#..#",
                "#.##.#...#",
                "....#...##"
        );
        dayTwenty.addTile(tile);

        assertThat(dayTwenty.getTileByEdge(".##..#.#.#")).containsExactly(tile);
        assertThat(dayTwenty.getTileByEdge(reverse(".##..#.#.#"))).containsExactly(tile);

        assertThat(dayTwenty.getTileByEdge("####.#.###")).containsExactly(tile);
        assertThat(dayTwenty.getTileByEdge(reverse("####.#.###"))).containsExactly(tile);

        assertThat(dayTwenty.getTileByEdge("....#...##")).containsExactly(tile);
        assertThat(dayTwenty.getTileByEdge(reverse("....#...##"))).containsExactly(tile);

        assertThat(dayTwenty.getTileByEdge(".#..#...#.")).containsExactly(tile);
        assertThat(dayTwenty.getTileByEdge(reverse(".#..#...#."))).containsExactly(tile);
    }
}
