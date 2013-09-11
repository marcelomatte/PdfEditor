package br.com.servicos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import br.com.interfaces.IServiceStrategy;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class RemovePagePdf implements IServiceStrategy {

	@Override
	public void Execute(String[] args) {
		
		String origem = args[1];
		String destino = args[2];
		int pageRemove = Integer.parseInt(args[3]);	
		DelPagePdf(origem, destino, pageRemove);
		
	}
	

	public RemovePagePdf() {

	}

	public void DelPagePdf(String src, String dest, int page) {
		
		Logger logDelPagePdf = Logger.getLogger(RemovePagePdf.class.getName());
		FileHandler fh = null;
		int pageAsRemove = page;

		try {
			fh = new FileHandler("c:\\pdf\\logs\\RemovePagePdfClass.txt",true);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logDelPagePdf.addHandler(fh);
			logDelPagePdf.setLevel(Level.CONFIG);
			PdfReader reader = new PdfReader(src);
			int pagesTotal = reader.getNumberOfPages();
			String pageInterval = "";
			if (pageAsRemove == 1) {
				pageInterval = "2-" + pagesTotal;
			} else if (pageAsRemove == pagesTotal) {
				pageInterval = "1-" + (pagesTotal - 1);
			} else {
				pageInterval = "1-" + pagesTotal + ", !" + pageAsRemove;
			}
			PdfStamper stamper;
			stamper = new PdfStamper(reader, new FileOutputStream(dest));
			reader.selectPages(pageInterval);
			stamper.close();
			reader.close();
		} catch (FileNotFoundException e) {
			logDelPagePdf.log(Level.SEVERE, "Erro de I/O. O arquivo pdf de entrada ou de saída não foi encontrado. \n Ou você não tem permissão para gravá-lo.\n "+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		} catch (DocumentException e) {
			logDelPagePdf.log(Level.SEVERE, "Problemas na criação do arquivo .pdf verifique."+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		} catch (IOException e) {
			logDelPagePdf.log(Level.SEVERE, "Erro de I/O. O arquivo pdf de entrada ou de saída não foi encontrado. \n Ou você não tem permissão para gravá-lo.\n "+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		}

	}

}
