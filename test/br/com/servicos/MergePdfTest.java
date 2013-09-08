package br.com.servicos;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
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
public class MergePdfTest {
    
    public MergePdfTest() {
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
     * Test of Execute method, of class MergePdf.
     */
    @Test
    public void testExecute() {
        System.out.println("Execute");
        MergePdf instance = new MergePdf();
        instance.Execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AbortExecute method, of class MergePdf.
     */
    @Test
    public void testAbortExecute() {
        System.out.println("AbortExecute");
        MergePdf instance = new MergePdf();
        instance.AbortExecute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Merge method, of class MergePdf.
     */
    @Test
    public void testMerge() {
        System.out.println("Merge");
        List<String> pdfs = null;
        String path = "";
        MergePdf instance = new MergePdf();
        instance.Merge(pdfs, path);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of concatPDFs method, of class MergePdf.
     */
    @Test
    public void testConcatPDFs() {
        System.out.println("concatPDFs");
        List<InputStream> streamOfPDFFiles = null;
        OutputStream outputStream = null;
        boolean paginate = false;
        MergePdf.concatPDFs(streamOfPDFFiles, outputStream, paginate);
        // TODO review the generated test code and remove the default call to fail.
    }
}