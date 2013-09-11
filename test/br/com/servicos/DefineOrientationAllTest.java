
package br.com.servicos;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.itextpdf.text.DocumentException;


public class DefineOrientationAllTest {
    
    public DefineOrientationAllTest() {
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
    public void testExecute() throws IOException, DocumentException {
        System.out.println("Execute");
        String[] args = null;
        DefineOrientationAll instance = new DefineOrientationAll();
        instance.Execute(args);

    }


    @Test
    public void testSetOrientationAll() throws IOException, DocumentException{
        System.out.println("SetOrientationAll");
        String src = "";
        String dest = "";
        DefineOrientationAll instance = new DefineOrientationAll();
        instance.SetOrientationAll(src, dest);
    }
}