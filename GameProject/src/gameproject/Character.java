package gameproject;

/**
 *
 * @author baswo
 */
public class Character extends Tile {

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
        Symbol = "P";
    }

    /**
     * Getter for the x Coordinate
     *
     * @param x get coordinate
     */
    public void setxCoordinate(int x) {
        this.xCoordinate = x;
    }

    /**
     * Getter for the y Coordinate
     *
     * @param y get coordinate
     */
    public void setyCoordinate(int y) {
        this.yCoordinate = y;
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
     * @param k
     */
    public void pickupKey(Key k) {
        KeyInPocket = k;
    }

    public Key getKeyInPocket() {
        return KeyInPocket;
    }

    /**
     * Remove barricade b when called
     *
     * @param b
     */
    public void useKey(Barricade b) {
        KeyInPocket.destroyBarricade(b);
    }

//    
//    private boolean checkNextTile(int[][] pf){
//        if (pf[xCoordinate][yCoordinate].isEqualsTo("O")){
//
//        }
//        return false;
//    }
//    private boolean checkTransparency(Tile t){
//        return t.Transparent;
//    }
    /**
     * Movement UP
     */
    public void up() {
        this.yCoordinate--;
        printCoordinates();
    }

    /**
     * Movement DOWN
     */
    public void down() {
        this.yCoordinate++;
        printCoordinates();
    }

    /**
     * Movement LEFT
     */
    public void left() {
        this.xCoordinate--;
        printCoordinates();
    }

    /**
     * Movement RIGHT
     */
    public void right() {
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
//getKey(xCoordinate, yCoordinate)
