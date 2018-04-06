/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import static gameproject.PlayingField.dimX;
import static gameproject.PlayingField.dimY;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author baswo
 */
public class CharacterTest {

    public CharacterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setxCoordinate method, of class Character.
     */
    @Test
    public void testSetxCoordinate() {
        System.out.println("setxCoordinate");
        int expResult = 8;
        Character instance = new Character(3, 5);
        instance.setxCoordinate(expResult);
        int result = instance.getxCoordinate();
        assertEquals(expResult, result);
    }

    /**
     * Test of setyCoordinate method, of class Character.
     */
    @Test
    public void testSetyCoordinate() {
        System.out.println("setyCoordinate");
        int expResult = 4;
        Character instance = new Character(3, 5);
        instance.setyCoordinate(expResult);
        int result = instance.getyCoordinate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrevyCoordinate method, of class Character.
     */
    @Test
    public void testGetPrevyCoordinate() {
        System.out.println("getPrevyCoordinate");
        int expResult = 5;
        Character instance = new Character(3, 5);
        instance.setPrevPos();
        instance.setyCoordinate(8);
        int result = instance.getPrevyCoordinate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrevxCoordinate method, of class Character.
     */
    @Test
    public void testGetPrevxCoordinate() {
        System.out.println("getPrevxCoordinate");
        int expResult = 3;
        Character instance = new Character(3, 5);
        instance.setPrevPos();
        instance.setxCoordinate(8);
        int result = instance.getPrevxCoordinate();
        assertEquals(expResult, result);
    }

    /**
     * Test of pickupKey method, of class Character.
     */
    @Test
    public void testPickupKey() {
        System.out.println("pickupKey");
        Key expResult = new Key(4, 5, 100);
        Character instance = new Character(3, 5);
        instance.pickupKey(expResult);
        Key result = instance.getKeyInPocket();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrevyCoordinate method, of class Character.
     */
    @Test
    public void testGetKeyInPocket() {
        System.out.println("getKeyInPocket");
        Key expResult = new Key(4, 5, 100);
        Character instance = new Character(3, 5);
        instance.pickupKey(expResult);
        Key result = instance.getKeyInPocket();
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of useKey method, of class Character.
//     */
//    @Test
//    public void testUseKey() {
//        System.out.println("useKey");
//        Barricade b = null;
//        Character instance = null;
//        instance.useKey(b);
//    }

    /**
     * Test of handleMovement method, of class Character.
     */
    @Test
    public void testHandleMovementRRD() {
        System.out.println("handleMovement");
        Field[][] pf = new Field[dimX][dimY];
        String[] customLevel1 = new String[]{
            "S", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "W", "T", "T", "B", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "E", ""};
        int i = 0;
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                if (i == 99) {
                    pf[x][y] = new Field(new EndTile(x, y));
                    System.out.print("E");
                } else {
                    String n = customLevel1[i];
                    if (i == 0) {
                        StartTile ST = new StartTile(x, y);
                        pf[x][y] = new Field(ST);
                        pf[x][y].getTile();
                        System.out.print("S");
                        i++;

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
                    if ("W".equals(n)) {
                        pf[x][y] = new Field(new Wall(x, y));
                        System.out.print("W");
                        i++;
                    }
                }
            }
        }
        Character instance = new Character(0, 0);
        instance.handleMovement(39, pf);
        instance.handleMovement(39, pf);
        instance.handleMovement(40, pf);
        int[] expResult = new int[]{2, 1};
        int[] result = new int[]{instance.getxCoordinate(), instance.getyCoordinate()};
        Assert.assertArrayEquals(expResult, result);
    }

    /**
     * Test of handleMovement method, of class Character.
     */
    @Test
    public void testHandleMovementRDLU() {
        System.out.println("handleMovement");
        Field[][] pf = new Field[dimX][dimY];
        String[] customLevel1 = new String[]{
            "S", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "W", "T", "T", "B", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "E", ""};
        int i = 0;
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                if (i == 99) {
                    pf[x][y] = new Field(new EndTile(x, y));
                    System.out.print("E");
                } else {
                    String n = customLevel1[i];
                    if (i == 0) {
                        StartTile ST = new StartTile(x, y);
                        pf[x][y] = new Field(ST);
                        pf[x][y].getTile();
                        System.out.print("S");
                        i++;

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
                    if ("W".equals(n)) {
                        pf[x][y] = new Field(new Wall(x, y));
                        System.out.print("W");
                        i++;
                    }
                }
            }
        }
        Character instance = new Character(5, 5);
        instance.handleMovement(39, pf);//right
        instance.handleMovement(40, pf);//down
        instance.handleMovement(37, pf);//left
        instance.handleMovement(38, pf);//up
        int[] expResult = new int[]{5, 5};
        int[] result = new int[]{instance.getxCoordinate(), instance.getyCoordinate()};
        Assert.assertArrayEquals(expResult, result);
    }

    /**
     * Test of handleMovement method, of class Character.
     */
    @Test
    public void testHandleMovementDx20() {
        System.out.println("handleMovement");
        Field[][] pf = new Field[dimX][dimY];
        String[] customLevel1 = new String[]{
            "S", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "W", "T", "T", "B", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "E", ""};
        int i = 0;
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                if (i == 99) {
                    pf[x][y] = new Field(new EndTile(x, y));
                    System.out.print("E");
                } else {
                    String n = customLevel1[i];
                    if (i == 0) {
                        StartTile ST = new StartTile(x, y);
                        pf[x][y] = new Field(ST);
                        pf[x][y].getTile();
                        System.out.print("S");
                        i++;

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
                    if ("W".equals(n)) {
                        pf[x][y] = new Field(new Wall(x, y));
                        System.out.print("W");
                        i++;
                    }
                }
            }
        }
        Character instance = new Character(0, 0);
        for (int c = 0; c <= 20; c++){
        instance.handleMovement(40, pf);
        }
        int[] expResult = new int[]{0, 9};
        int[] result = new int[]{instance.getxCoordinate(), instance.getyCoordinate()};
        Assert.assertArrayEquals(expResult, result);
    }

    /**
     * Test of handleMovement method, of class Character.
     */
    @Test
    public void testHandleMovementRx20() {
        System.out.println("handleMovement");
        Field[][] pf = new Field[dimX][dimY];
        String[] customLevel1 = new String[]{
            "S", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "W", "T", "T", "B", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "T",
            "T", "T", "T", "T", "T", "T", "T", "T", "T", "E", ""};
        int i = 0;
        for (int x = 0; x < dimX; x++) {
            for (int y = 0; y < dimY; y++) {
                if (i == 99) {
                    pf[x][y] = new Field(new EndTile(x, y));
                    System.out.print("E");
                } else {
                    String n = customLevel1[i];
                    if (i == 0) {
                        StartTile ST = new StartTile(x, y);
                        pf[x][y] = new Field(ST);
                        pf[x][y].getTile();
                        System.out.print("S");
                        i++;

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
                    if ("W".equals(n)) {
                        pf[x][y] = new Field(new Wall(x, y));
                        System.out.print("W");
                        i++;
                    }
                }
            }
        }
        Character instance = new Character(0, 0);
        for (int c = 0; c <= 20; c++){
        instance.handleMovement(39, pf);
        }
        int[] expResult = new int[]{9, 0};
        int[] result = new int[]{instance.getxCoordinate(), instance.getyCoordinate()};
        Assert.assertArrayEquals(expResult, result);
    }

    /**
     * Test of setPrevPos method, of class Character.
     */
    @Test
    public void testSetPrevPos() {
        System.out.println("setPrevPos");
        Character instance = new Character(3, 5);
        instance.setPrevPos();
        instance.setxCoordinate(6);
        instance.setyCoordinate(8);
        int[] expResult = new int[]{3, 5};
        int[] result = new int[]{instance.getPrevxCoordinate(), instance.getPrevyCoordinate()};
        Assert.assertArrayEquals(expResult, result);
    }

}
