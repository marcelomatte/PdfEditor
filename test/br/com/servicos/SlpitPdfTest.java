package br.com.servicos;

import java.io.InputStream;
import java.io.OutputStream;
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
public class SlpitPdfTest {
    
    public SlpitPdfTest() {
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
     * Test of Execute method, of class SlpitPdf.
     */
    @Test
    public void testExecute() {
        System.out.println("Execute");
        SlpitPdf instance = new SlpitPdf();
        instance.Execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AbortExecute method, of class SlpitPdf.
     */
    @Test
    public void testAbortExecute() {
        System.out.println("AbortExecute");
        SlpitPdf instance = new SlpitPdf();
        instance.AbortExecute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DividePdf method, of class SlpitPdf.
     */
    @Test
    public void testDividePdf() {
        System.out.println("DividePdf");
        InputStream inputStream = null;
        OutputStream outputStream = null;
        int fromPage = 0;
        int toPage = 0;
        SlpitPdf instance = new SlpitPdf();
        instance.DividePdf(inputStream, outputStream, fromPage, toPage);
        // TODO review the generated test code and remove the default call to fail.
    }
}