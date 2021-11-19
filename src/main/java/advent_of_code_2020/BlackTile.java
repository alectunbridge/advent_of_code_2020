package advent_of_code_2020;

import java.util.Objects;

public class BlackTile {
    private int hexX;
    private int hexY;

    public BlackTile(int hexX, int hexY) {
        this.hexX = hexX;
        this.hexY = hexY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BlackTile blackTile = (BlackTile) o;
        return hexX == blackTile.hexX && hexY == blackTile.hexY;
    }

    @Override
    public int hashCode() {
        return Objects.hash(hexX, hexY);
    }

    @Override
    public String toString() {
        return "BlackTile{" +
                "hexX=" + hexX +
                ", hexY=" + hexY +
                '}';
    }
}
