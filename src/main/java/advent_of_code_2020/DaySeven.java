package advent_of_code_2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DaySeven {

    private List<List<String>> bags;

    public DaySeven(List<List<String>> bags) {

        this.bags = bags;
    }

    public static void main(String[] args) throws IOException {
//        Path path = Paths.get("/home/codespace/advent_of_code_2020/src/main/resources/day_seven_stripped.txt");
        Path path = Paths.get("/home/alec/sourcecode/advent_of_code_2020/src/main/resources/day_seven_stripped.txt");
//        Path path = Paths.get("/home/alec/sourcecode/advent_of_code_2020/src/main/resources/day_seven_test_stripped.txt");
        List<String> lines = Files.readAllLines(path);
        List<List<String>> bags = new ArrayList<>();
        for(String line:lines){
            List<String> colours = parseLine(line);
            bags.add(colours);
        }
        var daySeven = new DaySeven(bags);
        var answer = daySeven.findContainingBags(Collections.singleton("shiny gold"));
        System.out.println(answer);
        System.out.println(answer.size());
    }

    private Set<String> findContainingBags(Set<String> bagsToFind) {
        Set<String> result = new HashSet<>();
        for(String bag: bagsToFind) {
            Set<String> containingBags = findContainingBags(bag);
            result.addAll(containingBags);
            result.addAll(findContainingBags(containingBags));
        }
        return result;
    }

    private Set<String> findContainingBags(String colour) {
        System.out.println(colour);
        Set<String> result = new HashSet<>();
        for (List<String> bag : bags) {
            if(bag.contains(colour) && !colour.equals(bag.get(0))){
                result.add(bag.get(0));
            }
        }
        return result;
    }

    public static List<String> parseLine(String line) {
        return Arrays.asList(line.split(","));
    }

}
