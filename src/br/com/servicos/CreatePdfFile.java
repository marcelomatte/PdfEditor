package br.com.servicos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import br.com.interfaces.IServiceStrategy;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePdfFile implements IServiceStrategy {

	private static Document doc;
	private static OutputStream os;
	private static Paragraph p;

	@Override
	public void Execute(String[] args) {
		
		String text = args[1]; 
		String nome = args[2]; 
		String path = args[3];
		float leftMargin = Float.parseFloat(args[4]); 
		float rightMargin = Float.parseFloat(args[5]); 
		float topMargin = Float.parseFloat(args[6]);
		float bottomMargin = Float.parseFloat(args[7]);	
		CreatePdf(text, nome, path, leftMargin, rightMargin, topMargin, bottomMargin);
		
	}
	
	public CreatePdfFile() {
	}

	public void CreatePdf(String text, String nome, String path,
			float leftMargin, float rightMargin, float topMargin,
			float bottomMargin) {

		Logger logCreatePdfFile = Logger.getLogger(CreatePdfFile.class.getName());
		FileHandler fh = null;
		
		try {
			fh = new FileHandler("c:\\pdf\\logs\\CreatePdfFileClass.txt",true);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logCreatePdfFile.addHandler(fh);
			logCreatePdfFile.setLevel(Level.CONFIG);

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
			logCreatePdfFile.log(Level.SEVERE, "Erro de I/O. O arquivo pdf de entrada ou de saída não foi encontrado. \n Ou você não tem permissão para gravá-lo.\n "+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		} catch (DocumentException e) {
			logCreatePdfFile.log(Level.SEVERE, "Problemas na criação do arquivo .pdf verifique."+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		} catch (SecurityException e) {
			logCreatePdfFile.log(Level.SEVERE, "Houve uma violação de segurança! \n "+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		} catch (IOException e) {
			logCreatePdfFile.log(Level.SEVERE, "Arquivo não encontrado. Verifique! \n "+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
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

					logCreatePdfFile.log(Level.SEVERE, "Erro de I/O. O arquivo pdf de entrada ou de saída não foi encontrado. \n Ou você não tem permissão para gravá-lo.\n "+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");

				}
			}
		}

	}

}
