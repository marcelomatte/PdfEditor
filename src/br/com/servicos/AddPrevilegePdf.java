package br.com.servicos;

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
import com.itextpdf.text.pdf.PdfWriter;

public class AddPrevilegePdf implements IServiceStrategy {

	@Override
	public void Execute(String args[]) {
		
		String user = args[1];
		String password = args[2];
		String origem = args[3];
		String destino =args[4];
		
		encryptPdf(user, password, origem, destino);
		
	}

	public void encryptPdf(String user, String senha, String src, String dest) {
			
		Logger logPrivilege = Logger.getLogger(AddPrevilegePdf.class.getName());
		FileHandler fh = null;
	
		byte[] usuario = user.getBytes();
		byte[] password = senha.getBytes();
			
		try {
			fh = new FileHandler("c:\\pdf\\logs\\addPrivilegeClass.txt",true);
			SimpleFormatter formatter = new SimpleFormatter();
			fh.setFormatter(formatter);
			logPrivilege.addHandler(fh);
			logPrivilege.setLevel(Level.CONFIG);
			PdfReader reader;
			reader = new PdfReader(src);
			PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
			stamper.setEncryption(usuario, password,PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
			stamper.close();
			reader.close();
			} catch (IOException e) {
				logPrivilege.log(Level.SEVERE, "Erro de I/O. O arquivo pdf de entrada ou de sa�da n�o foi encontrado. \n Ou voc� n�o tem permiss�o para grav�-lo.\n "+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n"); 
			} catch (DocumentException e) {
				logPrivilege.log(Level.SEVERE, "Problemas na cria��o do arquivo .pdf verifique."+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
			}

	}

}
