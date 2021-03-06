package gameproject;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author baswo
 */
class Lvl {

    private int currentTime;
    private final PlayingField field;
    private final StartTile start;
    private final EndTile end;
    private final ArrayList<Wall> Walls;
    private static ArrayList<Key> Keys;
    private static ArrayList<Barricade> Barricades;

    public Lvl(createComponents component) {
        Walls = new ArrayList<>();
        Walls.add(new Wall(5, 5));
        Walls.add(new Wall(5, 4));
        Walls.add(new Wall(5, 3));
        Keys = new ArrayList<>();
        Keys.add(new Key(6, 6, 100));
        Barricades = new ArrayList<>();
        Barricades.add(new Barricade(0, 3, 100));
        field = new PlayingField(component);
        updateArrayLists();
        start = new StartTile(0, 0);
        end = new EndTile(9, 9);
        setStartEnd();
        field.printField();
        start.spawnPlayer(field);

    }

    private void updateArrayLists() {
        Walls.forEach(field::updateField);
        Keys.forEach(field::updateField);
        Barricades.forEach(field::updateField);
    }

    private void setStartEnd() {
        field.updateField(start);
        field.updateField(end);
    }
    private void removeBarricade(Barricade b){
        Barricades.remove(b);
    }

    static Key getKey(int px, int py) {
        for (Key k : Keys) {
            if (px == k.getxCoordinate() && py == k.getyCoordinate()) {
                Keys.remove(k);
                return k;
            }
        }
        return null;
    }

    static Barricade getBarricade(int px, int py) {
        for (Barricade b : Barricades) {
            if (px == b.getxCoordinate() && py == b.getyCoordinate()) {
                Barricades.remove(b);
                return b;
            }
        }
        return null;
    }
}

//        player1.down();
//        player1.right();
//        field.updateField(player1);
//        field.printField();
//    Character player1 = new Character(0, 0);
//    Tile tile1 = new Tile(0, 1, true);
//    StartTile StartTile = new StartTile(0, 1, true);
//    EndTile EndTile = new EndTile(0, 1, true);
//    Wall wall1 = new Wall(0, 2, false);
//    Key key1 = new Key(0, 1, true, 001);
//    Barricade barricade1 = new Barricade(0, 3, false, 001);
