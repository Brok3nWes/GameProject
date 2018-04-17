package gameproject;

/**
 *
 * @author baswo
 */
public class Field {

    private final Tile tile;

    /**
     * Constructor for a field with a tile
     *
     * @param tile
     */
    public Field(Tile tile) {
        this.tile = tile;
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
