/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servicos;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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


    @Test
    public void testExecute() {
        System.out.println("Execute");
        String[] args = null;
        MergePdf instance = new MergePdf();
        instance.Execute(args);
    }


    @Test
    public void testMerge() {
        System.out.println("Merge");
        List<String> pdfs = null;
        String path = "";
        MergePdf instance = new MergePdf();
        instance.Merge(pdfs, path);
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
    }
}