package br.com.servicos;

import java.io.FileOutputStream;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import br.com.interfaces.IServiceStrategy;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class AddWaterMarkXml implements IServiceStrategy {

	@Override
	public void Execute(String[] args) {
		
		String origem = args[1];
		String destino = args[2];
		String marca = args[3];
		SetWaterMarkXml(origem, destino, marca);
		
	}
	

	public AddWaterMarkXml() {

	}

	public void SetWaterMarkXml(String src, String dest, String xml) {
		
		Logger logAddWaterMarkXml = Logger.getLogger(AddWaterMarkXml.class.getName());
		FileHandler fh = null;
		
		BaseFont font;
		PdfGState graphicState;
		BaseColor color;

		try {
			fh = new FileHandler("c:\\pdf\\logs\\addWaterMarkXml.txt",true);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logAddWaterMarkXml.addHandler(fh);
			logAddWaterMarkXml.setLevel(Level.CONFIG);
			PdfReader read = new PdfReader(src);
			int numeroDePaginas = read.getNumberOfPages();
			PdfStamper stamper = new PdfStamper(read,
					new FileOutputStream(dest));
			int i = 0;
			PdfContentByte contByte;
			font = BaseFont.createFont(BaseFont.COURIER_BOLD, BaseFont.WINANSI,
					BaseFont.NOT_EMBEDDED);
			graphicState = new PdfGState();
			graphicState.setFillOpacity(0.3f);
			graphicState.setStrokeOpacity(0.3f);
			color = BaseColor.RED;

			while (i < numeroDePaginas) {
				i++;
				contByte = stamper.getUnderContent(i);
				contByte.saveState();
				contByte.setGState(graphicState);
				contByte.setColorFill(color);
				contByte.beginText();
				contByte.setFontAndSize(font, 40);
				contByte.showTextAligned(Element.ALIGN_CENTER, xml, read
						.getPageSize(i).getHeight() / 2, read.getPageSize(i)
						.getWidth() / 2, 90);
				contByte.endText();
				contByte.restoreState();
			}
			stamper.close();
		} catch (Exception e) {
			logAddWaterMarkXml.log(Level.SEVERE, "Erro de I/O. O arquivo pdf de entrada ou de saída não foi encontrado. \n Ou você não tem permissão para gravá-lo.\n "+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		}

	}

}
