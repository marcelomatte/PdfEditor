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
public class InsertBarCodeTest {
    
    public InsertBarCodeTest() {
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
        InsertBarCode instance = new InsertBarCode();
        instance.Execute(args);
    }


    @Test
    public void testSetBarCode() {
        System.out.println("SetBarCode");
        String dest = "";
        String barcode = "";
        InsertBarCode instance = new InsertBarCode();
        instance.SetBarCode(dest, barcode);
    }
}