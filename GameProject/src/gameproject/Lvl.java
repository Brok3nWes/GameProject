package gameproject;

/**
 *
 * @author baswo
 */
class Lvl {

    private int currentTime;
    private PlayingField field;
    public Lvl(createComponents component){
        field = new PlayingField(component);
        Character player1 = new Character(0, 0);
        Key key1 = new Key(9, 9, true, 001);
        Barricade barricade1 = new Barricade(0, 3, false, 001);
        field.updateField(barricade1);
        field.updateField(key1);
        field.updateField(player1);
        field.printField();
        while (field.lvlOver != true){
            String command = player1.readCharacter("W,A,S,D for movement: ");
            player1.handleMovement(command);
            field.updateField(player1);
            field.printField();
        }
        
//        player1.down();
//        player1.right();
//        field.updateField(player1);
//        field.printField();
    }
}

//    Character player1 = new Character(0, 0);
//    Tile tile1 = new Tile(0, 1, true);
//    StartTile StartTile = new StartTile(0, 1, true);
//    EndTile EndTile = new EndTile(0, 1, true);
//    Wall wall1 = new Wall(0, 2, false);
//    Key key1 = new Key(0, 1, true, 001);
//    Barricade barricade1 = new Barricade(0, 3, false, 001);