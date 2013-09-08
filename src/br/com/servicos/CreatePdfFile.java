package br.com.servicos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.interfaces.IServiceStrategy;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePdfFile implements IServiceStrategy {

	static final String path = "C:\\frameworks\\PdfEditor\\documents";

	Document doc = null;
	Paragraph p = null;
	OutputStream os = null;

	public CreatePdfFile() {

	}
	
	@Override
	public void Execute() {

	}

	@Override
	public void AbortExecute() {

	}

	public Document CreatePdf(String text, String nome, float leftMargin,
			float rightMargin, float topMargin, float bottomMargin){
		try {
			// cria o documento tamanho A4, margens de 2,54cm
			doc = new Document(PageSize.A4, leftMargin, rightMargin, topMargin,
					bottomMargin);

			// cria a stream de saída
			os = new FileOutputStream(path + "\\" + nome + ".pdf");

			// associa a stream de saída ao
			PdfWriter.getInstance(doc, os);

			// abre o documento
			doc.open();

			// adiciona o texto ao PDF
			p = new Paragraph(text);
			doc.add(p);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(CreatePdfFile.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(CreatePdfFile.class.getName()).log(Level.SEVERE, null, e);
			e.printStackTrace();
		} finally {
			if (doc != null) {
				// fechamento do documento
				doc.close();
			}
			if (os != null) {
				// fechamento da stream de saída
				try {
					os.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					Logger.getLogger(CreatePdfFile.class.getName()).log(Level.SEVERE, null, e);
					e.printStackTrace();
				}
			}
		}
		return doc;
	}

}
