package advent_of_code_2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class DayFifteen {

    private List<Integer> numbers;
    private int index;
    private int lastNumber;
    private Map<Integer,Integer> cache = new HashMap<>();

    public DayFifteen(Integer... numbers) {
        this.numbers = Arrays.stream(numbers).collect(Collectors.toList());
    }

    int takeTurn() {
        int newEntry = 0;
        if(index < numbers.size()){
            cache.put(numbers.get(index), index);
            return numbers.get(index++);
        }
        lastNumber = numbers.get(numbers.size()-1);
        Integer lastIndex = cache.get(lastNumber);
        if(lastIndex == null || lastIndex == index-1){
            //do nowt
        } else {
            newEntry = index - lastIndex - 1;
        }
        numbers.add(newEntry);
        cache.put(lastNumber,index-1);
        index++;
        return newEntry;
    }

	public int find2020thNumber() {
        int answer = 0 ;
        for (int i = 0; i < 2020; i++) {
            answer = takeTurn();
        }
		return answer;
	}

	public int find30_000_000thNumber() {
        int answer = 0 ;
        for (int i = 0; i < 30_000_000; i++) {
            answer = takeTurn();
        }
		return answer;
	}

}