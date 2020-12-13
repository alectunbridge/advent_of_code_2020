package advent_of_code_2020;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class DayTen {

    private static Map<Integer, Long> visited;

    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = Paths.get(DayOne.class.getClassLoader()
                .getResource("day_ten.txt").toURI());

        List<Integer> jolts = Files.readAllLines(path).stream().map(Integer::valueOf).sorted().collect(Collectors.toList());
        jolts.add(0,0);
        System.out.println(jolts);

        Map<Integer,Set<Integer>> joltToPossibleJoltMap = new TreeMap<>();

        for (int i = 0; i < jolts.size(); i++) {
            int jolt = jolts.get(i);
            Set<Integer> possibleNextJolts = new TreeSet<>();
            if(jolts.contains(jolt+1)){
                possibleNextJolts.add(jolt+1);
            }
            if(jolts.contains(jolt+2)){
                possibleNextJolts.add(jolt+2);
            }
            if(jolts.contains(jolt+3)){
                possibleNextJolts.add(jolt+3);
            }
            joltToPossibleJoltMap.put(jolt,possibleNextJolts);
        }

        System.out.println(joltToPossibleJoltMap);

        visited = new HashMap<>();
        walkTheTree(joltToPossibleJoltMap, 0);
    }

    private static long walkTheTree(Map<Integer, Set<Integer>> joltToPossibleJoltMap, int i) {
        long pathsFromHere = 0;
        if(visited.containsKey(i)){
            return visited.get(i);
        }
        Set<Integer> possibleNextJolts = joltToPossibleJoltMap.get(i);
        if(possibleNextJolts.isEmpty()){
            return 1;
        }
        for(Integer possibleNextJolt: possibleNextJolts){
            pathsFromHere += walkTheTree(joltToPossibleJoltMap, possibleNextJolt);
        }
        System.out.printf("number: %d, pathsFromHere: %d\n",i,pathsFromHere);
        visited.put(i,pathsFromHere);
        return pathsFromHere;
    }
}
