package gameproject;

/**
 *
 * @author baswo
 */
public class Key {

    private final int xCoordinate;
    private final int yCoordinate;
    private final boolean Transparent;
    private final int code;

    public Key(int xCoordinate, int yCoordinate, boolean Transparent, int code) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.Transparent = Transparent;
        this.code = code;
    }

    public void destroyBarricade() {

    }

}
