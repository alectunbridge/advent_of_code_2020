package advent_of_code_2020;

import org.apache.commons.lang3.SerializationUtils;

import java.util.Arrays;

public class DaySeventeen {
    private char[][][] cube = new char[1][][];

    public DaySeventeen(String... input) {
        cube[0] = new char[input.length][];
        char[][] chars = cube[0];
        for (int i = 0; i < input.length; i++) {
            chars[i] = input[i].toCharArray();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int z = 0; z < cube.length; z++) {
            char[][] chars = cube[z];
            result.append("z=" + (z - cube.length/2) + "\n");
            for (int i = 0; i < cube[z].length; i++) {
                for (int j = 0; j < cube[z][i].length; j++) {
                    result.append(cube[z][i][j]);
                }
                result.append('\n');
            }
        }
        ;
        return result.toString();
    }

    public int countNeighbours(int z, int row, int column) {
        int result = 0;
        for (int l = z - 1; l <= z + 1; l++) {
            try {
                char[][] chars = cube[l];
                if (chars == null) {
                    continue;
                }
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        if (i == 0 && j == 0 && l == z) {
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
            } catch (ArrayIndexOutOfBoundsException e) {
                //do nowt
            }
        }
        return result;
    }

    public void cycle() {
        growCube();
        char[][][] copyOfCube = copyCube();
        writeNewCubeStates(copyOfCube);
        cube = copyOfCube;
    }

    private void writeNewCubeStates(char[][][] copyOfCube) {
        for (int z = 0; z < cube.length; z++) {
            for (int i = 0; i < cube[z].length; i++) {
                for (int j = 0; j < cube[z].length; j++) {
                    int neighbourCount = countNeighbours(z, i, j);
                    if (cube[z][i][j] == '#') {
                        if (neighbourCount == 2 || neighbourCount == 3) {
                            copyOfCube[z][i][j] = '#';
                        } else {
                            copyOfCube[z][i][j] = '.';
                        }
                    } else {
                        if (neighbourCount == 3) {
                            copyOfCube[z][i][j] = '#';
                        } else {
                            copyOfCube[z][i][j] = '.';
                        }
                    }
                }
            }
        }
    }

    private char[][][] copyCube() {
        return SerializationUtils.clone(cube);
    }

    private void growCube() {
        //grow in x-y
        int newSize = cube[0].length + 2;
        for (int z = 0; z < cube.length; z++) {
            char[][] largerLayer = new char[newSize][newSize];
            for (char[] chars : largerLayer) {
                Arrays.fill(chars, '.');
            }
            for (int i = 0; i < cube[z].length; i++) {
                for (int j = 0; j < cube[z].length; j++) {
                    largerLayer[i + 1][j + 1] = cube[z][i][j];
                }
            }
            cube[z] = largerLayer;
        }

        //grow in z
        int newZsize = cube.length + 2;
        //shift existing z-layers up one
        char[][][] newZ = new char[newZsize][][];
        for( int i=0; i< cube.length; i++) {
            newZ[i+1] = cube[i];
        }

        char[][] newBottomLayer = new char[newSize][newSize];
        for (char[] chars : newBottomLayer) {
            Arrays.fill(chars, '.');
        }
        newZ[0] = newBottomLayer;

        char[][] newTopLayer = new char[newSize][newSize];
        for (char[] chars : newTopLayer) {
            Arrays.fill(chars, '.');
        }
        newZ[newZsize - 1] = newTopLayer;
        cube = newZ;
    }
}
