package br.com.servicos;

import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BarcodeEAN;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import br.com.interfaces.IServiceStrategy;

public class InsertBarCode implements IServiceStrategy {

	@Override
	public void Execute() {

	}

	@Override
	public void AbortExecute() {

	}

	public InsertBarCode() {

	}

	public void SetBarCode() {
		// criando um objeto da classe Document

		Document document = new Document(PageSize.A4, 50, 50, 50, 50);

		try {

			// Aqui começamos a utilizar as classes do iText: o documento

			// criado acima será

			// direcionado para um arquivo PDF.

			PdfWriter writer = PdfWriter
					.getInstance(
							document,
							new FileOutputStream(
									"C:\\frameworks\\PdfEditor\\docbarcoded\\codigodebarrasinserido.pdf"));

			// abrindo o documento.

			document.open();

			// adicionando um novo paragrafo.

			document.add(new Paragraph("CÓDIGOS DE BARRA"));

			document.add(new Paragraph(" "));

			document.add(new Paragraph(" "));

			// Comecando a configurar o cod de barras

			PdfContentByte cb = writer.getDirectContent();

			BarcodeEAN codeEAN = new BarcodeEAN();

			// O iText suporta os principais tipos de código de barra, como
			// Barcode39,

			// Barcode128 (128, 128_UCC, 128_RAW), BarcodeEAN (EAN13, EAN8,
			// UPCA, UPCE), EANSUP, etc

			codeEAN.setCodeType(codeEAN.EAN13);

			codeEAN.setCode("9780201615883");

			Image imageEAN = codeEAN.createImageWithBarcode(cb, null, null);

			document.add(new Phrase(new Chunk(imageEAN, 0, 0)));

		}

		catch (Exception de) {
			Logger.getLogger(InsertBarCode.class.getName()).log(Level.SEVERE, null, de);
			de.printStackTrace();
		}
		document.close();
	}
}
