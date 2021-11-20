package advent_of_code_2020;

import java.util.Objects;

public class HexTile {
    private int hexX;
    private int hexY;

    public HexTile(int hexX, int hexY) {
        this.hexX = hexX;
        this.hexY = hexY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HexTile hexTile = (HexTile) o;
        return hexX == hexTile.hexX && hexY == hexTile.hexY;
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

    public HexTile northEast() {
        return new HexTile(hexX + 1, hexY + 1);
    }

    public HexTile east() {
        return new HexTile(hexX + 2, hexY);
    }

    public HexTile southEast() {
        return new HexTile(hexX + 1, hexY - 1);
    }

    public HexTile southWest() {
        return new HexTile( hexX - 1, hexY - 1);
    }

    public HexTile west() {
        return new HexTile(hexX - 2, hexY);
    }

    public HexTile northWest() {
        return new HexTile(hexX - 1, hexY + 1);
    }
}
