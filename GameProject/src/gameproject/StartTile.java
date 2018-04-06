package gameproject;

/**
 *
 * @author baswo
 */
class StartTile extends Tile {

    private Character player1;

    /**
     * Constructor for a StartTile
     *
     * @param x set coordinate
     * @param y set coordinate
     */
    public StartTile(int x, int y) {
        super(x, y);
        Transparent = true;
        Symbol = "S";
    }

    /**
     * Create Player at 0, 0
     *
     * @param field for getting the
     */
    public void spawnPlayer(Field[][] field) {
        player1 = new Character(this.xCoordinate, this.yCoordinate);
    }

    public Character getPlayer() {
        return player1;
    }

    public void startTimer() {

    }
}
