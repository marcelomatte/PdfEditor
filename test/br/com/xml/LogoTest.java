/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.xml;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
public class LogoTest {
    
    public LogoTest() {
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


    @Test
    public void testGetMarca() {
        System.out.println("getMarca");
        Logo instance = new Logo();
        Marca expResult = null;
        Marca result = instance.getMarca();
        assertEquals(expResult, result);
    }


    @Test
    public void testSetMarca() {
        System.out.println("setMarca");
        Marca marca = null;
        Logo instance = new Logo();
        instance.setMarca(marca);
    }

    /**
     * Test of hashCode method, of class Logo.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Logo instance = new Logo();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of equals method, of class Logo.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Logo instance = new Logo();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
}