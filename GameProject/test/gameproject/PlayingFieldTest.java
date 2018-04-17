/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

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
public class PlayingFieldTest {

    public PlayingFieldTest() {
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
     * Test of getPf method, of class PlayingField.
     */
    @Test
    public void testGetPf() {
        System.out.println("getPf");
        PlayingField instance = new PlayingField();
        Field[][] expResult = new Field[10][10];
        Field[][] result = instance.getPf();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getStartTile method, of class PlayingField.
     */
    @Test
    public void testGetStartTile() {
        System.out.println("getStartTile");
        PlayingField instance = new PlayingField();
        StartTile expResult = null;
        StartTile result = instance.getStartTile();
        assertEquals(expResult, result);
    }

    /**
     * Test of setLvl method, of class PlayingField.
     */
    @Test
    public void testLvl1AllTiles() {
        System.out.println("setLvl 1");
        int lvl = 1;
        PlayingField instance = new PlayingField();
        instance.setLvl(lvl);
        String[] LvlToTest = new String[]{
            "S", "B", "O", "W", "O", "K", "W", "O", "O", "O",
            "O", "O", "K", "W", "O", "O", "W", "W", "W", "W",
            "O", "O", "O", "W", "O", "O", "B", "W", "O", "O",
            "W", "W", "B", "W", "W", "B", "O", "O", "O", "O",
            "O", "O", "O", "B", "O", "O", "O", "O", "O", "O",
            "O", "O", "O", "B", "O", "O", "O", "O", "O", "O",
            "O", "O", "O", "W", "O", "O", "O", "O", "O", "O",
            "O", "O", "O", "W", "O", "O", "O", "W", "B", "W",
            "O", "O", "K", "W", "W", "W", "B", "W", "B", "W",
            "O", "O", "O", "W", "K", "O", "O", "W", "O", "E", ""};
        String[] result = new String[101];
        int counter = 0;
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 10; y++) {
                result[counter] = instance.getPf()[x][y].getTile().Symbol;
                counter++;
            }
        }
        result[counter] = "";
        String[] expResult = LvlToTest;
        Assert.assertArrayEquals(expResult, result);
    }

    /**
     * Test of setLvl method, of class PlayingField.
     */
    @Test
    public void testFirstAndLastTile() {
        System.out.println("FirstAndLastTile");
        int lvl = 0;
        PlayingField instance = new PlayingField();
        instance.setLvl(lvl);
        boolean[] result = new boolean[6];
        result[0] = "S".equals(instance.getPf()[0][0].getTile().Symbol);
        result[1] = "E".equals(instance.getPf()[9][9].getTile().Symbol);
        result[2] = "S".equals(instance.getPf()[0][0].getTile().Symbol);
        result[3] = "E".equals(instance.getPf()[9][9].getTile().Symbol);
        result[4] = "S".equals(instance.getPf()[0][0].getTile().Symbol);
        result[5] = "E".equals(instance.getPf()[9][9].getTile().Symbol);
        boolean[] expResult = new boolean[6];
        expResult[0] = true;
        expResult[1] = true;
        expResult[2] = true;
        expResult[3] = true;
        expResult[4] = true;
        expResult[5] = true;
        Assert.assertArrayEquals(expResult, result);
    }
//
//    /**
//     * Test of setLvl method, of class PlayingField.
//     */
//    @Test
//    public void testSetLvll() {
//        System.out.println("setLvl");
//        int lvl = 0;
//        PlayingField instance = new PlayingField();
//        instance.setLvl(lvl);
//        String result = instance.getPf()[9][9].getTile().Symbol;
//        String expResult = new Field(new EndTile(9, 9)).getTile().Symbol;
//        assertEquals(expResult, result);
//    }

}
