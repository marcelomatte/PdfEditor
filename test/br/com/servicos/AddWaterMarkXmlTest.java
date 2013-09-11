
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
public class AddWaterMarkXmlTest {
    
    public AddWaterMarkXmlTest() {
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
        AddWaterMarkXml instance = new AddWaterMarkXml();
        instance.Execute(args);
    }


    @Test
    public void testSetWaterMarkXml() {
        System.out.println("SetWaterMarkXml");
        String src = "";
        String dest = "";
        String xml = "";
        AddWaterMarkXml instance = new AddWaterMarkXml();
        instance.SetWaterMarkXml(src, dest, xml);
    }
}