package br.com.servicos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.interfaces.IServiceStrategy;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class AddWaterMarkImg implements IServiceStrategy {

	@Override
	public void Execute() {

	}

	@Override
	public void AbortExecute() {

	}

	public AddWaterMarkImg() {

	}

	public void SetWaterMarkImg(String origem, String destino, String imagem) {

		PdfReader reader;

		try {
			reader = new PdfReader(origem);
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(
					destino));
			Image img = Image.getInstance(imagem);

			img.setAbsolutePosition(100, 200);
			PdfContentByte under;
			int total = reader.getNumberOfPages() + 1;
			
			for (int i = 1; i < total; i++) {
				under = stamper.getUnderContent(i);
				under.addImage(img);
			}
			
		} catch (IOException ex) {
			ex.printStackTrace();
			Logger.getLogger(AddWaterMarkImg.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (DocumentException ex) {
			ex.printStackTrace();
			Logger.getLogger(AddWaterMarkImg.class.getName()).log(Level.SEVERE,
					null, ex);
		}

	}

}
