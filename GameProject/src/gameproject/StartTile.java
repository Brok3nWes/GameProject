package gameproject;

/**
 *
 * @author baswo
 */
class StartTile extends Tile {
    public StartTile(int x, int y) {
        super(x, y);
        Transparent = true;
        Symbol = "S";
    }    

    public void startTimer() {

    }
}
