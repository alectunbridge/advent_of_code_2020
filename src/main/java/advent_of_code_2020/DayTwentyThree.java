package advent_of_code_2020;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DayTwentyThree {
    protected LinkedHashMap<Integer,Integer> cups;
    protected int currentCup;


    public DayTwentyThree(Integer... cups) {
        this.cups = new LinkedHashMap<>();
        for (int i = 0; i < cups.length; i++) {
             if (i == cups.length-1){
                 this.cups.put(cups[i], cups[0]);
             } else {
                 this.cups.put(cups[i], cups[i + 1]);
             }
        }
        currentCup = cups[0];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("*");
        sb.append(currentCup);
        sb.append(" ");
        int nextCup = cups.get(currentCup);
        for (int i = 0; i < cups.size()-1; i++) {

            sb.append(nextCup);
            sb.append(" ");
            nextCup = cups.get(nextCup);
        }
        return sb.toString().trim();
    }

    public void move() {
        List<Integer> cupsToMove = new ArrayList<>();
        int nextCup = cups.get(currentCup);
        for (int i = 1; i <= 3; i++) {
            cupsToMove.add(nextCup);
            nextCup = cups.get(nextCup);
        }
        int destinationCup = currentCup-1;
        if(destinationCup == 0) {
            destinationCup = cups.size();
        }
        while(cupsToMove.contains(destinationCup)) {
            destinationCup--;
            if(destinationCup == 0) {
                destinationCup = cups.size();
            }
        }

        cups.put(currentCup, cups.get(cupsToMove.get(cupsToMove.size()-1)));

        int cupAfterDestination = cups.get(destinationCup);
        cups.put(destinationCup, cupsToMove.get(0));
        cups.put(cupsToMove.get(cupsToMove.size()-1),cupAfterDestination);
        currentCup = cups.get(currentCup);
    }

    public String answer() {
        String result = "";
        int nextCup = cups.get(1);
        result+= nextCup;
        while (result.length() < cups.size()-1) {
            result += cups.get(nextCup);
            nextCup = cups.get(nextCup);
        }
        return result;
    }

    public Map<Integer, Integer> getCups() {
        return cups;
    }
}
