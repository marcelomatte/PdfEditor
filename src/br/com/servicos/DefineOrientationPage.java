package br.com.servicos;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

import br.com.interfaces.IServiceStrategy;

public class DefineOrientationPage implements IServiceStrategy {

	public static final String RESULT = "C:\\frameworks\\PdfEditor\\pdfrotationed\\itextbookPage4rotate.pdf";
	
	@Override
	public void Execute() {

	}

	@Override
	public void AbortExecute() {

	}

	public DefineOrientationPage(){

		
	}

	public void SetOrientation(String src, String dest, int page) throws IOException, DocumentException {

		PdfReader reader = new PdfReader("C:\\frameworks\\PdfEditor\\documents\\itextbook.pdf");
		int n = reader.getNumberOfPages();
		int rot;
		PdfDictionary pageDict;
		for (int i = 1; i <= n; i++) {
			if(i == page){
			rot = reader.getPageRotation(i);
			pageDict = reader.getPageN(i);
			pageDict.put(PdfName.ROTATE, new PdfNumber(rot + 90));
			}
		}
		PdfStamper stamper = new PdfStamper(reader,
				new FileOutputStream(RESULT));
		stamper.close();
		reader.close();
		
		
	}

	

}
