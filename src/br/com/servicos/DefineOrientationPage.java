package br.com.servicos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import br.com.interfaces.IServiceStrategy;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfNumber;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class DefineOrientationPage implements IServiceStrategy {

	@Override
	public void Execute(String[] args) {
		
		String origem = args[1];
		String destino = args[2];
		int pagina= Integer.parseInt(args[3]);
		SetOrientation(origem, destino, pagina);
		
	}
	
	public DefineOrientationPage() {

	}

	public void SetOrientation(String src, String dest, int page) {

		Logger logDefineOrientationPage = Logger.getLogger(DefineOrientationPage.class.getName());
		FileHandler fh = null;
		
		PdfReader reader;
		try {
			fh = new FileHandler("c:\\pdf\\logs\\DefineOrientationPageClass.txt",true);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logDefineOrientationPage.addHandler(fh);
			logDefineOrientationPage.setLevel(Level.CONFIG);
			reader = new PdfReader(src);
			int n = reader.getNumberOfPages();
			int rot;
			PdfDictionary pageDict;
			for (int i = 1; i <= n; i++) {
				if (i == page) {
					rot = reader.getPageRotation(i);
					pageDict = reader.getPageN(i);
					pageDict.put(PdfName.ROTATE, new PdfNumber(rot + 90));
				}
			}
			PdfStamper stamper;

			stamper = new PdfStamper(reader, new FileOutputStream(dest));
			stamper.close();
			reader.close();
		} catch (IOException e) {
			logDefineOrientationPage.log(Level.SEVERE, "Erro de I/O. O arquivo pdf de entrada ou de saída não foi encontrado. \n Ou você não tem permissão para gravá-lo.\n "+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n"); 
		} catch (DocumentException e) {
			logDefineOrientationPage.log(Level.SEVERE, "Problemas na criação do arquivo .pdf verifique."+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		}
	}

}
