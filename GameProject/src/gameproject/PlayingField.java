package gameproject;

import java.lang.reflect.Array;
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
    int i = 0;
    int CustomGame = 0;  //0 = randomly generated level
    /**
     * Generate the random PlayingField
     */
    public PlayingField() {
        lvlOver = false;
        pf = new Field[dimX][dimY];
        
        
       String[] customLevel1 = {"S","B","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","W","T","T","B","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","E",""};
       
       String[] customLevel2 = {"S","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","B","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","W","T","T","T","T","T","T"
                               ,"T","T","T","W","T","T","T","T","T","T"
                               ,"T","T","T","W","T","T","T","T","T","E",""};
       
       String[] customLevel3 = {"S","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","W","W","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","B","B","W","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","T"
                               ,"T","T","T","T","T","T","T","T","T","E",""};
       if (CustomGame==0){
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                
                if (x == 9 && y == 9) {
                        pf[x][y] = new Field(new EndTile(x, y));
                        System.out.print("E");
                } else {
                if (y == 0 && x == 0) {
                    ST = new StartTile(x, y);
                    pf[x][y] = new Field(ST);
                    pf[x][y].getTile();
                    System.out.print("S");
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
                }}
                    
                
                
            }
        }
        } else {
           
       
                
                        for (int x = 0; x < dimX; x++) {
                        for (int y = 0; y < dimY; y++) {
                            
                            if (i==99) {
                            pf[x][y] = new Field(new EndTile(x, y));
                            System.out.print("E");
                                } else {
                                    if (i==0) {
                                    ST = new StartTile(x, y);
                                    pf[x][y] = new Field(ST);
                                    pf[x][y].getTile();
                                    System.out.print("S");
                                    i++;

                } else {
                    String n = "";
                    if(CustomGame==1){
                    n = customLevel1[i];
                    }
                    if(CustomGame==2){
                    n = customLevel2[i];
                    }
                    if(CustomGame==3){
                    n = customLevel3[i];
                    }
                    if (n == "T") {
                        pf[x][y] = new Field(new EmptyTile(x, y));
                        System.out.print("O");
                        i++;
                    }
                    if (n == "B") {
                        pf[x][y] = new Field(new Barricade(x, y, 100));
                        System.out.print("B");
                        i++;
                    }
                    if (n == "W") {
                        pf[x][y] = new Field(new Wall(x, y));
                        System.out.print("W");
                        i++;
                    }
                }}   
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

    public void changeLevel(int lvl){
        if(lvl==1){
            CustomGame =1;
        }
        if(lvl==2){
            CustomGame =2;
        }
        if(lvl==3){
            CustomGame=3;
        }
    }
}
