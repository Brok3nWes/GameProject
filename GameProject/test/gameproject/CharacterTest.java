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
     * Test of getPrevyCoordinate method, of class Character.
     */
    @Test
    public void testGetPrevyCoordinate() {
        System.out.println("getPrevyCoordinate");
        Character instance = new Character(3, 5);
        int expResult = 5;
        int result = instance.getPrevyCoordinate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrevxCoordinate method, of class Character.
     */
    @Test
    public void testGetPrevxCoordinate() {
        System.out.println("getPrevxCoordinate");
        Character instance = null;
        int expResult = 0;
        int result = instance.getPrevxCoordinate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pickupKey method, of class Character.
     */
    @Test
    public void testPickupKey() {
        System.out.println("pickupKey");
        Key k = null;
        Character instance = null;
        boolean expResult = false;
        boolean result = instance.pickupKey(k);
        assertEquals(expResult, result);
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
     * Test of useKey method, of class Character.
     */
    @Test
    public void testUseKey() {
        System.out.println("useKey");
        Barricade b = null;
        Character instance = null;
        boolean expResult = false;
        boolean result = instance.useKey(b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of up method, of class Character.
     */
    @Test
    public void testUp() {
        System.out.println("up");
        Character instance = null;
        instance.up();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of down method, of class Character.
     */
    @Test
    public void testDown() {
        System.out.println("down");
        Character instance = null;
        instance.down();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of left method, of class Character.
     */
    @Test
    public void testLeft() {
        System.out.println("left");
        Character instance = null;
        instance.left();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of right method, of class Character.
     */
    @Test
    public void testRight() {
        System.out.println("right");
        Character instance = null;
        instance.right();
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
