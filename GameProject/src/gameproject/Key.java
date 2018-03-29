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
    private final String Symbol = "K";

    public Key(int xCoordinate, int yCoordinate, boolean Transparent, int code) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.Transparent = Transparent;
        this.code = code;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public boolean isTransparent() {
        return Transparent;
    }

    public int getCode() {
        return code;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void destroyBarricade() {

    }

}
