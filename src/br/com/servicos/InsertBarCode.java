package br.com.servicos;

import java.io.FileOutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import br.com.interfaces.IServiceStrategy;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

public class InsertBarCode implements IServiceStrategy {

	@Override
	public void Execute(String[] args) {
		
		String dest = args[1];
		String barcode = args[2];			
		SetBarCode(dest, barcode);
		
	}
	
	public InsertBarCode() {
	}

	public void SetBarCode(String dest, String barcode) {
		
		Logger logInsertBarcode = Logger.getLogger(InsertBarCode.class.getName());
		FileHandler fh = null;
		Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		try {
			fh = new FileHandler("c:\\pdf\\logs\\InserBarCodeClass.txt",true);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logInsertBarcode.addHandler(fh);
			logInsertBarcode.setLevel(Level.CONFIG);
			PdfWriter writer = PdfWriter.getInstance(document,
					new FileOutputStream(dest));
			document.open();
			document.add(new Paragraph("CÓDIGO DE BARRA"));
			document.add(new Paragraph(" "));
			document.add(new Paragraph(" "));
			PdfContentByte cb = writer.getDirectContent();
			BarcodeEAN codeEAN = new BarcodeEAN();
			codeEAN.setCodeType(codeEAN.EAN13);
			codeEAN.setCode(barcode);
			Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);
			document.add(new Phrase(new Chunk(imageEAN, 0, 0)));
		} catch (Exception e) {
			logInsertBarcode.log(Level.SEVERE,"Uma exceção foi verificada foi lançada no método setBarCode() \n."+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		}
		document.close();
	}

}
