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

    /**
     *
     * @param xCoordinate
     * @param yCoordinate
     * @param code
     */
    public Key(int xCoordinate, int yCoordinate, int code) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
        this.Transparent = true;
        this.code = code;
    }

    /**
     *
     * @return
     */
    public int getxCoordinate() {
        return xCoordinate;
    }

    /**
     *
     * @return
     */
    public int getyCoordinate() {
        return yCoordinate;
    }

    /**
     *
     * @return
     */
    public String getSymbol() {
        return Symbol;
    }

    /**
     * Destroys the barricade
     *
     * @param b for getting the code of the barricade
     */
    public void destroyBarricade(Barricade b) {
        if (b.getCode() == code) {
            System.out.println("Barricade removed!");
        } else {
            System.out.println("Nope!");
        }
    }

}
