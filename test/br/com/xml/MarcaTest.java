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
public class MarcaTest {
    
    public MarcaTest() {
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
    public void testGetInfo() {
        System.out.println("getInfo");
        Marca instance = new Marca();
        String expResult = "";
        String result = instance.getInfo();
        assertEquals(expResult, result);
    }


    @Test
    public void testSetInfo() {
        System.out.println("setInfo");
        String info = "";
        Marca instance = new Marca();
        instance.setInfo(info);
    }


    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Marca instance = new Marca();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
    }

 
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Marca instance = new Marca();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
}