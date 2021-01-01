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
        char[][][][] copyOfCube = new char[hypercube.length + 2][hypercube[0].length + 2][hypercube[0][0].length + 2][hypercube[0][0].length + 2];
        for (int w = 0; w < copyOfCube.length; w++) {
            for (int z = 0; z < copyOfCube[w].length; z++) {
                for (int y = 0; y < copyOfCube[w][z].length; y++) {
                    Arrays.fill(copyOfCube[w][z][y], '.');
                }
            }
        }
        writeNewCubeStates(copyOfCube);
        hypercube = copyOfCube;
    }

    private void writeNewCubeStates(char[][][][] copyOfCube) {
        for (int w = -1; w <= hypercube.length; w++) {
            for (int z = -1; z <= hypercube[0].length; z++) {
                for (int y = -1; y <= hypercube[0][0].length; y++) {
                    for (int x = -1; x <= hypercube[0][0].length; x++) {
                        int neighbourCount = countNeighbours(w, z, y, x);
                        char currentState;
                        try {
                            currentState = hypercube[w][z][y][x];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            currentState = '.';
                        }
                        if (currentState == '#') {
                            if (neighbourCount == 2 || neighbourCount == 3) {
                                copyOfCube[w + 1][z + 1][y + 1][x + 1] = '#';
                            } else {
                                copyOfCube[w + 1][z + 1][y + 1][x + 1] = '.';
                            }
                        } else {
                            if (neighbourCount == 3) {
                                copyOfCube[w + 1][z + 1][y + 1][x + 1] = '#';
                            } else {
                                copyOfCube[w + 1][z + 1][y + 1][x + 1] = '.';
                            }
                        }
                    }
                }
            }
        }
    }
}
