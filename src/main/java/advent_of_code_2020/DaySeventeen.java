package advent_of_code_2020;

import org.apache.commons.lang3.SerializationUtils;

import java.util.Arrays;

public class DaySeventeen {
    private char[][][][] cube = new char[1][1][][];
    private int w = 0;

    public DaySeventeen(String... input) {
        cube[0][0] = new char[input.length][];
        char[][] chars = cube[0][0];
        for (int y = 0; y < input.length; y++) {
            chars[y] = input[y].toCharArray();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int z = 0; z < cube[w].length; z++) {
            result.append("z=" + (z - cube[w].length/2) + "\n");
            for (int y = 0; y < cube[w][z].length; y++) {
                for (int x = 0; x < cube[w][z][y].length; x++) {
                    result.append(cube[w][z][y][x]);
                }
                result.append('\n');
            }
        }
        ;
        return result.toString();
    }

    public int countNeighbours(int z, int y, int x) {
        int result = 0;
        for (int zDelta = -1; zDelta <= 1; zDelta++) {
            try {
                char[][] chars = cube[w][z + zDelta];
                if (chars == null) {
                    continue;
                }
                for (int yDelta = -1; yDelta <= 1; yDelta++) {
                    for (int xDelta = -1; xDelta <= 1; xDelta++) {
                        if (yDelta == 0 && xDelta == 0 && zDelta == 0) {
                            continue;
                        }
                        try {
                            if ('#' == chars[y + yDelta][x + xDelta]) {
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
        char[][][][] copyOfCube = copyCube();
        writeNewCubeStates(copyOfCube);
        cube = copyOfCube;
    }

    private void writeNewCubeStates(char[][][][] copyOfCube) {
        for (int z = 0; z < cube[w].length; z++) {
            for (int y = 0; y < cube[w][z].length; y++) {
                for (int x = 0; x < cube[w][z].length; x++) {
                    int neighbourCount = countNeighbours(z, y, x);
                    if (cube[w][z][y][x] == '#') {
                        if (neighbourCount == 2 || neighbourCount == 3) {
                            copyOfCube[w][z][y][x] = '#';
                        } else {
                            copyOfCube[w][z][y][x] = '.';
                        }
                    } else {
                        if (neighbourCount == 3) {
                            copyOfCube[w][z][y][x] = '#';
                        } else {
                            copyOfCube[w][z][y][x] = '.';
                        }
                    }
                }
            }
        }
    }

    private char[][][][] copyCube() {
        return SerializationUtils.clone(cube);
    }

    private void growCube() {
        int newSize = growXY();
        growZ(newSize);
    }

    private int growXY() {
        int newSize = cube[w][0].length + 2;
        for (int z = 0; z < cube[w].length; z++) {
            char[][] largerXY = new char[newSize][newSize];
            for (char[] chars : largerXY) {
                Arrays.fill(chars, '.');
            }
            for (int y = 0; y < cube[w][z].length; y++) {
                for (int x = 0; x < cube[w][z].length; x++) {
                    largerXY[y + 1][x + 1] = cube[w][z][y][x];
                }
            }
            cube[w][z] = largerXY;
        }
        return newSize;
    }

    private void growZ(int newSize) {
        int newZsize = cube[w].length + 2;
        //shift existing z-layers up one
        char[][][] newZ = new char[newZsize][][];
        for( int z=0; z<cube[w].length; z++) {
            newZ[z+1] = cube[w][z];
        }

        char[][] newMinZ = new char[newSize][newSize];
        for (char[] chars : newMinZ) {
            Arrays.fill(chars, '.');
        }
        newZ[0] = newMinZ;

        char[][] newMax = new char[newSize][newSize];
        for (char[] chars : newMax) {
            Arrays.fill(chars, '.');
        }
        newZ[newZsize - 1] = newMax;
        cube[w] = newZ;
    }
}
