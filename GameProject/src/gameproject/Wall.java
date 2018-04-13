package gameproject;

import javax.swing.ImageIcon;

/**
 *
 * @author baswo
 */
public class Wall extends Tile {

    private final String path = System.getProperty("user.dir") + "\\src\\Images\\";
    private ImageIcon icon;

    @Override
    public ImageIcon getIcon() {
        return icon;
    }
    /**
     * Constructor for a wall
     *
     * @param x set coordinate
     * @param y set coordinate
     */
    public Wall(int x, int y) {
        super(x, y);
        this.icon = new ImageIcon(path + "wall.png");
        Transparent = false;
        Symbol = "W";
    }

}
