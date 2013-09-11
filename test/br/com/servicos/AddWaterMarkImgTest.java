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
public class AddWaterMarkImgTest {
    
    public AddWaterMarkImgTest() {
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
        AddWaterMarkImg instance = new AddWaterMarkImg();
        instance.Execute(args);

    }

    /**
     * Test of SetWaterMarkImg method, of class AddWaterMarkImg.
     */
    @Test
    public void testSetWaterMarkImg() {
        System.out.println("SetWaterMarkImg");
        String origem = "";
        String destino = "";
        String imagem = "";
        AddWaterMarkImg instance = new AddWaterMarkImg();
        instance.SetWaterMarkImg(origem, destino, imagem);

    }
}