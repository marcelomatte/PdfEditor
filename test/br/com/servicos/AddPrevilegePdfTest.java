
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
public class AddPrevilegePdfTest {
    
    public AddPrevilegePdfTest() {
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
        AddPrevilegePdf instance = new AddPrevilegePdf();
        instance.Execute(args);

    }



    @Test
    public void testEncryptPdf() {
        System.out.println("encryptPdf");
        String user = "";
        String senha = "";
        String src = "";
        String dest = "";
        AddPrevilegePdf instance = new AddPrevilegePdf();
        instance.encryptPdf(user, senha, src, dest);

    }
}