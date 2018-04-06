package gameproject;

/**
 *
 * @author baswo
 */
public class Wall extends Tile {

    /**
     * Constructor for a wall
     *
     * @param x set coordinate
     * @param y set coordinate
     */
    public Wall(int x, int y) {
        super(x, y);
        Transparent = false;
        Symbol = "W";
    }

}
