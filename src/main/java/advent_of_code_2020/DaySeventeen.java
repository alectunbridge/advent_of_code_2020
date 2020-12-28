package advent_of_code_2020;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class DaySeventeen {
    private TreeMap<Integer,char[][]> cube = new TreeMap<>();

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
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    result.append(value[i][j]);
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
        //grow the cube one cell in all directions
        growCube();

        //make copy of cube
        //calculate new cube states
        //swap new cube and old cube
    }

    private void growCube() {
        //grow each layer
        int newSize = cube.get(0).length + 2;
        for (Map.Entry<Integer, char[][]> layer : cube.entrySet()) {
            char[][] largerLayer = new char[newSize][newSize];
            for (char[] chars : largerLayer) {
                Arrays.fill(chars,'.');
            }
            for (int i = 0; i < layer.getValue().length; i++) {
                for (int j = 0; j < layer.getValue().length; j++) {
                    largerLayer[i+1][j+1] = layer.getValue()[i][j];
                }
            }
            cube.put(layer.getKey(),largerLayer);
        }

        char[][] newBottomLayer = new char[newSize][newSize];
        for(char[] chars: newBottomLayer) {
            Arrays.fill(chars, '.');
        }
        cube.put(cube.firstKey()-1,newBottomLayer);

        char[][] newTopLayer = new char[newSize][newSize];
        for(char[] chars: newTopLayer){
            Arrays.fill(chars,'.');
        }
        cube.put(cube.lastKey()+1,newTopLayer);
    }
}
