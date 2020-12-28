package advent_of_code_2020;

public class DaySeventeen {
    private char[][] grid;

    public DaySeventeen(String... input){
        grid = new char[input.length][];
        for (int i = 0; i < input.length; i++) {
            grid[i] = input[i].toCharArray();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                result.append(grid[i][j]);
            }
            result.append('\n');
        }
        return result.toString();
    }
}
