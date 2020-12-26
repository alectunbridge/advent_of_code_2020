package advent_of_code_2020;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;

class DayFifteen {

    private List<Integer> numbers;
    private int index;

    public DayFifteen(Integer... numbers) {
        this.numbers = Arrays.stream(numbers).collect(Collectors.toList());
    }

    public static void main(String[] args) {

    }

    int takeTurn() {
        if(index < numbers.size()){
            return numbers.get(index++);
        }
        int lastNumber = numbers.get(numbers.size()-1);
        for (int i = numbers.size()-2; i >= 0; i--) {
            if(numbers.get(i) == lastNumber){
                int newNumber = index -1 - i;
                index++;
                numbers.add(newNumber);
                return newNumber;
            }
        }
        index++;
        numbers.add(0);
        return 0;
    }

	public int find2020thNumber() {
        int answer = 0 ;
        for (int i = 0; i < 2020; i++) {
            answer = takeTurn();
        }
		return answer;
	}

}