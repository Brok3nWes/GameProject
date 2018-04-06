package gameproject;

/**
 *
 * @author baswo
 */
public class Tile {

    int xCoordinate;
    int yCoordinate;
    public boolean Transparent;
    public String Symbol;

    /**
     * Constructor for a Tile
     *
     * @param x set coordinate
     * @param y set coordinate
     */
    Tile(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        Transparent = false;
        Symbol = "O";
    }

    /**
     * Getter for the x Coordinate
     *
     * @return x
     */
    public int getxCoordinate() {
        return xCoordinate;
    }

    /**
     * Getter for the y coordinate
     *
     * @return y
     */
    public int getyCoordinate() {
        return yCoordinate;
    }
}
