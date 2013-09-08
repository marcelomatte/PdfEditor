package br.com.watermark;



import java.io.FileOutputStream;

import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class InserirMarcaJpg {

	public void inserir(String pdf, String img){
		 try {
	            PdfReader Read_PDF_To_Watermark = new PdfReader(pdf);
	            int number_of_pages = Read_PDF_To_Watermark.getNumberOfPages();
	            //System.out.println(number_of_pages);
	            PdfStamper stamp = new PdfStamper(Read_PDF_To_Watermark, new FileOutputStream("D://pdfs/MarcaImagem.pdf"));
	            int i = 0;
	            
	            Image watermark_image = Image.getInstance(img);
	            watermark_image.setAbsolutePosition(200, 400);
	            //watermark_image.setRotation(90);
	            PdfContentByte add_watermark;            
	            while (i < number_of_pages) {
	              i++;
	              add_watermark = stamp.getUnderContent(i);
	              add_watermark.addImage(watermark_image);
	            }
	            stamp.close();
	        }
	        catch (Exception i1) {
	            i1.printStackTrace();
	        }
	}
}