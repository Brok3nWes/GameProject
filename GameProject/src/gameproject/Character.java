package gameproject;

import java.util.Scanner;

/**
 *
 * @author baswo
 */
public class Character extends Tile {

    private int prevyCoordinate, prevxCoordinate;
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
    private void up() {
        this.yCoordinate--;
    }

    /**
     * Movement DOWN
     */
    private void down() {
        this.yCoordinate++;
    }

    /**
     * Movement LEFT
     */
    private void left() {
        this.xCoordinate--;
    }

    /**
     * Movement RIGHT
     */
    private void right() {
        this.xCoordinate++;

    }

    /**
     * Set previous coordinates to current coordinates (only use when player
     * moves)
     */
    private void setPrevPos() {
        prevxCoordinate = xCoordinate;
        prevyCoordinate = yCoordinate;
    }

    /**
     * Read the character in the CommandLine
     *
     * @param prompt what message it shall give
     * @return what character has been put in
     */
    public String readCharacter(String prompt) {
        System.out.print(prompt);
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.next();
        if (input.length() == 0) {
            return " ";
        } else {
            return input.substring(0, 1).toUpperCase();
        }
    }

    /**
     * Handler for movement
     *
     * @param command what command has been given
     * @param pf to get the information of the next tile
     */
    public void handleMovement(int command, Field[][] pf) {
        setPrevPos();
        ActionEnum code = ActionEnum.getEnumName(command);
        if (code != null) {
            switch (code) {
                case UP:
                    if (prevyCoordinate > 0) {
                        if (checkTile(pf, 0, -1)) {
                            up();
                        }
                    }
                    System.out.println("UP WE GO");
                    printCoordinates();
                    break;
                case LEFT:
                    if (prevxCoordinate > 0) {
                        if (checkTile(pf, -1, 0)) {
                            left();
                        }
                    }
                    System.out.println("LEFT WE GO");
                    printCoordinates();
                    break;
                case DOWN:
                    if (prevyCoordinate < PlayingField.dimY - 1) {
                        if (checkTile(pf, 0, 1)) {
                            down();
                        }
                    }
                    System.out.println("DOWN WE GO");
                    printCoordinates();
                    break;
                case RIGHT:
                    if (prevxCoordinate < PlayingField.dimX - 1) {
                        if (checkTile(pf, 1, 0)) {
                            right();
                        }
                    }
                    System.out.println("RIGHT WE GO");
                    printCoordinates();
                    break;
                case ESCAPE:
                    System.out.println("Pause da game?!!!!");

//                    System.exit(0);
                    break;
            }
        }
    }
//        else{
//        System.out.println("You can't move over there");
//        }

    /**
     * Checking if the next move is possible
     *
     * @param pf Field to check
     * @param dx how far there should be checked relative to the player x
     * @param dy how far there should be checked relative to the player y
     * @return boolean if it is a valid space or not
     */
    private boolean checkTile(Field[][] pf, int dx, int dy) {
        if (pf[xCoordinate + dx][yCoordinate + dy].getTile().Symbol.equalsIgnoreCase("O")) {
            return true;
        } else if (pf[xCoordinate + dx][yCoordinate + dy].getTile().Symbol.equalsIgnoreCase("K")) {
//            pickupKey();
            return true;
        } else if (pf[xCoordinate + dx][yCoordinate + dy].getTile().Symbol.equalsIgnoreCase("S")) {
            return true;
        } else {
            return pf[xCoordinate + dx][yCoordinate + dy].getTile().Symbol.equalsIgnoreCase("E");
        }
    }

    private void printCoordinates() {
        System.out.println("Previous coordinates = " + "x:" + prevxCoordinate + "y:" + prevyCoordinate);
        System.out.println("New coordinates = " + "x:" + xCoordinate + "y:" + yCoordinate);
    }
}
//getKey(xCoordinate, yCoordinate)
