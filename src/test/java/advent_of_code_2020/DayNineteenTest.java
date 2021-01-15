package advent_of_code_2020;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.assertThat;

public class DayNineteenTest {
    @Test
    void parseSingleRule() {
        DayNineteen dayNineteen = new DayNineteen("0: \"a\"");
        assertThat(dayNineteen.getRegex()).isEqualTo("a");
    }

    @Test
    void parseMultipleRules() {
        DayNineteen dayNineteen = new DayNineteen("0: \"1\"", "1: \"b\"");
        assertThat(dayNineteen.getRegex()).isEqualTo("(b)");
    }

    @Test
    void part1Example1() {
        DayNineteen dayNineteen = new DayNineteen(
                "0: 1 2",
                "1: \"a\"",
                "2: 1 3 | 3 1",
                "3: \"b\""
        );
        assertThat(dayNineteen.getRegex()).isEqualTo("(a)((a)(b)|(b)(a))");
    }

    @Test
    void part1Example2() {
        DayNineteen dayNineteen = new DayNineteen(
                "0: 4 1 5",
                "1: 2 3 | 3 2",
                "2: 4 4 | 5 5",
                "3: 4 5 | 5 4",
                "4: \"a\"",
                "5: \"b\""
        );
        assertThat(dayNineteen.getRegex()).isEqualTo("(a)(((a)(a)|(b)(b))((a)(b)|(b)(a))|((a)(b)|(b)(a))((a)(a)|(b)(b)))(b)");
    }

    @Test
    void parseRulesAndInputStrings() {
        DayNineteen dayNineteen = new DayNineteen(
                "0: \"a\"",
                "",
                "a",
                "b");
        assertThat(dayNineteen.getRegex()).isEqualTo("a");
        assertThat(dayNineteen.getCountOfMatchingStrings()).isEqualTo(1L);
    }

    @Test
    void part1ExampleCountValidStrings() {
        DayNineteen dayNineteen = new DayNineteen(
                "0: 4 1 5",
                "1: 2 3 | 3 2",
                "2: 4 4 | 5 5",
                "3: 4 5 | 5 4",
                "4: \"a\"",
                "5: \"b\"",
                "",
                "ababbb",
                "bababa",
                "abbbab",
                "aaabbb",
                "aaaabbb"
        );

        assertThat(dayNineteen.getCountOfMatchingStrings()).isEqualTo(2L);
    }

    @Test
    void part2Answer() throws URISyntaxException, IOException {
        String[] lines = Files.readAllLines(Path.of(this.getClass().getClassLoader().getResource("day_nineteen.txt").toURI())).toArray(new String[0]);
        DayNineteen dayNineteen = new DayNineteen(lines);
        assertThat(dayNineteen.getCountOfMatchingStrings()).isEqualTo(374L);
    }

    @Test
    void examplePart2() {
        DayNineteen dayNineteen = new DayNineteen(
                "42: 9 14 | 10 1" ,
                        "9: 14 27 | 1 26" ,
                        "10: 23 14 | 28 1" ,
                        "1: \"a\"" ,
                        "11: 42 31" ,
                        "5: 1 14 | 15 1" ,
                        "19: 14 1 | 14 14" ,
                        "12: 24 14 | 19 1" ,
                        "16: 15 1 | 14 14" ,
                        "31: 14 17 | 1 13" ,
                        "6: 14 14 | 1 14" ,
                        "2: 1 24 | 14 4" ,
                        "0: 8 11" ,
                        "13: 14 3 | 1 12" ,
                        "15: 1 | 14" ,
                        "17: 14 2 | 1 7" ,
                        "23: 25 1 | 22 14" ,
                        "28: 16 1" ,
                        "4: 1 1" ,
                        "20: 14 14 | 1 15" ,
                        "3: 5 14 | 16 1" ,
                        "27: 1 6 | 14 18" ,
                        "14: \"b\"" ,
                        "21: 14 1 | 1 14" ,
                        "25: 1 1 | 1 14" ,
                        "22: 14 14" ,
                        "8: 42" ,
                        "26: 14 22 | 1 20" ,
                        "18: 15 15" ,
                        "7: 14 5 | 1 21" ,
                        "24: 14 1",
                        "",
                        "abbbbbabbbaaaababbaabbbbabababbbabbbbbbabaaaa" ,
                                "bbabbbbaabaabba" ,
                                "babbbbaabbbbbabbbbbbaabaaabaaa" ,
                                "aaabbbbbbaaaabaababaabababbabaaabbababababaaa" ,
                                "bbbbbbbaaaabbbbaaabbabaaa" ,
                                "bbbababbbbaaaaaaaabbababaaababaabab" ,
                                "ababaaaaaabaaab" ,
                                "ababaaaaabbbaba" ,
                                "baabbaaaabbaaaababbaababb" ,
                                "abbbbabbbbaaaababbbbbbaaaababb" ,
                                "aaaaabbaabaaaaababaa" ,
                                "aaaabbaaaabbaaa" ,
                                "aaaabbaabbaaaaaaabbbabbbaaabbaabaaa" ,
                                "babaaabbbaaabaababbaabababaaab" ,
                                "aabbbbbaabbbaaaaaabbbbbababaaaaabbaaabba"
        );
        assertThat(dayNineteen.getCountOfMatchingStrings()).isEqualTo(12L);
    }
}
