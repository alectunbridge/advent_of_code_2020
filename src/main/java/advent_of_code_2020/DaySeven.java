package advent_of_code_2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DaySeven {

    public static final Pattern LINE_PATTERN = Pattern.compile("^(.*) bags[^,.].*$");
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/codespace/advent_of_code_2020/src/main/resources/day_seven.txt");
        List<String> lines = Files.readAllLines(path);
        for(String line:lines){
            System.out.println(parseLine(line));
        }
    }

    public static String parseLine(String line) {
        Matcher matcher = LINE_PATTERN.matcher(line);
        if(matcher.matches()){
            String colour = matcher.group(1);
            return colour;
        } else {
            return "no match";
        }
    }

}
