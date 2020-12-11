package advent_of_code_2020;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DayTen {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = Paths.get(DayOne.class.getClassLoader()
                .getResource("day_ten.txt").toURI());

        List<Integer> jolts = Files.readAllLines(path).stream().map(Integer::valueOf).sorted().collect(Collectors.toList());
        jolts.add(0,0);
        System.out.println(jolts);
        int stepsOfOne = 0;
        int stepsOfTree = 0;
        for (int i = 0; i < jolts.size(); i++) {
            if(i+1 == jolts.size()){
                break;
            }
            int difference = jolts.get(i + 1) - jolts.get(i);
            if(difference == 1){
                stepsOfOne++;
            } else if (difference == 3){
                stepsOfTree++;
            }
        }
        stepsOfTree++;
        System.out.println(stepsOfOne);
        System.out.println(stepsOfTree);
        System.out.println(stepsOfOne*stepsOfTree);
    }
}
