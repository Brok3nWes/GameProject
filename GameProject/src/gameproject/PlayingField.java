package gameproject;

/**
 *
 * @author baswo
 */
class PlayingField {

    Character player1 = new Character(0, 0);
    Tile tile1 = new Tile(0, 1, true);
    StartTile StartTile = new StartTile(0, 1, true);
    EndTile EndTile = new EndTile(0, 1, true);
    Wall wall1 = new Wall(0, 2, false);
    Key key1 = new Key(0, 1, true, 001);
    Barricade barricade1 = new Barricade(0, 3, false, 001);
    
}
