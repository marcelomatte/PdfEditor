/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.servicos;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Tiago
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({br.com.servicos.DefineOrientationPageTest.class, br.com.servicos.AddWaterMarkImgTest.class, br.com.servicos.RemovePagePdfTest.class, br.com.servicos.MergePdfTest.class, br.com.servicos.CreatePdfFileTest.class, br.com.servicos.DefineOrientationAllTest.class, br.com.servicos.AddPrevilegePdfTest.class, br.com.servicos.InsertBarCodeTest.class, br.com.servicos.SlpitPdfTest.class, br.com.servicos.AddWaterMarkXmlTest.class})
public class TesteBoss {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}