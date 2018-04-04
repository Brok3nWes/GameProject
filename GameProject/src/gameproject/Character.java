package gameproject;

import java.util.Scanner;

/**
 *
 * @author baswo
 */
public class Character {

    private int yCoordinate, xCoordinate, prevyCoordinate, prevxCoordinate;
    private final String Symbol = "P";

    Character(int x, int y) {
//        prevxCoordinate = x;
//        prevyCoordinate = y;
        this.xCoordinate = x;
        this.yCoordinate = y;
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

    public void pickupKey() {

    }

    public void useKey() {

    }

    private void left() {
        setPrevPos();
        if (prevxCoordinate > 0) {
            this.xCoordinate--;
        }
    }

    private void right() {
        setPrevPos();
        if (prevxCoordinate < PlayingField.dimX - 1) {
            this.xCoordinate++;
        }

    }

    private void up() {
        setPrevPos();
        if (prevyCoordinate > 0) {
            this.yCoordinate--;
        }
    }

    private void down() {
        setPrevPos();
        if (prevyCoordinate < PlayingField.dimY - 1) {
            this.yCoordinate++;
        }

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

    public void handleMovement(String command) {
        switch (command) {
            case "W":
                up();
                break;
            case "A":
                left();
                break;
            case "S":
                down();
                break;
            case "D":
                right();
                break;
            case "Q":
                System.exit(0);
                break;
        }
    }
}
