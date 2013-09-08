package br.com.watermark;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.jws.Oneway;

import com.itextpdf.awt.geom.Rectangle;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class NovaMarca {
	/*
	 * esse codigo cria um pdf e insere nele uma marca dagua a partir de uma string
	 * 
	 */

	protected static PdfTemplate total;
	protected static BaseFont helv;
	protected static PdfGState gstate;
	protected static Color color;
	protected static BaseColor color1;
	protected static Image image;

	public static void onOpenDocument(PdfWriter writer, Document document) {
		total = writer.getDirectContent().createTemplate(100, 100);
		//total.setBoundingBox(new Rectangle(-20, -20, 100, 100));
		total.setBoundingBox(new com.itextpdf.text.Rectangle(-20, -20, 100, 100));

		try {
			helv = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI,
					BaseFont.NOT_EMBEDDED);
			image = Image
					.getInstance("D://pdfs/water.jpg");
		} catch (Exception e) {
			throw new ExceptionConverter(e);
		}
		gstate = new PdfGState();
		gstate.setFillOpacity(0.3f);
		gstate.setStrokeOpacity(0.3f);
	}

	public static void onStartPage(PdfWriter writer, Document document) {
		if (writer.getPageNumber() % 2 == 1) {
			color = Color.blue;
			color1 = BaseColor.BLUE;
		} else {
			color = Color.red;
			color1 = BaseColor.RED;
		}
	}

	public static void onEndPage(PdfWriter writer, Document document) {
		
		try {
		PdfContentByte contentunder = writer.getDirectContentUnder();
		contentunder.saveState();
		contentunder.setGState(gstate);
		contentunder.addImage(image,
		image.getWidth() * 4, 0, 0, image.getHeight() * 4, 120, 650);
		//contentunder.setColorFill(color);
		contentunder.setColorFill(color1);
		contentunder.beginText();
		contentunder.setFontAndSize(helv, 48);
		contentunder.showTextAligned(Element.ALIGN_CENTER,
		"UTFPR " /*+ writer.getPageNumber()*/,
		document.getPageSize().getWidth() / 2,
		document.getPageSize().getHeight() / 2, 45);
		contentunder.endText();
		contentunder.restoreState();
		} catch (DocumentException e) {
		e.printStackTrace();
		}
		}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Document document = new Document();
		
		try {
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("D://pdfs/ITextTest3.pdf"));
			
			
			document.open();
			
			onOpenDocument(writer, document);
			
			onStartPage(writer, document);
			
			onEndPage(writer, document);
			
			
			
			
		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
				document.close();
	}
}
