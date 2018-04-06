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
    public boolean lvlOver;
    private StartTile ST;

    /**
     * Generate the random PlayingField
     */
    public PlayingField() {
        lvlOver = false;
        pf = new Field[dimX][dimY];
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                if (y == 0 && x == 0) {
                    ST = new StartTile(x, y);
                    pf[x][y] = new Field(ST);
                    pf[x][y].getTile();
                    
//                    pf[x][y] = new StartTile(x, y);
                } else {
                    Random rnd = new Random();
                    int n = rnd.nextInt(4);
                    if (n == 0 || n == 1) {
                        pf[x][y] = new Field(new EmptyTile(x, y));
                        System.out.print("O");
                    }
                    if (n == 2) {
                        pf[x][y] = new Field(new Barricade(x, y, 100));
                        System.out.print("B");
                    }
                    if (n == 3) {
                        pf[x][y] = new Field(new Wall(x, y));
                        System.out.print("W");
                    }
                    if (x == 9 && y == 9) {
                        pf[x][y] = new Field(new EndTile(x, y));
                        System.out.print("E");
                    }
                }
            }
        }
    }

    /**
     * Getter for the PlayingField
     *
     * @return PlayingField
     */
    public Field[][] getPf() {
        return pf;
    }

    public void printField() {
//        for (int y = dimY - 1; y >= 0; y--) {
        for (int y = 0; y < dimY; y++) {
            for (int x = 0; x < dimX; x++) {
                System.out.print(pf[x][y].getTile().Symbol);

            }
            System.out.println();
        }
    }

//    public void printField() {
////        for (int y = dimY - 1; y >= 0; y--) {
//        for (int y = 0; y < dimY; y++) {
//            for (int x = 0; x < dimX; x++) {
//                System.out.print(pf[x][y]);
//            }
//            System.out.println();
//        }
//    }
    public void updateField(Character c) {
        int xpos = c.getxCoordinate();
        int ypos = c.getyCoordinate();
        int prevxpos = c.getPrevxCoordinate();
        int prevypos = c.getPrevyCoordinate();
//        pf[prevxpos][prevypos] = c;
//        pf[xpos][ypos]. = c;
    }

}
