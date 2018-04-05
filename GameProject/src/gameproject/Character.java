package gameproject;

import java.util.Scanner;

/**
 *
 * @author baswo
 */
public class Character {

    private int yCoordinate, xCoordinate, prevyCoordinate, prevxCoordinate;
    private final String Symbol;
    private Key KeyInPocket;

    Character(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        Symbol = "P";
    }

    public String getSymbol() {
        return Symbol;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getPrevyCoordinate() {
        return prevyCoordinate;
    }

    public int getPrevxCoordinate() {
        return prevxCoordinate;
    }

    public void pickupKey(Key k) {
        KeyInPocket = k;
        System.out.println("You got the key: " + k.getCode());
    }

    public boolean useKey(Barricade b) {
        return KeyInPocket.destroyBarricade(b);
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
    private void up() {
        this.yCoordinate--;
    }

    private void down() {
        this.yCoordinate++;
    }

    private void left() {
        this.xCoordinate--;
    }

    private void right() {
        this.xCoordinate++;

    }

    private void setPrevPos() {
        prevxCoordinate = xCoordinate;
        prevyCoordinate = yCoordinate;
    }

    public String readCharacter(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print(prompt);
        String input = keyboard.next();
        if (input.length() == 0) {
            return " ";
        } else {
            return input.substring(0, 1).toUpperCase();
        }
    }

    public void handleMovement(String command, String[][] pf) {
        setPrevPos();
        switch (command) {
            case "W":
                if (prevyCoordinate > 0) {
                    if (checkTile(pf, 0, -1)) {
                        up();
                    }
                }
                break;
            case "A":
                if (prevxCoordinate > 0) {
                    if (checkTile(pf, -1, 0)) {
                        left();
                    }
                }
                break;
            case "S":
                if (prevyCoordinate < PlayingField.dimY - 1) {
                    if (checkTile(pf, 0, 1)) {
                        down();
                    }
                }
                break;
            case "D":
                if (prevxCoordinate < PlayingField.dimX - 1) {
                    if (checkTile(pf, 1, 0)) {
                        right();
                    }
                }
                break;
            case "Q":
                System.exit(0);
                break;
        }
    }
//        else{
//        System.out.println("You can't move over there");
//        }

    private boolean checkTile(String[][] pf, int dx, int dy) {
        int newX = xCoordinate + dx;
        int newY = yCoordinate + dy;
        String nextSymbol = pf[newX][newY];
        if (nextSymbol.equalsIgnoreCase("O")) {
            return true;
        } else if (nextSymbol.equalsIgnoreCase("K")) {
            this.pickupKey(Lvl.getKey(newX, newY));
            return true;
        } else if (nextSymbol.equalsIgnoreCase("S")) {
            return true;
        } else if (nextSymbol.equalsIgnoreCase("B")) {
            System.out.println("1");
            try {
                System.out.println("2");
                return this.KeyInPocket.destroyBarricade(Lvl.getBarricade(newX, newY));
            } catch (NullPointerException e) {
                System.out.println("3");
                return false;
            }
        } else {
            System.out.println("4");
            return nextSymbol.equalsIgnoreCase("E");
        }
    }
}
//getKey(xCoordinate, yCoordinate)
