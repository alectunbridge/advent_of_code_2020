package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DayTwentyFourTest {

    @Test
    void directions() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour("eseswwnwne");
        assertThat(dayTwentyFour).asString().isEqualTo("EAST,SOUTH_EAST,SOUTH_WEST,WEST,NORTH_WEST,NORTH_EAST,");
        assertThat(dayTwentyFour.getBlackTiles()).containsExactly(new BlackTile(0, 0));
    }

    @Test
    void nwwswee() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour("nwwswee");
        assertThat(dayTwentyFour).asString().isEqualTo("NORTH_WEST,WEST,SOUTH_WEST,EAST,EAST,");
        assertThat(dayTwentyFour.getBlackTiles()).containsExactly(new BlackTile(0, 0));
    }

    @Test
    void toggleTile() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour("nwwswee", "eseswwnwne");
        assertThat(dayTwentyFour).asString().isEqualTo("NORTH_WEST,WEST,SOUTH_WEST,EAST,EAST,\n"
                + "EAST,SOUTH_EAST,SOUTH_WEST,WEST,NORTH_WEST,NORTH_EAST,"
        );
        assertThat(dayTwentyFour.getBlackTiles()).isEmpty();
    }

    @Test
    void examplePart1() {
        DayTwentyFour
                dayTwentyFour = new DayTwentyFour(
                "sesenwnenenewseeswwswswwnenewsewsw",
                "neeenesenwnwwswnenewnwwsewnenwseswesw",
                "seswneswswsenwwnwse",
                "nwnwneseeswswnenewneswwnewseswneseene",
                "swweswneswnenwsewnwneneseenw",
                "eesenwseswswnenwswnwnwsewwnwsene",
                "sewnenenenesenwsewnenwwwse",
                "wenwwweseeeweswwwnwwe",
                "wsweesenenewnwwnwsenewsenwwsesesenwne",
                "neeswseenwwswnwswswnw",
                "nenwswwsewswnenenewsenwsenwnesesenew",
                "enewnwewneswsewnwswenweswnenwsenwsw",
                "sweneswneswneneenwnewenewwneswswnese",
                "swwesenesewenwneswnwwneseswwne",
                "enesenwswwswneneswsenwnewswseenwsese",
                "wnwnesenesenenwwnenwsewesewsesesew",
                "nenewswnwewswnenesenwnesewesw",
                "eneswnwswnwsenenwnwnwwseeswneewsenese",
                "neswnwewnwnwseenwseesewsenwsweewe",
                "wseweeenwnesenwwwswnew"
        );
        assertThat(dayTwentyFour.getBlackTiles()).hasSize(10);
    }

    @Test
    void part1() throws IOException, URISyntaxException {
        URI fileURI = this.getClass().getClassLoader()
                .getResource("day_twenty_four.txt")
                .toURI();
        List<String> lines = Files.readAllLines(Path.of(fileURI));

        DayTwentyFour day = new DayTwentyFour(lines.toArray(new String[0]));

        assertThat(day.getBlackTiles()).hasSize(388);
    }
}
