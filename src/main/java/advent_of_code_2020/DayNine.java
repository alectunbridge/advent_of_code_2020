package advent_of_code_2020;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class DayNine {
    public static final int WINDOW_SIZE = 25;
    public static final int PART_ONE_ANSWER = 41682220;

    public static void main(String[] args) throws URISyntaxException, IOException {

        Path path = Paths.get(DayOne.class.getClassLoader()
                .getResource("day_nine.txt").toURI());
        List<Long> numbers = Files.readAllLines(path).stream().map(Long::valueOf).collect(Collectors.toList());
        System.out.println(numbers);

        partOne(numbers);
        partTwo(numbers);
    }

    private static void partTwo(List<Long> numbers) {
        for (var startIndex = 0; startIndex < numbers.size(); startIndex++) {
            var total = 0;
            for (var endIndex = startIndex; endIndex < numbers.size(); endIndex++) {
                total+=numbers.get(endIndex);
                if(total == PART_ONE_ANSWER && startIndex != endIndex){
                    List<Long> window = numbers.subList(startIndex, endIndex);
                    window.sort(Long::compare);
                    System.out.printf("startIndex: %d endIndex: %d answer: %d%n",startIndex,endIndex, window.get(0)+window.get(window.size()-1));
                    System.exit(0);
                }
            }
        }
    }

    private static void partOne(List<Long> numbers) {
        int index = 0;
        for (index = WINDOW_SIZE; index < numbers.size(); index++) {
            long currentNumber = numbers.get(index);
            boolean validNumber = false;
            LOOP:
            for (int i = index - WINDOW_SIZE; i < index; i++) {
                for (int j = i + 1; j < index; j++) {
                    if (numbers.get(i) + numbers.get(j) == currentNumber) {
                        validNumber = true;
                        break LOOP;
                    }
                }
            }
            if (!validNumber) {
                System.out.println(numbers.get(index));
                break;
            }
        }
    }
}
