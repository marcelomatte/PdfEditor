package br.com.servicos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.interfaces.IServiceStrategy;

public class MergePdf implements IServiceStrategy {

	@Override
	public void Execute(String[] args) {
		
		ArrayList<String> pdfs = new ArrayList<String>();
		for(int i =1; i<args.length-1;i++){
			pdfs.add(args[i]);
		}				
		int counter = args.length;
		String path = args[counter-1];
		Merge(pdfs, path);
		
	}
	
	public MergePdf() {

	}

	public void Merge(List<String> pdfs, String path) {
		
		Logger logMerge = Logger.getLogger(MergePdf.class.getName());
		FileHandler fh = null;
		
		try {
			fh = new FileHandler("c:\\pdf\\logs\\MergeMethodMergePdfClass.txt",true);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logMerge.addHandler(fh);
			logMerge.setLevel(Level.CONFIG);
			List<InputStream> pdf1 = new ArrayList<InputStream>();
			for (String inputStream : pdfs) {
				pdf1.add(new FileInputStream(inputStream));
			}
			OutputStream output = new FileOutputStream(path);
			MergePdf.concatPDFs(pdf1, output, true);
		} catch (Exception e) {
			logMerge.log(Level.SEVERE,"Uma exceção foi verificada foi lançada no método setBarCode() \n."+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		}

	}

	public static void concatPDFs(List<InputStream> streamOfPDFFiles,
			OutputStream outputStream, boolean paginate) {
		
		Logger logConcat = Logger.getLogger(MergePdf.class.getName());
		FileHandler fh = null;
		Document document = new Document();
		try {
			fh = new FileHandler("c:\\pdf\\logs\\ConcatMethodMergePdfClass.txt",true);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logConcat.addHandler(fh);
			logConcat.setLevel(Level.CONFIG);
			List<InputStream> pdfs = streamOfPDFFiles;
			List<PdfReader> readers = new ArrayList<PdfReader>();
			int totalPages = 0;
			Iterator<InputStream> iteratorPDFs = pdfs.iterator();

			// Criando um reader para cada pdf.
			while (iteratorPDFs.hasNext()) {
				InputStream pdf = iteratorPDFs.next();
				PdfReader pdfReader = new PdfReader(pdf);
				readers.add(pdfReader);
				totalPages += pdfReader.getNumberOfPages();
			}
			// Criando um arquivo de saída para o documento
			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			document.open();
			BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,
					BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
			PdfContentByte cb = writer.getDirectContent(); //Mantém os dados do pdf

			PdfImportedPage page;
			int currentPageNumber = 0;
			int pageOfCurrentReaderPDF = 0;
			Iterator<PdfReader> iteratorPDFReader = readers.iterator();

			// Percorrer os arquivos PDF e adicionar para a saída.
			while (iteratorPDFReader.hasNext()) {
				PdfReader pdfReader = iteratorPDFReader.next();

				// Criar uma nova página no destino para cada página de origem.
				while (pageOfCurrentReaderPDF < pdfReader.getNumberOfPages()) {
					document.newPage();
					pageOfCurrentReaderPDF++;
					currentPageNumber++;
					page = writer.getImportedPage(pdfReader,
							pageOfCurrentReaderPDF);
					cb.addTemplate(page, 0, 0);

					//Paginação.
					if (paginate) {
						cb.beginText();
						cb.setFontAndSize(bf, 9);
						cb.showTextAligned(PdfContentByte.ALIGN_CENTER, ""
								+ currentPageNumber + " of " + totalPages, 520,
								5, 0);
						cb.endText();
					}
				}
				pageOfCurrentReaderPDF = 0;
			}
			outputStream.flush();
			document.close();
			outputStream.close();
		} catch (Exception e) {
			logConcat.log(Level.SEVERE,"Uma exceção foi verificada foi lançada no método ConcatPDFs() \n."+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		} finally {
			if (document.isOpen())
				document.close();
			try {
				if (outputStream != null)
					outputStream.close();
			} catch (IOException e) {
				logConcat.log(Level.SEVERE, "Erro de I/O. O arquivo pdf de entrada ou de saída não foi encontrado. \n Ou você não tem permissão para gravá-lo.\n "+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
			}
		}
	}

}
