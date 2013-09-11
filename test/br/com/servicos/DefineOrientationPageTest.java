
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
public class DefineOrientationPageTest {
    
    public DefineOrientationPageTest() {
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
        DefineOrientationPage instance = new DefineOrientationPage();
        instance.Execute(args);
    }

    /**
     * Test of SetOrientation method, of class DefineOrientationPage.
     */
    @Test
    public void testSetOrientation() {
        System.out.println("SetOrientation");
        String src = "";
        String dest = "";
        int page = 0;
        DefineOrientationPage instance = new DefineOrientationPage();
        instance.SetOrientation(src, dest, page);
    }
}