package advent_of_code_2020;

import java.util.Arrays;
import java.util.List;

public class DayEleven {
    private final char[][] grid;
    public DayEleven(String input) {
        List<String> lines = Arrays.asList(input.split("\n"));
        grid = new char[lines.size()][];
        for (int rowNumber = 0; rowNumber < lines.size(); rowNumber++) {
            grid[rowNumber] = lines.get(rowNumber).toCharArray();
        }
    }

    public String takeTurn() {
        char[][] newGrid = new char[grid.length][];
        for (int rowNumber = 0; rowNumber < grid.length; rowNumber++) {
            newGrid[rowNumber] = new char[grid[rowNumber].length];
            for (int columnNumber = 0; columnNumber < grid[rowNumber].length; columnNumber++) {
                int neighbours = countNeighbours(rowNumber,columnNumber);
                char currentSeat = grid[rowNumber][columnNumber];
                if(neighbours == 0 && currentSeat == 'L'){
                    newGrid[rowNumber][columnNumber] = '#';
                } else {
                    newGrid[rowNumber][columnNumber] = currentSeat;
                }
            }
        }
        return toString(newGrid);
    }

    private int countNeighbours(int rowNumber, int columnNumber) {
        return 0;
    }

    @Override
    public String toString() {
        return toString(grid);
    }

    public String toString(char[][] gridToConvert) {
        StringBuilder result = new StringBuilder();
        for (int rowNumber = 0; rowNumber < gridToConvert.length; rowNumber++) {
            for (int columnNumber = 0; columnNumber < gridToConvert[rowNumber].length; columnNumber++) {
                result.append(gridToConvert[rowNumber][columnNumber]);
            }
            result.append("\n");
        }
        return result.toString().trim();
    }
}
