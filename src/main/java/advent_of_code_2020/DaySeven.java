package advent_of_code_2020;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

class Bag {
    String colour;
    int number;
    Bag(String line){
        Pattern pattern = Pattern.compile("(\\d)? ?([^\\d]*)");
        Matcher matcher = pattern.matcher(line);
        if(matcher.matches()) {
            String numberAsString = matcher.group(1);
            if(numberAsString != null) {
                number = Integer.parseInt(numberAsString);
            }
            colour = matcher.group(2);
        } else {
          throw new IllegalArgumentException("can't parse the bag");
        }
    }

    @Override
    public String toString(){
        return String.format("colour: %s, number: %d",colour,number);
    }

    public String getColour() {
        return colour;
    }
}

public class DaySeven {

    private List<List<String>> bags;

    public DaySeven(String filePath) throws IOException {
        //        Path path = Paths.get("/home/codespace/advent_of_code_2020/src/main/resources/day_seven_stripped.txt");
        //        Path path = Paths.get("/home/alec/sourcecode/advent_of_code_2020/src/main/resources/day_seven_test_stripped.txt");
        Path path = Paths.get(filePath);
        List<String> lines = Files.readAllLines(path);
        List<List<String>> bags = new ArrayList<>();
        for(String line:lines){
            List<String> colours = parseLine(line).stream().map(Bag::getColour).collect(Collectors.toList());
            bags.add(colours);
        }
        this.bags = bags;
    }

    public static void main(String[] args) throws IOException {
        var daySeven = new DaySeven("/home/alec/sourcecode/advent_of_code_2020/src/main/resources/day_seven.txt");
        var answer = daySeven.findContainingBags(Collections.singleton("shiny gold"));
        daySeven.bags.stream().forEach(System.out::println);
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

    public Set<String> findContainingBags(String colour) {
        Set<String> result = new HashSet<>();
        for (List<String> bag : bags) {
            if(bag.contains(colour) && !colour.equals(bag.get(0))){
                result.add(bag.get(0));
            }
        }
        return result;
    }

    public static List<Bag> parseLine(String line) {
        line = line.replaceAll(" bags contain no other bags\\.", "");
        line = line.replaceAll(" bags contain ", ",");
        line = line.replaceAll(" bags?, ",",");
        line = line.replaceAll(" bag(s)?\\.","");
        return Arrays.stream(line.split(",")).map(Bag::new).collect(Collectors.toList());
    }

}
