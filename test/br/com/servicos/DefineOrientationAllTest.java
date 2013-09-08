package br.com.servicos;


import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.itextpdf.text.DocumentException;

import static org.junit.Assert.*;

/**
 *
 * @author Tiago
 */
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

    /**
     * Test of Execute method, of class DefineOrientationAll.
     * @throws DocumentException 
     * @throws IOException 
     */
    @Test
    public void testExecute() throws IOException, DocumentException {
        System.out.println("Execute");
        DefineOrientationAll instance = new DefineOrientationAll();
        instance.Execute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AbortExecute method, of class DefineOrientationAll.
     * @throws DocumentException 
     * @throws IOException 
     */
    @Test
    public void testAbortExecute() throws IOException, DocumentException {
        System.out.println("AbortExecute");
        DefineOrientationAll instance = new DefineOrientationAll();
        instance.AbortExecute();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SetOrientationAll method, of class DefineOrientationAll.
     * @throws DocumentException 
     * @throws IOException 
     */
    @Test
    public void testSetOrientationAll() throws IOException, DocumentException {
        System.out.println("SetOrientationAll");
        String path = "";
        String path1 = "";
        DefineOrientationAll instance = new DefineOrientationAll();
        instance.SetOrientationAll(path, path1);
        // TODO review the generated test code and remove the default call to fail.
    }
}
