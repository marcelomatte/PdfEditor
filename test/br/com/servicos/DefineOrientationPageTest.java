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

    /**
     * Test of Execute method, of class DefineOrientationPage.
     */
    @Test
    public void testExecute() {
        System.out.println("Execute");
        DefineOrientationPage instance = new DefineOrientationPage();
        instance.Execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AbortExecute method, of class DefineOrientationPage.
     */
    @Test
    public void testAbortExecute() {
        System.out.println("AbortExecute");
        DefineOrientationPage instance = new DefineOrientationPage();
        instance.AbortExecute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetOrientation method, of class DefineOrientationPage.
     */
    @Test
    public void testSetOrientation() {
        System.out.println("SetOrientation");
        DefineOrientationPage instance = new DefineOrientationPage();
        instance.SetOrientation();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of manipulatePdf method, of class DefineOrientationPage.
     */
    @Test
    public void testManipulatePdf() {
        System.out.println("manipulatePdf");
        String src = "";
        String dest = "";
        DefineOrientationPage instance = new DefineOrientationPage();
        instance.manipulatePdf(src, dest);
        // TODO review the generated test code and remove the default call to fail.
    }
}