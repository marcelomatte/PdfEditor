package br.com.servicos;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import br.com.interfaces.IServiceStrategy;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;

public class AddWaterMarkImg implements IServiceStrategy {


	@Override
	public void Execute(String[] args) {
		
		String origem = args[1];
		String destino = args[2];
		String imagem = args[3];
		
		SetWaterMarkImg(origem, destino, imagem);
	}
	
	public AddWaterMarkImg() {

	}

	public void SetWaterMarkImg(String origem, String destino, String imagem) {
		
		Logger logAddWaterMarkImg = Logger.getLogger(AddWaterMarkImg.class.getName());
		FileHandler fh = null;
		
		try {
			
			fh = new FileHandler("c:\\pdf\\logs\\addWaterMarkImgClass.txt",true);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logAddWaterMarkImg.addHandler(fh);
			logAddWaterMarkImg.setLevel(Level.CONFIG);
			
			PdfReader pdfReader = new PdfReader(origem);
			int numeroDePaginas = pdfReader.getNumberOfPages();
			PdfStamper stamper = new PdfStamper(pdfReader,
					new FileOutputStream(destino));
			int i = 0;

			Image jpg = Image.getInstance(imagem);
			jpg.setAbsolutePosition(100, 200);

			PdfContentByte mark;

			while (i < numeroDePaginas) {
				i++;
				mark = stamper.getUnderContent(i);
				mark.addImage(jpg);
			}
			stamper.close();

		} catch (IOException e) {
			logAddWaterMarkImg.log(Level.SEVERE, "Erro de I/O. O arquivo pdf de entrada ou de saída não foi encontrado. \n Ou você não tem permissão para gravá-lo.\n "+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		} catch (DocumentException e) {
			logAddWaterMarkImg.log(Level.SEVERE, "Problemas na criação do arquivo .pdf verifique."+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
		}

	}

}
