/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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


    @Test
    public void testExecute() {
        System.out.println("Execute");
        String[] args = null;
        SlpitPdf instance = new SlpitPdf();
        instance.Execute(args);
    }

    /**
     * Test of DividePdf method, of class SlpitPdf.
     */
    @Test
    public void testDividePdf() {
        System.out.println("DividePdf");
        String src = "";
        String dest = "";
        int pi = 0;
        int pf = 0;
        SlpitPdf instance = new SlpitPdf();
        instance.DividePdf(src, dest, pi, pf);
    }
}