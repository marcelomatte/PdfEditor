package br.com.servicos;

import java.io.File;
import java.io.IOException;

import org.apache.commons.digester3.Digester;
import org.xml.sax.SAXException;

import br.com.interfaces.IServiceStrategy;
import br.com.xml.Hierarquia;
import br.com.xml.Marca;

public class AddWaterMarkXml implements IServiceStrategy {

	@Override
	public void Execute() {
		
	}

	@Override
	public void AbortExecute() {
		
	}
	
	public AddWaterMarkXml() {

	}
	
	public void SetWaterMarkXml(String path){
		String res="";
		// TODO Auto-generated method stub
		Digester digester = new Digester();

		
		digester.setValidating(false);

		
		digester.addObjectCreate("hierarquia", "xml.Hierarquia");
		digester.addSetProperties("hierarquia");
		//digester.addSetNext("hierarquia", "addHierarquia");
		
		digester.addObjectCreate("hierarquia/marca", Marca.class);
		digester.addSetNext("hierarquia/marca", "addMarca");
		digester.addBeanPropertySetter("hierarquia/marca/nome", "nome");
		
		// specifies the xml file
		//File input = new File("./src/xml/marcaDagua.xml");
		File input = new File(path);

		try {
			// parse the xml file. The hierarchy's root node
			// is returned by the parse method
			Hierarquia hierarquia = (Hierarquia) digester.parse(input);
			//System.out.println(hierarquia);
			res= hierarquia.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		}

	}
	
	

}
