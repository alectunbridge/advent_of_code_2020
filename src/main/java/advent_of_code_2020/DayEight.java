package advent_of_code_2020;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayEight {
    public static void main(String[] args) throws URISyntaxException, IOException {
        Path path = Paths.get(DayOne.class.getClassLoader()
                .getResource("day_eight.txt").toURI());

        List<String> instructions = Files.readAllLines(path);

        long acc = 0;
        Set<Integer> visitedInstructions = new HashSet<>();

        for (int instructionPointer = 0, linesSize = instructions.size(); instructionPointer < linesSize; instructionPointer++) {
            if(visitedInstructions.contains(instructionPointer)){
                break;
            }
            visitedInstructions.add(instructionPointer);
            String line = instructions.get(instructionPointer);
            System.out.println(line);
            Pattern pattern = Pattern.compile("([^ ]*) ([+-])(\\d+)");
            Matcher matcher = pattern.matcher(line);
            if (!matcher.matches()) {
                throw new IllegalArgumentException("Can't parse line: " + line);
            }

            String operation = matcher.group(1);
            String sign = matcher.group(2);
            long number = Long.parseLong(matcher.group(3));

            if ("-".equals(sign)) {
                number *= -1;
            }

            switch (operation) {
                case "acc": {
                    acc += number;
                    break;
                }
                case "jmp": {
                    instructionPointer += number - 1;
                    break;
                }
                case "nop": {
                    //do nowt
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unexpected instruction: " + operation);
                }
            }
        }
        System.out.println(acc);
    }
}
