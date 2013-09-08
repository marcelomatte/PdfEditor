package br.com.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//import apacheXMLRules.Person;

public class Hierarquia {

	private List<Marca> marca;

	public Hierarquia() {
		// TODO Auto-generated constructor stub
		marca = new ArrayList<Marca>();

	}

	public void addMarca(Marca m) {
		marca.add(m);
	}


	public String toString() {

		String newline = System.getProperty("line.separator");// o que é isso?
		StringBuffer buf = new StringBuffer();

		// buf.append("Nome: " + nome).append(newline);

		//buf.append("--- Marca ---").append(newline);
		for (int i = 0; i < marca.size(); i++) {
			buf.append(marca.get(i)).append(newline);
		}


		return buf.toString();

	}
	
	public void print() {
		System.out.println("Address book has " + marca.size() + " entries");

		for (Iterator<Marca> i = marca.iterator(); i.hasNext();) {
			Marca m = i.next();
			//p.print();
		}
	}

}
