/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.xml;

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
@Suite.SuiteClasses({br.com.xml.MarcaTest.class, br.com.xml.LogoTest.class, br.com.xml.ReadXmlTest.class})
public class TesteBoss2 {

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