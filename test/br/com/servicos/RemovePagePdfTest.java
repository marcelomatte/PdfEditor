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
public class RemovePagePdfTest {
    
    public RemovePagePdfTest() {
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
     * Test of Execute method, of class RemovePagePdf.
     */
    @Test
    public void testExecute() {
        System.out.println("Execute");
        RemovePagePdf instance = new RemovePagePdf();
        instance.Execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AbortExecute method, of class RemovePagePdf.
     */
    @Test
    public void testAbortExecute() {
        System.out.println("AbortExecute");
        RemovePagePdf instance = new RemovePagePdf();
        instance.AbortExecute();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of DelPagePdf method, of class RemovePagePdf.
     */
    @Test
    public void testDelPagePdf() {
        System.out.println("DelPagePdf");
        RemovePagePdf instance = new RemovePagePdf();
        instance.DelPagePdf();
        // TODO review the generated test code and remove the default call to fail.
    }
}