package gameproject;

import java.util.Random;

/**
 *
 * @author baswo
 */
class PlayingField {

    public static int dimX = 10;
    public static int dimY = 10;
    private final Field[][] pf;
    private String[] customLevel1, customLevel2, customLevel3;
    public boolean lvlOver;
    private StartTile ST;
    int i;
    int LvlInt;  //0 = randomly generated level

    /**
     * Generate the random PlayingField
     */
    public PlayingField() {
        lvlOver = false;
        pf = new Field[dimX][dimY];
    }

    /**
     * Getter for the PlayingField
     *
     * @return PlayingField
     */
    public Field[][] getPf() {
        return pf;
    }

    /**
     * Getter for the StartTile
     *
     * @return StartTile
     */
    public StartTile getStartTile() {
        return ST;
    }

    /**
     * Setting the level to what the user wants
     *
     * @param lvl what level it will be (0 for random)
     */
    public void setLvl(int lvl) {
        LvlInt = lvl;

        // T = normal tile, B = barricade100, W = wall, @ = barricade200
        // K = key100, ! = key200, E = end, S = start
        customLevel1 = new String[]{
            "S", "B", "T", "W", "T", "K", "W", "T", "T", "T",
            "T", "T", "K", "W", "T", "T", "W", "W", "W", "W",
            "T", "T", "T", "W", "T", "T", "@", "W", "T", "T",
            "W", "W", "B", "W", "W", "@", "T", "T", "T", "T",
            "T", "T", "T", "@", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "@", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "W", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "W", "T", "T", "T", "W", "B", "W",
            "T", "T", "!", "W", "W", "W", "B", "W", "@", "W",
            "T", "T", "T", "W", "!", "T", "T", "W", "T", "E", ""};

        customLevel2 = new String[]{
            "S", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "!", "@", "B", "K", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "W", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "W", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "W", "T", "T", "T", "T", "T", "E", ""};

        customLevel3 = new String[]{
            "S", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "W", "W", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "B", "B", "W", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "E", ""};

        if (LvlInt == 0) {
            for (int x = 0; x < dimX; x++) {
                for (int y = 0; y < dimY; y++) {
                    if (x == 9 && y == 9) {
                        pf[x][y] = new Field(new EndTile(x, y));
                        System.out.print("E");
                    } else {
                        if (y == 0 && x == 0) {
                            ST = new StartTile(x, y);
                            pf[x][y] = new Field(ST);
                            System.out.print("S");
                        } else {
                            Random rnd = new Random();
                            int n = rnd.nextInt(15 + 1);
                            if (n == 0) {
                                pf[x][y] = new Field(new Key(x, y, 100));
                                System.out.print("K");
                            }
                            if (n == 1) {
                                pf[x][y] = new Field(new Key(x, y, 200));
                                System.out.print("!");
                            }
                            if (n >= 2 && n <= 6) {
                                pf[x][y] = new Field(new EmptyTile(x, y));
                                System.out.print("O");
                            }
                            if (n >= 7 && n <= 9) {
                                pf[x][y] = new Field(new Wall(x, y));
                                System.out.print("W");
                            }
                            if (n >= 10 && n <= 12) {
                                pf[x][y] = new Field(new Barricade(x, y, 100));
                                System.out.print("B");
                            }
                            if (n >= 13 && n <= 15) {
                                pf[x][y] = new Field(new Barricade(x, y, 200));
                                System.out.print("@");
                            }
                        }
                    }

                }
            }
        } else {

            for (int x = 0; x < dimX; x++) {
                for (int y = 0; y < dimY; y++) {
                    if (i == 99) {
                        pf[x][y] = new Field(new EndTile(x, y));
                        System.out.print("E");
                    } else {
                        if (i == 0) {
                            ST = new StartTile(x, y);
                            pf[x][y] = new Field(ST);
                            pf[x][y].getTile();
                            System.out.print("S");
                            i++;
                        } else {
                            String n = "";
                            if (LvlInt == 1) {
                                n = customLevel1[i];
                            }
                            if (LvlInt == 2) {
                                n = customLevel2[i];
                            }
                            if (LvlInt == 3) {
                                n = customLevel3[i];
                            }
                            if ("T".equals(n)) {
                                pf[x][y] = new Field(new EmptyTile(x, y));
                                System.out.print("O");
                                i++;
                            }
                            if ("B".equals(n)) {
                                pf[x][y] = new Field(new Barricade(x, y, 100));
                                System.out.print("B");
                                i++;
                            }
                            if ("@".equals(n)) {
                                pf[x][y] = new Field(new Barricade(x, y, 200));
                                System.out.print("@");
                                i++;
                            }
                            if ("W".equals(n)) {
                                pf[x][y] = new Field(new Wall(x, y));
                                System.out.print("W");
                                i++;
                            }
                            if ("K".equals(n)) {
                                pf[x][y] = new Field(new Key(x, y, 100));
                                System.out.print("K");
                                i++;
                            }
                            if ("!".equals(n)) {
                                pf[x][y] = new Field(new Key(x, y, 200));
                                System.out.print("!");
                                i++;
                            }
                            if ("C".equals(n)) {
                                pf[x][y] = new Field(new Character(x, y));
                                System.out.print("C");
                                i++;
                            }
                        }
                    }
                }
            }
        }
    }
}
