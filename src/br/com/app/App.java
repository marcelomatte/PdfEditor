package br.com.app;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.commons.cli.PosixParser;
import org.apache.commons.cli.UnrecognizedOptionException;

import com.itextpdf.text.List;

import br.com.servicos.AddWaterMarkImg;
import br.com.servicos.MergePdf;
import br.com.servicos.SlpitPdf;

public class App {
	/**
	 * @param args
	 */
	protected static CommandLineParser parser = new PosixParser();
	protected static Options options = new Options();

	private static Options createOptions() {
		Option addwm = OptionBuilder.withArgName("addwatermarkimg").hasArgs(4)
				.withDescription("adicionar marca d'agua").withValueSeparator()
				.create("addwatermarkimg");
		options.addOption(addwm);
		Option merge = OptionBuilder.withArgName("mergepdf").hasArg()
				.withDescription("merge de dois ou mais arquivos").withValueSeparator()
				.create("mergepdf");
		options.addOption(merge);
		Option split = OptionBuilder.withArgName("splitpdf").hasArg()
				.withDescription("divide o arquivo em dois").create("splitpdf");
		options.addOption(split);
		Option rempage = OptionBuilder.withArgName("removepagepdf").hasArg()
				.withDescription("remove").create("removepagepdf");
		options.addOption(rempage);
		Option defineall = OptionBuilder.withArgName("defineorientationall")
				.hasArg().withDescription("define all")
				.create("defineorientationall");
		options.addOption(defineall);
		Option definepage = OptionBuilder.withArgName("defineorientationpage")
				.hasArg().withDescription("define page")
				.create("defineorientationpage");
		options.addOption(definepage);
		Option barcode = OptionBuilder.withArgName("insertbarcode").hasArg()
				.withDescription("add barcode no pdf").create("insertbarcode");
		options.addOption(barcode);
		Option alterpdf = OptionBuilder.withArgName("alterpdf").hasArg()
				.withDescription("add barcode no pdf").create("insertbarcode");
		options.addOption(alterpdf);
		
		Option quit = OptionBuilder
				.withValueSeparator().withDescription("fecha o programa")
				.withLongOpt("quit").create("quit");
		options.addOption(quit);

		return options;
	}

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		Options option = createOptions();
		
		HelpFormatter formatter = new HelpFormatter();
		formatter.printHelp("help", option);
		// _____________________

		try {
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
				
				String origem = comando[1];
				String destino = comando[2];
				String imagem = comando[3];
				
				AddWaterMarkImg awmi = new AddWaterMarkImg();
				awmi.SetWaterMarkImg(origem, destino, imagem);
				
				
				}
				
				if (line.hasOption("mergepdf")) {
					
					String expression = line.getOptionValue("mergepdf");
					ArrayList<String> pdfs = new ArrayList<String>();
					
//					for (String pdf : pdfs) {
//						pdfs.add(pdf);
//					}
					
					pdfs.add(comando[1]);
					pdfs.add(comando[2]);
					String path = comando[3];
					
					MergePdf mp = new MergePdf();
					mp.Merge(pdfs, path);
					
				}
				if (line.hasOption("splitpdf")) {
					
					String expression = line.getOptionValue("splitpdf");
					String org = comando[1];
					String des = comando[2];
					int pi = Integer.parseInt(comando[3]);
					int pf = Integer.parseInt(comando[4]);
					
					SlpitPdf sp = new SlpitPdf();
					sp.DividePdf(org, des, pi, pf);
					
				}
				if (line.hasOption("removepagepdf")) {
					String expression = line.getOptionValue("removepagepdf");
				}
				if (line.hasOption("defineorientationall")) {
					String expression = line
							.getOptionValue("defineorientationall");
				}
				if (line.hasOption("defineorientationpage")) {
					String expression = line
							.getOptionValue("defineorientationpage");
				}
				if (line.hasOption("insertbarcode")) {
					String expression = line.getOptionValue("insertbarcode");
				}
				if (line.hasOption("alterpdf")) {
					String expression = line.getOptionValue("alterpdf");
				}
			}
		} catch (UnrecognizedOptionException u) {
			System.out.println("comando nao existe");

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		

	}

}
