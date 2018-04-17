package gameproject;

/**
 *
 * @author baswo
 */
public class Field {

    private Tile tile;

    /**
     * Constructor for a field with a tile
     *
     * @param tile
     */
    public Field(Tile tile) {
        this.tile = tile;
    }

    /**
     * Create EmptyTile with the coordinates
     *
     * @param x set coordinate
     * @param y set coordinate
     */
    public void resetTile(int x, int y) {
        Tile t = new EmptyTile(x, y);
        this.tile = t;
    }

    /**
     * Getter for Tile
     *
     * @return tile
     */
    public Tile getTile() {
        return tile;
    }
}
