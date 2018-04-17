package gameproject;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author baswo
 */
public class Tile extends JLabel {

    int xCoordinate;
    int yCoordinate;
    public String Symbol;
    ImageIcon icon;

    /**
     * Constructor for a Tile
     *
     * @param x set coordinate
     * @param y set coordinate
     */
    Tile(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        Symbol = "O";
    }

    /**
     * Getter for Icon
     *
     * @return icon
     */
    @Override
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * Getter for the x Coordinate
     *
     * @return x
     */
    public int getxCoordinate() {
        return xCoordinate;
    }

    /**
     * Getter for the y coordinate
     *
     * @return y
     */
    public int getyCoordinate() {
        return yCoordinate;
    }
}
