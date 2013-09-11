
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
public class CreatePdfFileTest {
    
    public CreatePdfFileTest() {
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
        CreatePdfFile instance = new CreatePdfFile();
        instance.Execute(args);
    }

    @Test
    public void testCreatePdf() {
        System.out.println("CreatePdf");
        String text = "";
        String nome = "";
        String path = "";
        float leftMargin = 0.0F;
        float rightMargin = 0.0F;
        float topMargin = 0.0F;
        float bottomMargin = 0.0F;
        CreatePdfFile instance = new CreatePdfFile();
        instance.CreatePdf(text, nome, path, leftMargin, rightMargin, topMargin, bottomMargin);
    }
}