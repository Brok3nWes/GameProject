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

    public void spawnPlayer(PlayingField field) {
        Character player1 = new Character(1, 0);
        field.updateField(player1);
        while (field.lvlOver != true) {
            String command = player1.readCharacter("W,A,S,D for movement: ");
            player1.handleMovement(command, field.getField());
            field.updateField(player1);
            field.printField();
        }
    }

    public void startTimer() {

    }
}
