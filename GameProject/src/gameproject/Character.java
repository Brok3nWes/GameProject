package gameproject;

/**
 *
 * @author baswo
 */
public class Character {

    private int yCoordinate, xCoordinate, prevyCoordinate, prevxCoordinate;
    private final String Symbol = "P";

    Character(int x, int y) {
        prevxCoordinate = x;
        prevyCoordinate = y;
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

    public void pickupKey() {

    }

    public void useKey() {

    }

    public void left() {
        setPrevPos();
        this.xCoordinate--;

    }

    public void right() {
        setPrevPos();
        this.xCoordinate++;

    }

    public void up() {
        setPrevPos();
        this.yCoordinate--;
    }

    public void down() {
        setPrevPos();
        this.yCoordinate++;
    }
    private void setPrevPos(){
        prevxCoordinate = getxCoordinate();
        prevyCoordinate = getyCoordinate();
    }
}
