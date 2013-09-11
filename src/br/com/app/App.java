package br.com.app;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.cli.UnrecognizedOptionException;

import br.com.interfaces.IServiceStrategy;
import br.com.servicos.AddPrevilegePdf;
import br.com.servicos.AddWaterMarkImg;
import br.com.servicos.AddWaterMarkXml;
import br.com.servicos.CreatePdfFile;
import br.com.servicos.DefineOrientationAll;
import br.com.servicos.DefineOrientationPage;
import br.com.servicos.InsertBarCode;
import br.com.servicos.MergePdf;
import br.com.servicos.RemovePagePdf;
import br.com.servicos.SlpitPdf;
import br.com.xml.ReadXml;

import com.itextpdf.text.DocumentException;

public class App {

	
	protected static CommandLineParser parser = new PosixParser();
	protected static Options options = new Options();

	private static Options createOptions() {
		Option addwm = OptionBuilder.withArgName("addwatermarkimg").hasArgs(4).withDescription("Adicionar Marca D'agua por meio de imagem. |Local origem| |Local destino| |Local imagem|").withValueSeparator().create("addwatermarkimg");
		options.addOption(addwm);
		Option addwx = OptionBuilder.withArgName("addwatermarkxml").hasArgs(3).withDescription("Adicionar Marca D'agua por meio de XML. |Local origem| |Local destino| |Local imagem|").withValueSeparator().create("addwatermarkxml");
		options.addOption(addwx);
		Option create = OptionBuilder.withArgName("createpdffile").hasArgs(7).withDescription("Criar um documento PDF. |Texto| |Nome| |Local Origem| |Local Destino| |Margem E| |Margem D| |Margem S| |Margem I|").withValueSeparator().create("createpdffile");
		options.addOption(create);
		Option merge = OptionBuilder.withArgName("mergepdf").hasArg().withDescription("Mesclar dois ou mais arquivos PDF. |Local dos Arquivos PDF separados por espaços| |Local Destino|").withValueSeparator().create("mergepdf");
		options.addOption(merge);
		Option split = OptionBuilder.withArgName("splitpdf").hasArg().withDescription("Divide um arquivo PDF em dois. |Local Origem| |Local Destino| |Página Inicial| |Página Final|").create("splitpdf");
		options.addOption(split);
		Option rempage = OptionBuilder.withArgName("removepagepdf").hasArg().withDescription("Remover uma pagina de um arquivo PDF. |Local Origem| |Local Destino| |Número da Página|").create("removepagepdf");
		options.addOption(rempage);
		Option defineall = OptionBuilder.withArgName("defineorientationall").hasArg().withDescription("Define a orientação de página para Retrato ou Paisagem de todas as páginas. |Local Origem| |Local Destino|").create("defineorientationall");
		options.addOption(defineall);
		Option definepage = OptionBuilder.withArgName("defineorientationpage").hasArg().withDescription("Define a orientação de uma única página do PDF. |Local Origem| |Local Destino| |Numero da Página|").create("defineorientationpage");
		options.addOption(definepage);
		Option barcode = OptionBuilder.withArgName("insertbarcode").hasArg().withDescription("Criar um novo documento com Código de Barras. |Local Destino| |Código de Barras|").create("insertbarcode");
		options.addOption(barcode);
		Option privilege = OptionBuilder.withArgName("privilege").hasArg().withDescription("Adiciona protecao com senha em um arquivo PDF. |USER| |PASSWORD| |Local Origem| |Local Destino").create("privilege");
		options.addOption(privilege);
		Option quit = OptionBuilder.withValueSeparator()
				.withDescription("Fechar o Programa.").withLongOpt("quit")
				.create("quit");
		options.addOption(quit);

		return options;
	}

	public static void main(String[] args) throws IOException {
		Options option = createOptions();
		HelpFormatter formatter = new HelpFormatter();
		IServiceStrategy is;
		formatter.printHelp("help", option);
		Logger logApp = Logger.getLogger(App.class.getName());
		FileHandler fh = null;

		try {
			fh = new FileHandler("c:\\pdf\\logs\\AppMainClass.txt",true);
			SimpleFormatter logformatter = new SimpleFormatter();
			fh.setFormatter(logformatter);
			logApp.addHandler(fh);
			logApp.setLevel(Level.CONFIG);
			CommandLineParser parser = new PosixParser();
			CommandLine line = null;
			Scanner scanner = new Scanner(System.in);
			String[] comando;
			
			while (true) {
				comando = scanner.nextLine().split(" ");
				line = parser.parse(option, comando);

				if (line.hasOption("quit")) {
					System.out.println("Aplicação Terminada");
					break;
				}

				if (line.hasOption("addwatermarkimg")) {
					String expression = line.getOptionValue("addwatermarkimg");
					
					if (comando.length<4) {
						System.out.println("Número de parametros incorretos");
						main(null);
					}
					
					is = new AddWaterMarkImg();
					is.Execute(comando);
					formatter.printHelp("help", option);
				}
				if (line.hasOption("addwatermarkxml")) {
					String expression = line.getOptionValue("addwatermarkxml");
					
					if(comando.length<4){
						System.out.println("Número incorreto de parametros");
						main(null);
					}
					
					String xml = comando[3];
					ReadXml reader = new ReadXml();
					String marca = reader.read(xml);
					comando[3] = marca;

					is = new AddWaterMarkXml();
					is.Execute(comando);
					formatter.printHelp("help", option);
				}
				if (line.hasOption("mergepdf")) {
					String expression = line.getOptionValue("mergepdf");
					
					int i = comando.length;
					
					if(comando.length<i){
						System.out.println("Número incorreto de parametros");
						main(null);
					}
					
					is = new MergePdf();
					is.Execute(comando);
					formatter.printHelp("help", option);
				}				
				if (line.hasOption("createpdffile")) {
					String expression = line.getOptionValue("createpdffile");					
					
					if (comando.length<8) {
						System.out.println("Número incorreto de parametros");
						main(null);
					}
					
					is = new CreatePdfFile();
					is.Execute(comando);
					formatter.printHelp("help", option);
				}
				
				if (line.hasOption("splitpdf")) {
					String expression = line.getOptionValue("splitpdf");					
					
					if (comando.length<5) {
						System.out.println("Número incorreto de parametros");
						main(null);
					}
					is = new SlpitPdf();
					is.Execute(comando);
					formatter.printHelp("help", option);
				}
				if (line.hasOption("removepagepdf")) {
					String expression = line.getOptionValue("removepagepdf");				
					
					if(comando.length<4){
						System.out.println("Número incorreto de parametros");
						main(null);
					}
					
					is = new RemovePagePdf();
					is.Execute(comando);
					formatter.printHelp("help", option);		
				}
				if (line.hasOption("defineorientationall")) {
					String expression = line.getOptionValue("defineorientationall");
					
					if(comando.length<3){
						System.out.println("Número incorreto de parametros");
						main(null);
					}
					
					try {
						is = new DefineOrientationAll();
						is.Execute(comando);
					} catch (DocumentException e) {
						logApp.log(Level.SEVERE, "Problemas na criação do arquivo .pdf verifique."+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
					}	
					formatter.printHelp("help", option);				
				}
				if (line.hasOption("defineorientationpage")) {
					String expression = line
							.getOptionValue("defineorientationpage");
					
					if (comando.length<4) {
						System.out.println("Número incorreto de parametros");
						main(null);
					}
					
					is = new DefineOrientationPage();
					is.Execute(comando);
					formatter.printHelp("help", option);			
				}
				if (line.hasOption("insertbarcode")) {
					String expression = line.getOptionValue("insertbarcode");				
					
					if (comando.length<3) {
						System.out.println("Número de parametros incorreto verifique.");
						main(null);
					}
					
					is = new InsertBarCode();
					is.Execute(comando);					
					formatter.printHelp("help", option);	
				}		
				if (line.hasOption("privilege")) {
					String expression = line.getOptionValue("privilege");				
					
					if(comando.length<5){
						System.out.println("Número de parametros incorreto verifique.");
						main(null);
					}
					
					is = new AddPrevilegePdf();
					is.Execute(comando);
					formatter.printHelp("help", option);	
				}		
			}
		} catch (UnrecognizedOptionException e) {
			logApp.log(Level.SEVERE, "Exceção lançada durante a análise(Parse) sinalizando uma opção não reconhecida foi usada. \n"+e.getMessage()+"\n"+e.getClass().getCanonicalName()+"\n");
			main(null);
		} catch (ParseException e) {
			logApp.fine("Sinais de que um erro ocorreu inesperadamente durante a análise(Parse)." + e.getCause());
			main(null);
		}
	
	}
		
	
}
