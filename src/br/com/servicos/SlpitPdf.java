package br.com.servicos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.interfaces.IServiceStrategy;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class SlpitPdf implements IServiceStrategy {

	@Override
	public void Execute() {

	}

	@Override
	public void AbortExecute() {

	}

	public SlpitPdf() {

	}

	public void DividePdf(String origem, String destino, int fromPage,
			int toPage) throws FileNotFoundException {

		InputStream is = new FileInputStream(origem);
		OutputStream os = new FileOutputStream(destino);

		Document document = new Document();

		try {

			PdfReader inputPDF = new PdfReader(is);
			int totalPages = inputPDF.getNumberOfPages();

			if (fromPage > toPage) {
				fromPage = toPage;
			}
			if (toPage > totalPages) {
				toPage = totalPages;
			}

			// Create a writer for the outputstream
			PdfWriter writer = PdfWriter.getInstance(document, os);
			document.open();
			PdfContentByte cb = writer.getDirectContent(); // Holds the PDF data
			PdfImportedPage page;

			while (fromPage <= toPage) {
				document.newPage();
				page = writer.getImportedPage(inputPDF, fromPage);
				cb.addTemplate(page, 0, 0);
				fromPage++;
			}
			os.flush();
			document.close();
			os.close();
		} catch (Exception e) {
			Logger.getLogger(SlpitPdf.class.getName()).log(Level.SEVERE, null,
					e);
			e.printStackTrace();
		} finally {
			if (document.isOpen())
				document.close();
			try {
				if (os != null)
					os.close();
			} catch (IOException ioe) {
				Logger.getLogger(SlpitPdf.class.getName()).log(Level.SEVERE,
						null, ioe);
				ioe.printStackTrace();
			}
		}

	}
}
