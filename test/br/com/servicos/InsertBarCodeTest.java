package br.com.servicos;

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
public class InsertBarCodeTest {
    
    public InsertBarCodeTest() {
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
     * Test of Execute method, of class InsertBarCode.
     */
    @Test
    public void testExecute() {
        System.out.println("Execute");
        InsertBarCode instance = new InsertBarCode();
        instance.Execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AbortExecute method, of class InsertBarCode.
     */
    @Test
    public void testAbortExecute() {
        System.out.println("AbortExecute");
        InsertBarCode instance = new InsertBarCode();
        instance.AbortExecute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetBarCode method, of class InsertBarCode.
     */
    @Test
    public void testSetBarCode() {
        System.out.println("SetBarCode");
        InsertBarCode instance = new InsertBarCode();
        instance.SetBarCode();
        // TODO review the generated test code and remove the default call to fail.
    }
}
