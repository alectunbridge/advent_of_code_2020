package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class DayTwentyFourTest {

    @Test
    void directions() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour("eseswwnwne");
        assertThat(dayTwentyFour).asString().isEqualTo("EAST,SOUTH_EAST,SOUTH_WEST,WEST,NORTH_WEST,NORTH_EAST,");
        assertThat(dayTwentyFour.getBlackTiles()).containsExactly(new HexTile(0, 0));
    }

    @Test
    void nwwswee() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour("nwwswee");
        assertThat(dayTwentyFour).asString().isEqualTo("NORTH_WEST,WEST,SOUTH_WEST,EAST,EAST,");
        assertThat(dayTwentyFour.getBlackTiles()).containsExactly(new HexTile(0, 0));
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

    @Test
    void part2Example() {
        DayTwentyFour
                day = new DayTwentyFour(
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
        assertThat(day.getBlackTiles()).hasSize(10);

        day.flip();
        assertThat(day.getBlackTiles()).hasSize(15);

        day.flip();
        assertThat(day.getBlackTiles()).hasSize(12);
        day.flip();
        assertThat(day.getBlackTiles()).hasSize(25);
        day.flip();
        assertThat(day.getBlackTiles()).hasSize(14);
        day.flip();
        assertThat(day.getBlackTiles()).hasSize(23);
        day.flip();
        assertThat(day.getBlackTiles()).hasSize(28);
        day.flip();
        assertThat(day.getBlackTiles()).hasSize(41);
        day.flip();
        assertThat(day.getBlackTiles()).hasSize(37);
        day.flip();
        assertThat(day.getBlackTiles()).hasSize(49);
        day.flip();
        assertThat(day.getBlackTiles()).hasSize(37);

        IntStream.rangeClosed(1,10).forEach(i->day.flip());
        assertThat(day.getBlackTiles()).hasSize(132);
        IntStream.rangeClosed(1,10).forEach(i->day.flip());
        assertThat(day.getBlackTiles()).hasSize(259);
        IntStream.rangeClosed(1,10).forEach(i->day.flip());
        assertThat(day.getBlackTiles()).hasSize(406);
        IntStream.rangeClosed(1,10).forEach(i->day.flip());
        assertThat(day.getBlackTiles()).hasSize(566);
        IntStream.rangeClosed(1,10).forEach(i->day.flip());
        assertThat(day.getBlackTiles()).hasSize(788);
        IntStream.rangeClosed(1,10).forEach(i->day.flip());
        assertThat(day.getBlackTiles()).hasSize(1106);
        IntStream.rangeClosed(1,10).forEach(i->day.flip());
        assertThat(day.getBlackTiles()).hasSize(1373);
        IntStream.rangeClosed(1,10).forEach(i->day.flip());
        assertThat(day.getBlackTiles()).hasSize(1844);
        IntStream.rangeClosed(1,10).forEach(i->day.flip());
        assertThat(day.getBlackTiles()).hasSize(2208);
    }

    @Test
    void getNeighbours() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour("ne", "e", "se", "sw", "w", "nw");
        assertThat(dayTwentyFour.getBlackNeighbours(new HexTile(0, 0))).isEqualTo(6);
    }

    @Test
    void getWhiteNeighbours() {
        DayTwentyFour dayTwentyFour = new DayTwentyFour();
        assertThat(dayTwentyFour.getWhiteNeighbours(new HexTile(0, 0))).hasSize(6);
    }
}
