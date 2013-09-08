package br.com.watermark;


import java.io.FileOutputStream;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfTemplate;

public class MaisUmaMarcaXml {

	/**
	 * esse codigo insere uma marca dagua a partir de uma string
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BaseFont helv;
		PdfGState gstate;
		BaseColor color1;
		
		 try {
			 
	            PdfReader read = new PdfReader("D://pdfs/normalizado.pdf");
	            int number_of_pages = read.getNumberOfPages();
	            
	            PdfStamper stamp = new PdfStamper(read, new FileOutputStream("D://pdfs/MarcasTRIG.pdf"));
	            int i = 0;
	       
	            PdfContentByte contByte;
	            
	          //inicializar variaveis
				 
				helv = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
				gstate = new PdfGState();
				gstate.setFillOpacity(0.3f);
				gstate.setStrokeOpacity(0.3f);
				
				color1 = BaseColor.BLUE; 
	            
	            while (i < number_of_pages) {
	              i++;
	              
	              contByte = stamp.getUnderContent(i);
	              
	              contByte.saveState();
	              contByte.setGState(gstate);
	              contByte.setColorFill(color1);
	              
	              contByte.beginText();
	              contByte.setFontAndSize(helv, 48);
	              
	              contByte.showTextAligned(Element.ALIGN_CENTER,"UTFPR", read.getPageSize(i).getHeight() / 2, read.getPageSize(i).getWidth()/2, 45);
	              
	              contByte.endText();
	              contByte.restoreState();
	            }
	            stamp.close();
	        }
	        catch (Exception i1) {
	            i1.printStackTrace();
	        }

	}

}
