package br.com.watermark;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

public class MarcaXml {

	protected static PdfTemplate total;
	protected static BaseFont helv;
	protected static PdfGState gstate;
	protected static Color color;
	protected static BaseColor color1;
	protected static Image image;
	
	

	public static void onOpenDocument(PdfWriter writer, PdfReader reader) {
		total = writer.getDirectContent().createTemplate(100, 100);
		// total.setBoundingBox(new Rectangle(-20, -20, 100, 100));
		total.setBoundingBox(new com.itextpdf.text.Rectangle(-20, -20, 100, 100));

		try {
			helv = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI,
					BaseFont.NOT_EMBEDDED);
			image = Image.getInstance("D://pdfs/water.jpg");
		} catch (Exception e) {
			throw new ExceptionConverter(e);
		}
		gstate = new PdfGState();
		gstate.setFillOpacity(0.3f);
		gstate.setStrokeOpacity(0.3f);
	}

	public static void onStartPage(PdfWriter writer, PdfReader reader) {
		if (writer.getPageNumber() % 2 == 1) {
			color = Color.blue;
			color1 = BaseColor.BLUE;
		} else {
			color = Color.red;
			color1 = BaseColor.RED;
		}
	}

	public static void onEndPage(PdfWriter writer, PdfReader reader) {

		try {
			
			int numeroDePags = reader.getNumberOfPages();
			int i = 0;
			System.out.println(numeroDePags);
			while(i< numeroDePags)
			{
				i++;
				
				PdfContentByte contentunder = writer.getDirectContent();
				
				
				
				contentunder.saveState();
				contentunder.setGState(gstate);
				contentunder.addImage(image, image.getWidth() * 4, 0, 0,
						image.getHeight() * 4, 120, 650);
				// contentunder.setColorFill(color);
				contentunder.setColorFill(color1);
				contentunder.beginText();
				contentunder.setFontAndSize(helv, 48);
				contentunder.showTextAligned(Element.ALIGN_CENTER, "UTFPR " /*
																			 * +
																			 * writer
																			 * .
																			 * getPageNumber
																			 * ()
																			 */,
						reader.getPageSize(i).getWidth() / 2, reader.getPageSize(i)
								.getHeight() / 2, 45);
				contentunder.endText();
				contentunder.restoreState();
			}
			
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		Document document = new Document();
		
		color = Color.blue;
		color1 = BaseColor.BLUE;

		try {
			
			PdfReader read = new PdfReader("D://pdfs/normalizado.pdf");
			
			
			
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream("D://pdfs/novoXML.pdf"));
			
			

			document.open();

			onOpenDocument(writer, read);

			//onStartPage(writer, read);

			onEndPage(writer, read);

		} catch (FileNotFoundException | DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// exception do read---------------
			e.printStackTrace();
		}

		document.close();
	}

}