package gameproject;

import javax.swing.ImageIcon;

/**
 *
 * @author baswo
 */
public class Character extends Tile {

    private final String path = System.getProperty("user.dir") + "\\src\\Images\\";
    private int prevyCoordinate;
    private int prevxCoordinate;
    private Key KeyInPocket;

    /**
     * Constructor for the Character
     *
     * @param x set coordinate
     * @param y set coordinate
     */
    public Character(int x, int y) {
        super(x, y);
        this.icon = new ImageIcon(path + "player.png");
        Symbol = "C";
    }

    /**
     * Getter for the x Coordinate
     *
     * @return previousY
     */
    public int getPrevyCoordinate() {
        return prevyCoordinate;
    }

    /**
     * Getter for the x Coordinate
     *
     * @return previousY
     */
    public int getPrevxCoordinate() {
        return prevxCoordinate;
    }

    /**
     * Setter for the Key
     *
     * @param k key to pickup
     * @return boolean true when key is picked up
     */
    public boolean pickupKey(Key k) {
        KeyInPocket = k;
        return true;
    }

    public Key getKeyInPocket() {
        return KeyInPocket;
    }

    /**
     * Remove barricade b when called
     *
     * @param b barricade to destroy
     * @return boolean true if barricade is destroyed
     */
    public boolean useKey(Barricade b) {
        return KeyInPocket.destroyBarricade(b);
    }

    /**
     * Movement UP
     */
    public void up() {
        setPrevPos();
        this.yCoordinate--;
        printCoordinates();
    }

    /**
     * Movement DOWN
     */
    public void down() {
        setPrevPos();
        this.yCoordinate++;
        printCoordinates();
    }

    /**
     * Movement LEFT
     */
    public void left() {
        setPrevPos();
        this.xCoordinate--;
        printCoordinates();
    }

    /**
     * Movement RIGHT
     */
    public void right() {
        setPrevPos();
        this.xCoordinate++;
        printCoordinates();

    }

    /**
     * Set previous coordinates to current coordinates (only use when player
     * moves)
     */
    public void setPrevPos() {//public for unittest
        prevxCoordinate = xCoordinate;
        prevyCoordinate = yCoordinate;
    }

    /**
     * Print the coordinates for debug purposes
     */
    private void printCoordinates() {
        System.out.println("Previous coordinates = " + "x:" + prevxCoordinate + "y:" + prevyCoordinate);
        System.out.println("New coordinates = " + "x:" + xCoordinate + "y:" + yCoordinate);
    }
}
