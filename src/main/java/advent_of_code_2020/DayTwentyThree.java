package advent_of_code_2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DayTwentyThree {
    private List<Integer> cups;
    private int currentCupIndex;

    public DayTwentyThree(Integer... cups) {
        this.cups = new ArrayList<>();
        this.cups.addAll(Arrays.asList(cups));
        currentCupIndex = 0;
    }

    @Override
    public String toString() {
        return IntStream
                .range(0, cups.size())
                .mapToObj(i -> i == currentCupIndex ? "*"+cups.get(i) : cups.get(i).toString())
                .collect(Collectors.joining(" "));
    }

    public void move() {
        List<Integer> removedCups = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            int indexToRemove = currentCupIndex + 1;
            if(indexToRemove == cups.size()) {
                indexToRemove = 0;
                currentCupIndex--;
            }
            removedCups.add(cups.remove(indexToRemove));
        }
        int destinationCup = cups.get(currentCupIndex) - 1;
        if(destinationCup == 0) {
            destinationCup = cups.size()+removedCups.size();
        }
        while(removedCups.contains(destinationCup)) {
            destinationCup--;
            if(destinationCup == 0) {
                destinationCup = cups.size()+removedCups.size();
            }
        }

        int insertionIndex = cups.indexOf(destinationCup)+1;
        if(insertionIndex<currentCupIndex) {
            currentCupIndex+=removedCups.size();
        }
        cups.addAll(insertionIndex, removedCups);
        currentCupIndex++;
        currentCupIndex %= cups.size();
    }
}
