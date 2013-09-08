package br.com.app;



import itext.EditorPDF;

import java.util.Scanner;
import java.util.logging.Logger;

//import org.apache.log4j.Logger; 
//import com.itextpdf.text.log.Level;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.MissingArgumentException;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.cli.UnrecognizedOptionException;

public class App2 {


	private static Options novasOpcoes() {
		Options opts = new Options();

		Option inserirPNG = OptionBuilder.withArgName("file").hasArgs(3)
				// funcao, pdf, imagem
				.withValueSeparator().withDescription("Inserir imagem png")
				.withLongOpt("imagem").create("i");
		
		opts.addOption(inserirPNG);
		
		Option inserirMarcaXML = OptionBuilder.withArgName("file").hasArgs(3)
				// funcao, pdf, xml
				.withValueSeparator().withDescription("Inserir Marca d Agua a partir de um arquivo xml")
				.withLongOpt("xml").create("x");
		
		opts.addOption(inserirMarcaXML);
		
		Option merge = OptionBuilder.withArgName("file").hasArgs(3)
				// funcao, pdf, pdf
				.withValueSeparator().withDescription("unir dois arquivos pdf")
				.withLongOpt("merge").create("m");
		
		opts.addOption(merge);
		
		Option separar = OptionBuilder.withArgName("file").hasArgs(3)
				// funcao, pdf, pagina
				.withValueSeparator().withDescription("dividir um pdf em dois ")
				.withLongOpt("separar").create("s");
		
		opts.addOption(separar);
		
		Option delecao = OptionBuilder.withArgName("file").hasArgs(3)
				// funcao, pdf, pagina
				.withValueSeparator().withDescription("remover uma pagina")
				.withLongOpt("delecao").create("d");
		
		opts.addOption(delecao);
		
		Option trocarOrientacao = OptionBuilder.withArgName("file").hasArgs(3)
				// funcao, pdf, orientacao
				.withValueSeparator().withDescription("Trocar a orintacao de todas as paginas do pdf")
				.withLongOpt("todaorientacao").create("t");
		
		opts.addOption(trocarOrientacao);
		
		Option orientacao = OptionBuilder.withArgName("file").hasArgs(3)
				// funcao, pdf, orientacao, pagina
				.withValueSeparator().withDescription("trocar orientacao de uma unica pagina")
				.withLongOpt("orientacao").create("o");
		
		opts.addOption(orientacao);
		
		Option sair = OptionBuilder
				//sair
				.withValueSeparator().withDescription("fechar o programa")
				.withLongOpt("quit").create("q");
		
		opts.addOption(sair);
		
		Option help = OptionBuilder
				//ajuda
				.withValueSeparator().withDescription("Orientacoes gerais")
				.withLongOpt("help").create("h");
		
		opts.addOption(sair);
		

		return opts;

	}

	private static Logger logApp = Logger.getLogger(App.class.getName());

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// logApp.setLevel(Level.ERROR);
		// logApp.setLevel(java.util.logging.Level.SEVERE);

		//Options op = criarOpcoes();
		
		Options op = novasOpcoes();

		HelpFormatter help = new HelpFormatter();
		help.printHelp("ajuda", op);

		EditorPDF pdf1 = new EditorPDF();

		try {
			CommandLineParser parser = new PosixParser();
			CommandLine cmd = null;

			Scanner sc = new Scanner(System.in);
			String[] s;
			while (true) {
				s = sc.nextLine().split(" ");
				cmd = parser.parse(op, s);

				if (cmd.hasOption("q")) {
					System.out.println("Fim da aplicação");
					break;
				}
				if (cmd.hasOption("i")) {
					
					pdf1.incluirPNG(s); //ok

				}
				if (cmd.hasOption("x")) {
					
					pdf1.incluirXML(s); //ok

				}
				if (cmd.hasOption("m")) {
					pdf1.fusao(s);

				}
				if (cmd.hasOption("s")) {
					pdf1.divisao(s);

				}
				if (cmd.hasOption("d")) {
					pdf1.delecao(s);

				}
				if (cmd.hasOption("t")) {
					pdf1.orientacaoDeTudo(s);

				}
				if (cmd.hasOption("o")) {
					pdf1.orientacaDeUmaPag(s);

				}
				if (cmd.hasOption("h")) {
					help.printHelp("ajuda", op);

				}
			}
		} catch (UnrecognizedOptionException u) {

			// logApp.error(e + "Erro na App cli");
			// logApp.log(Level.ERROR, e);
			logApp.setLevel(java.util.logging.Level.SEVERE);
			//logApp.config(u.toString());
			logApp.severe(" opcao invalida " + u.getMessage() + " comando inexistente");

		} catch (MissingArgumentException missing) {
			// TODO: handle exception
			logApp.severe("Necessario argumento para esse comando");

		} catch (ParseException e) {
			System.out.println("ainda nao sei qual erro é esse,mas é para a linha 86");
			e.printStackTrace();

		}

	}

}
