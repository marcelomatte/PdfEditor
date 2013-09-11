package br.com.servicos;

import java.io.FileOutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import br.com.interfaces.IServiceStrategy;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfCopy;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;

public class SlpitPdf implements IServiceStrategy {

	@Override
	public void Execute(String[] args) {
		
		String org = args[1];
		String des = args[2];
		int pi = Integer.parseInt(args[3]);
		int pf = Integer.parseInt(args[4]);
		DividePdf(org, des, pi, pf);
		
	}
	
	public SlpitPdf() {

	}

	public void DividePdf(String src, String dest, int pi, int pf) {
		
		Logger logSplitPdf = Logger.getLogger(SlpitPdf.class.getName());
		FileHandler fh = null;
		
		try {
			fh = new FileHandler("c:\\pdf\\logs\\SplitPdfClass.txt",true);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logSplitPdf.addHandler(fh);
			logSplitPdf.setLevel(Level.CONFIG);
			String arquivo = src;
			System.out.println("Reading " + arquivo);
			PdfReader reader = new PdfReader(arquivo);
			int n = reader.getNumberOfPages();
			System.out.println("Number of pages : " + n);
			int i = pi;

			if (i == pi) {
				Document document = new Document(
						reader.getPageSizeWithRotation(1));
				PdfCopy writer = new PdfCopy(document, new FileOutputStream(
						dest + "pdf1.pdf"));
				document.open();
				while (i < pf) {
					PdfImportedPage page = writer.getImportedPage(reader, ++i);
					writer.addPage(page);
				}
				document.close();
				writer.close();
			}
			if (i == pf) {

				Document document = new Document(
						reader.getPageSizeWithRotation(1));
				PdfCopy writer = new PdfCopy(document, new FileOutputStream(
						dest + "pdf2.pdf"));
				document.open();
				while (i < n) {
					PdfImportedPage page = writer.getImportedPage(reader, ++i);
					writer.addPage(page);
				}
				document.close();
				writer.close();
			}

		} catch (Exception e) {
			logSplitPdf.log(Level.SEVERE,"Uma exceção foi verificada foi lançada no método dividePdf() \n."+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		}

	}
}
