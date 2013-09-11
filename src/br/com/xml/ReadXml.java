package br.com.xml;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

public class ReadXml {

	public String read(String s) {

		String response = "";
		Digester digester = new Digester();
		digester.setValidating(false);
		digester.addObjectCreate("Logo/Marca", Marca.class);
		digester.addBeanPropertySetter("Logo/Marca/info", "info");

		File input = new File(s);

		try {
			Marca marca = digester.parse(input);
			response = marca.getInfo();
		} catch (IOException e) {
			Logger.getLogger(ReadXml.class.getName()).log(Level.SEVERE,"Arquivo não pode ser criado verifique as permissões e tente novamente.",e);
		} catch (SAXException e) {
			Logger.getLogger(ReadXml.class.getName()).log(Level.SEVERE,"Erro ao fazer a leitura do arquivo XML. Verifique.",e);
		}

		return response;

	}

}
