package gameproject;

/**
 *
 * @author baswo
 */
public class Key extends Tile {

    private final int code;

    /**
     * Constructor for the Key
     *
     * @param x set coordinate
     * @param y set coordinate
     * @param code Set the code to an Integer
     */
    public Key(int x, int y, int code) {
        super(x, y);
        this.code = code;
        Symbol = "K";
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
