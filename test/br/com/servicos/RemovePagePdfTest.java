
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


    @Test
    public void testExecute() {
        System.out.println("Execute");
        String[] args = null;
        RemovePagePdf instance = new RemovePagePdf();
        instance.Execute(args);
    }


    @Test
    public void testDelPagePdf() {
        System.out.println("DelPagePdf");
        String src = "";
        String dest = "";
        int page = 0;
        RemovePagePdf instance = new RemovePagePdf();
        instance.DelPagePdf(src, dest, page);
    }
}