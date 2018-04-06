package gameproject;

/**
 *
 * @author baswo
 */
class StartTile extends Tile {

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
    public void spawnPlayer(PlayingField field) {
        Character player1 = new Character(this.xCoordinate, this.yCoordinate);
        field.updateField(player1);
        while (field.lvlOver != true) {
            String command = player1.readCharacter("W,A,S,D for movement: ");
            player1.handleMovement(command, field.getPf());
            field.updateField(player1);
            field.printField();
        }
    }

    public void startTimer() {

    }
}
