package advent_of_code_2020;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Tile {
    private final int id;

    public Tile(String... lines){
        Matcher matcher = Pattern.compile("^Tile (\\d+):$").matcher(lines[0]);
        if(!matcher.matches()){
            throw new IllegalArgumentException("Can't parse id from: " + lines[0]);
        }
        id = Integer.parseInt(matcher.group(1));
    }

    public int getId() {
        return id;
    }
}

public class DayTwenty {

}
