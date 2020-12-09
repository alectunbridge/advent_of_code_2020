package advent_of_code_2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class DaySeven {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("/home/codespace/advent_of_code_2020/src/main/resources/day_seven_stripped.txt");
        List<String> lines = Files.readAllLines(path);
        for(String line:lines){
            List<String> colours = parseLine(line);
            System.out.println(colours);
        }
    }

    public static List<String> parseLine(String line) {
        return Arrays.asList(line.split(","));
    }

}
