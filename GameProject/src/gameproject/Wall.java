package gameproject;

/**
 *
 * @author baswo
 */
public class Wall extends Tile {

    public Wall(int x, int y) {
        super(x, y);
        Transparent = false;
        Symbol = "W";
    }

}
