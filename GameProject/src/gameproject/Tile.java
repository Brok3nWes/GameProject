package gameproject;

/**
 *
 * @author baswo
 */
class Tile {

    private final int xCoordinate;
    private final int yCoordinate;
    public boolean Transparent;
    public String Symbol;

    Tile(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        Transparent = false;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }
}
