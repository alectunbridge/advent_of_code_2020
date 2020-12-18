package advent_of_code_2020;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DayThirteen {

    private int arrivalTime;
    private List<Integer> buses;

    public DayThirteen(String input) {
        String[] lines = input.split("\n");
        arrivalTime = Integer.parseInt(lines[0]);
        buses = Arrays.stream(lines[1].split(","))
                .filter(field ->!"x".equals(field))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        DayThirteen dayThirteen = new DayThirteen("1004098\n" +
                "23,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,509,x,x,x,x,x,x,x,x,x,x,x,x,13,17,x,x,x,x,x,x,x,x,x,x,x,x,x,x,29,x,401,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,19");
        System.out.println(dayThirteen.getAnswer());
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public List<Integer> getBuses() {
        return buses;
    }

    public int getAnswer() {
        int shortestWaitingTime = Integer.MAX_VALUE;
        int bestBus = -1;
        for (int bus: buses) {
            int waitingTime = (arrivalTime / bus + 1) * bus - arrivalTime;
            if(waitingTime == 0) {
                return bus;
            } else if(waitingTime<shortestWaitingTime){
                shortestWaitingTime = waitingTime;
                bestBus = bus;
            }
        }
        System.out.println(bestBus);
        System.out.println(shortestWaitingTime);
        return shortestWaitingTime * bestBus;
    }
}
