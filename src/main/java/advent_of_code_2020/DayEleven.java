package advent_of_code_2020;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class DayEleven {
    public static final char EMPTY = 'L';
    public static final char OCCUPIED = '#';

    private char[][] grid;

    public DayEleven(String input) {
        List<String> lines = Arrays.asList(input.split("\n"));
        grid = new char[lines.size()][];
        for (int rowNumber = 0; rowNumber < lines.size(); rowNumber++) {
            grid[rowNumber] = lines.get(rowNumber).toCharArray();
        }
    }

    public String nextRound() {
        char[][] newGrid = new char[grid.length][];
        for (int rowNumber = 0; rowNumber < grid.length; rowNumber++) {
            newGrid[rowNumber] = new char[grid[rowNumber].length];
            for (int columnNumber = 0; columnNumber < grid[rowNumber].length; columnNumber++) {
                int neighbours = countNeighbours(rowNumber, columnNumber);
                char currentSeat = grid[rowNumber][columnNumber];
                if (neighbours == 0 && currentSeat == EMPTY) {
                    newGrid[rowNumber][columnNumber] = OCCUPIED;
                } else if (neighbours >= 4 && currentSeat == OCCUPIED) {
                    newGrid[rowNumber][columnNumber] = EMPTY;
                } else {
                    newGrid[rowNumber][columnNumber] = currentSeat;
                }
            }
        }
        grid = newGrid;
        return toString(newGrid);
    }

    private int countNeighbours(int rowNumber, int columnNumber) {
        int neighbourCount = 0;
        
        neighbourCount += isThereANeighbour(rowNumber - 1, columnNumber - 1);
        neighbourCount += isThereANeighbour(rowNumber - 1,columnNumber + 0);
        neighbourCount += isThereANeighbour(rowNumber - 1,columnNumber + 1);
        neighbourCount += isThereANeighbour(rowNumber + 0,columnNumber + 1);

        neighbourCount += isThereANeighbour(rowNumber + 1,columnNumber + 1);
        neighbourCount += isThereANeighbour(rowNumber + 1,columnNumber + 0);
        neighbourCount += isThereANeighbour(rowNumber + 1,columnNumber - 1);
        neighbourCount += isThereANeighbour(rowNumber + 0,columnNumber - 1);
        
        return neighbourCount;
    }

    private int isThereANeighbour(int rowNumber, int columnNumber) {
        if (rowNumber >= 0 && rowNumber < grid.length && columnNumber >= 0 && columnNumber < grid[rowNumber].length) {
            return grid[rowNumber][columnNumber] == OCCUPIED ? 1 : 0;
        }
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

    public int findNumberOfOccupiedSeats() {
        int result = 0;
        String lastRound = "";
        String thisRound = nextRound();
        while(!lastRound.equals(thisRound)){
            lastRound = thisRound;
            thisRound = nextRound();
        }
        for (int rowNumber = 0; rowNumber < grid.length; rowNumber++) {
            for (int columnNumber = 0; columnNumber < grid[rowNumber].length; columnNumber++) {
                if(OCCUPIED == grid[rowNumber][columnNumber]){
                    result++;
                }
            }
        }
        return result;
    }

    public int countNeighboursPart2(int rowNumber, int columnNumber) {
        int neighbourCount = 0;

        //up, down, left and right
        neighbourCount += incrementRowsAndColumns(rowNumber, columnNumber, r -> ++r, c -> c);
        neighbourCount += incrementRowsAndColumns(rowNumber, columnNumber, r -> --r, c -> c);
        neighbourCount += incrementRowsAndColumns(rowNumber, columnNumber, r -> r, c -> ++c);
        neighbourCount += incrementRowsAndColumns(rowNumber, columnNumber, r -> r, c -> --c);

        //diagonals
        neighbourCount += incrementRowsAndColumns(rowNumber, columnNumber, r -> ++r, c -> ++c);
        neighbourCount += incrementRowsAndColumns(rowNumber, columnNumber, r -> ++r, c -> --c);
        neighbourCount += incrementRowsAndColumns(rowNumber, columnNumber, r -> --r, c -> --c);
        neighbourCount += incrementRowsAndColumns(rowNumber, columnNumber, r -> --r, c -> ++c);

        return neighbourCount;
    }

    private int incrementRowsAndColumns(int rowNumber, int columnNumber, Function<Integer,Integer> rowSupplier, Function<Integer,Integer> columnSupplier) {
        int neighbourCount = 0;
        int rowIndex = rowSupplier.apply(rowNumber);
        int columnIndex = columnSupplier.apply(columnNumber);
        LOOP: while(rowIndex>=0 && rowIndex<grid.length && columnIndex>=0 && columnIndex<grid[rowIndex].length) {
            switch (grid[rowIndex][columnIndex]){
                case EMPTY: break LOOP;
                case OCCUPIED: neighbourCount++; break;
            }
            rowIndex = rowSupplier.apply(rowIndex);
            columnIndex = columnSupplier.apply(columnIndex);
        }
        return neighbourCount;
    }
}
