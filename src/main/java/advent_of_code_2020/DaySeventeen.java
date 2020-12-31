package advent_of_code_2020;

import org.apache.commons.lang3.SerializationUtils;

import java.util.Arrays;

public class DaySeventeen {
    private char[][][][] hypercube = new char[1][1][][];

    public DaySeventeen(String... input) {
        hypercube[0][0] = new char[input.length][];
        char[][] chars = hypercube[0][0];
        for (int y = 0; y < input.length; y++) {
            chars[y] = input[y].toCharArray();
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int w = 0; w < hypercube.length; w++) {
            for (int z = 0; z < hypercube[w].length; z++) {
                result.append("z=" + (z - hypercube[w].length / 2) + ", w=" + (w - hypercube.length / 2) + "\n");
                for (int y = 0; y < hypercube[w][z].length; y++) {
                    for (int x = 0; x < hypercube[w][z][y].length; x++) {
                        result.append(hypercube[w][z][y][x]);
                    }
                    result.append('\n');
                }
                result.append("\n");
            }
        }
        return result.toString();
    }

    public int countNeighbours(int w, int z, int y, int x) {
        int result = 0;
        for (int wDelta = -1; wDelta <= 1; wDelta++) {
            try {
                char[][][] zS = hypercube[w + wDelta];
                if (zS == null) {
                    continue;
                }
                for (int zDelta = -1; zDelta <= 1; zDelta++) {
                    try {
                        char[][] chars = hypercube[w + wDelta][z + zDelta];
                        if (chars == null) {
                            continue;
                        }
                        for (int yDelta = -1; yDelta <= 1; yDelta++) {
                            for (int xDelta = -1; xDelta <= 1; xDelta++) {
                                if (yDelta == 0 && xDelta == 0 && zDelta == 0 && wDelta == 0) {
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
        hypercube = copyOfCube;
    }

    private void writeNewCubeStates(char[][][][] copyOfCube) {
        for (int w = 0; w < hypercube.length; w++) {
            for (int z = 0; z < hypercube[w].length; z++) {
                for (int y = 0; y < hypercube[w][z].length; y++) {
                    for (int x = 0; x < hypercube[w][z].length; x++) {
                        int neighbourCount = countNeighbours(w, z, y, x);
                        if (hypercube[w][z][y][x] == '#') {
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
    }

    private char[][][][] copyCube() {
        return SerializationUtils.clone(hypercube);
    }

    private void growCube() {
        int newXYSize = growXY();
        int newZSize = growZ(newXYSize);
        int newWSize = growW(newXYSize, newZSize);
    }

    private int growXY() {
        int newSize = hypercube[0][0].length + 2;
        for (int w = 0; w < hypercube.length; w++) {
            for (int z = 0; z < hypercube[w].length; z++) {
                char[][] largerXY = new char[newSize][newSize];
                for (char[] chars : largerXY) {
                    Arrays.fill(chars, '.');
                }
                for (int y = 0; y < hypercube[w][z].length; y++) {
                    for (int x = 0; x < hypercube[w][z].length; x++) {
                        largerXY[y + 1][x + 1] = hypercube[w][z][y][x];
                    }
                }
                hypercube[w][z] = largerXY;
            }
        }
        return newSize;
    }

    private int growZ(int newSize) {
        int newZsize = hypercube[0].length + 2;
        //shift existing z-layers up one
        char[][][] newZ = new char[newZsize][][];
        for (int z = 0; z < hypercube[0].length; z++) {
            newZ[z + 1] = hypercube[0][z];
        }

        char[][] newMinZ = new char[newSize][newSize];
        for (char[] chars : newMinZ) {
            Arrays.fill(chars, '.');
        }
        newZ[0] = newMinZ;

        char[][] newMaxZ = new char[newSize][newSize];
        for (char[] chars : newMaxZ) {
            Arrays.fill(chars, '.');
        }
        newZ[newZsize - 1] = newMaxZ;

        for (int w = 0; w < hypercube.length; w++) {
            hypercube[w] = newZ;
        }

        return newZsize;
    }

    private int growW(int newXYSize, int newZSize) {
        int newWSize = hypercube.length + 2;
        char[][][][] newW = new char[newWSize][][][];
        for (int w = 0; w < hypercube.length; w++) {
            newW[w + 1] = hypercube[w];
        }

        char[][][] newMinW = new char[newZSize][newXYSize][newXYSize];
        for (char[][] zS : newMinW) {
            for (char[] chars : zS) {
                Arrays.fill(chars, '.');
            }
        }
        newW[0] = newMinW;

        char[][][] newMaxW = new char[newZSize][newXYSize][newXYSize];
        for (char[][] zS : newMaxW) {
            for (char[] chars : zS) {
                Arrays.fill(chars, '.');
            }
        }
        newW[newWSize - 1] = newMaxW;
        hypercube = newW;

        return newWSize;
    }
}
