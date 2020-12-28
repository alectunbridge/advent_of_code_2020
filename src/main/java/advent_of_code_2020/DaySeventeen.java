package advent_of_code_2020;

import java.util.HashMap;
import java.util.Map;

public class DaySeventeen {
    private Map<Integer,char[][]> cube = new HashMap<>();

    public DaySeventeen(String... input) {
        cube.put(0, new char[input.length][]);
        char[][] chars = cube.get(0);
        for (int i = 0; i < input.length; i++) {
            chars[i] = input[i].toCharArray();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        cube.forEach((key, value) -> {
            result.append("z="+key+"\n");
            char[][] chars = value;
            for (int i = 0; i < chars.length; i++) {
                for (int j = 0; j < chars[i].length; j++) {
                    result.append(chars[i][j]);
                }
                result.append('\n');
            }
        });
        return result.toString();
    }

    public int countNeighbours(int layer, int row, int column) {
        int result = 0;
        for (int l = layer-1; l <= layer+1 ; l++) {
            char[][] chars = cube.get(l);
            if (chars == null) {
//                chars = new char[grid.get(0).length][];
//                for (int i = 0; i < chars.length; i++) {
//                    char[] characters = new char[chars.length];
//                    Arrays.fill(characters, '.');
//                    chars[i] = characters;
//                }
//                grid.put(l,chars);
                continue;
            }
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if(i==0 && j==0 && l==layer){
                        continue;
                    }
                    try {
                        if ('#' == chars[row + i][column + j]) {
                            result++;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        //do nowt
                    }
                }
            }
        }
        return result;
    }

    public void cycle() {
        //make copy of cube one cell larger in all directions
        //calculate new cube states
        //swap new cube and old cube
    }
}
