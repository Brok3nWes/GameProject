package gameproject;

/**
 *
 * @author baswo
 */
class PlayingField {

    public static int dimX = 10;
    public static int dimY = 10;
    private final String[][] pf;

    public PlayingField() {
        pf = new String[dimX][dimY];
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                pf[x][y] = "O";
            }
        }
    }

    public void showField() {
//        for (int y = dimY - 1; y >= 0; y--) {
        for (int y = 0; y < dimY; y++) {
            for (int x = 0; x < dimX; x++) {
                System.out.print(pf[x][y]);
            }
            System.out.println();
        }
    }

    public void updateField(Character c) {
        int xpos = c.getxCoordinate();
        int ypos = c.getyCoordinate();
        String symbol = c.getSymbol();
        pf[xpos][ypos] = symbol;
    }

    public void updateField(Key k) {
        int xpos = k.getxCoordinate();
        int ypos = k.getyCoordinate();
        String symbol = k.getSymbol();
        pf[xpos][ypos] = symbol;
    }

    public void updateField(Barricade b) {
        int xpos = b.getxCoordinate();
        int ypos = b.getyCoordinate();
        String symbol = b.getSymbol();
        pf[xpos][ypos] = symbol;
    }
    
}
