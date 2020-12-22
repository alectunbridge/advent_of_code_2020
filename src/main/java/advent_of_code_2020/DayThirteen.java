package advent_of_code_2020;

import java.util.*;
import java.util.stream.Collectors;

class BusIdAndOffset {
    private int id;
    private int offset;

    public int getId() {
        return id;
    }

    public int getOffset() {
        return offset;
    }

    public BusIdAndOffset(int id, int offset) {
        this.id = id;
        this.offset = offset;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BusIdAndOffset that = (BusIdAndOffset) o;
        return id == that.id && offset == that.offset;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, offset);
    }

    @Override
    public String toString() {
        return "BusIdAndOffset{" +
                "id=" + id +
                ", offset=" + offset +
                '}';
    }
}

public class DayThirteen {

    private int arrivalTime;
    private List<Integer> buses;
    List<BusIdAndOffset> busIdAndOffsets;

    public DayThirteen(String line1, String line2) {
        arrivalTime = Integer.parseInt(line1);
        buses = Arrays.stream(line2.split(","))
                .filter(field -> !"x".equals(field))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public DayThirteen(String line) {
        busIdAndOffsets = new ArrayList<>();
        String[] ids = line.split(",");
        for (int i = 0; i < ids.length; i++) {
            if (!"x".equals(ids[i])) {
                busIdAndOffsets.add(new BusIdAndOffset(Integer.parseInt(ids[i]), i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DayThirteen dayThirteen = new DayThirteen("1004098",
                "23,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,509,x,x,x,x,x,x,x,x,x,x,x,x,13,17,x,x,x,x,x,x,x,x,x,x,x,x,x,x,29,x,401,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,19");
        System.out.println("Part 1 answer: " + dayThirteen.getAnswer());

        DayThirteen dayThirteenPart2 = new DayThirteen(
                "23,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,509,x,x,x,x,x,x,x,x,x,x,x,x,13,17,x,x,x,x,x,x,x,x,x,x,x,x,x,x,29,x,401,x,x,x,x,x,37,x,x,x,x,x,x,x,x,x,x,x,x,19"
        );
        System.out.println("Part 2 answer: " + dayThirteenPart2.getAnswerPart2());
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
        for (int bus : buses) {
            int waitingTime = (arrivalTime / bus + 1) * bus - arrivalTime;
            if (waitingTime == 0) {
                return bus;
            } else if (waitingTime < shortestWaitingTime) {
                shortestWaitingTime = waitingTime;
                bestBus = bus;
            }
        }
        System.out.println(bestBus);
        System.out.println(shortestWaitingTime);

        System.out.println(100000000000000l / 23);
        return shortestWaitingTime * bestBus;
    }

    public long getAnswerPart2() throws InterruptedException {
        System.out.println(busIdAndOffsets);
        final long startValue = busIdAndOffsets.get(0).getId();
        long time = 0;
        long incrementer = 1;
        for (BusIdAndOffset busIdAndOffset : busIdAndOffsets) {
            while((time + busIdAndOffset.getOffset()) % busIdAndOffset.getId() != 0) {
                time += incrementer;
            }
            incrementer *= busIdAndOffset.getId();
        }
        return time;
    }
}
//225850756401039