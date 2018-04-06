/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

import org.junit.After;
import org.junit.AfterClass;
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

    /**
     * Test of useKey method, of class Character.
     */
    @Test
    public void testUseKey() {
        System.out.println("useKey");
        Barricade b = null;
        Character instance = null;
        instance.useKey(b);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of handleMovement method, of class Character.
     */
    @Test
    public void testHandleMovement() {
        System.out.println("handleMovement");
        int command = 0;
        Field[][] pf = null;
        Character instance = null;
        instance.handleMovement(command, pf);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getKeyInPocket method, of class Character.
     */
    @Test
    public void testGetKeyInPocket() {
        System.out.println("getKeyInPocket");
        Character instance = null;
        Key expResult = null;
        Key result = instance.getKeyInPocket();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPrevPos method, of class Character.
     */
    @Test
    public void testSetPrevPos() {
        System.out.println("setPrevPos");
        Character instance = null;
        instance.setPrevPos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
