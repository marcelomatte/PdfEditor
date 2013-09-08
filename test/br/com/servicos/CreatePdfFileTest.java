package br.com.servicos;

import static org.junit.Assert.*;

import org.junit.Test;

import com.itextpdf.text.Document;

public class CreatePdfFileTest {

	@Test
	public void testCreatePdfFile() {
		fail("Not yet implemented");
	}

	@Test
	public void testExecute() {
		fail("Not yet implemented");
	}

	@Test
	public void testAbortExecute() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreatePdf(){ 
		System.out.println("CreatePdf");
        String text = "";
        String nome = "";
        float leftMargin = 0.0F;
        float rightMargin = 0.0F;
        float topMargin = 0.0F;
        float bottomMargin = 0.0F;
        CreatePdfFile instance = new CreatePdfFile();
        Document expResult = null;
        Document result = instance.CreatePdf(text, nome, leftMargin, rightMargin, topMargin, bottomMargin);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
	}

}
