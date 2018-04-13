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
     * Getter for the code
     *
     * @return the code that has been set for the key
     */
    public int getCode() {
        return code;
    }

    /**
     * Destroys the barricade
     *
     * @param b for getting the code of the barricade
     * @return returning if the removing worked
     */
    public boolean destroyBarricade(Barricade b) {
        if (b.getCode() == code) {
            System.out.println("Barricade removed!");
            return true;
        } else {
            System.out.println("Nope!");
            return false;
        }
    }

}
