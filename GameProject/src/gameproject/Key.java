package gameproject;

import javax.swing.ImageIcon;

/**
 *
 * @author baswo
 */
public class Key extends Tile {

    private final int code;
    private final String path = System.getProperty("user.dir") + "\\src\\Images\\";
    private ImageIcon icon;

    /**
     * Constructor for the Key
     *
     * @param x set coordinate
     * @param y set coordinate
     * @param code Set the code to an Integer
     */
    public Key(int x, int y, int code) {
        super(x, y);
        this.icon = new ImageIcon(path + "key.png");
        this.code = code;
        Symbol = "K";
    }

    @Override
    public ImageIcon getIcon() {
        return icon;
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
