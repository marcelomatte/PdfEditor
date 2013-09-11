
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
public class ReadXmlTest {
    
    public ReadXmlTest() {
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
    public void testRead() {
        System.out.println("read");
        String s = "";
        ReadXml instance = new ReadXml();
        String expResult = "";
        String result = instance.read(s);
        assertEquals(expResult, result);
    }
}