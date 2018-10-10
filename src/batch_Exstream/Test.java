package batch_proccess;

import java.io.File;
import java.io.FilenameFilter;
import java.io.PrintWriter;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		File f = null;
		File[] paths;

		try {
			f = new File("C:\\Users\\Badr Azeri\\Desktop\\EB C+ MNH\\Formation");

			// validité d'un chemin s'il est bon
			if (f.exists() && f.isDirectory()) {
				System.out.println("le chemin correspond à un réperotire");
			} else {
				System.out.println("le chemin n'est pas un réperotire");
			}

			System.out.println("-----------------------------------------");

			FilenameFilter filter = new MyFilterClass();

			File[] fileList = f.listFiles(filter);

			// trier des fichiers d'un reperotir par extenstion
			if (fileList.length > 0) {
				System.out.println("Contenant des fichiers avec l'utilisation du filtre:");

				for (File file : fileList) {
					System.out.println(file.getAbsolutePath());
					System.out.println(" ");
				}
			} else {
				System.out.println("Il n'y a pas de tels fichiers dans le chemin: " + f);
			}

			System.out.println("-----------------------------------------");

			// afficher tout le contenu du repertoire
//			paths = f.listFiles();
//			
//			System.out.println("contenu du repertoire:");
//
//			for (File path : paths) {
//
//				System.out.println(path);
//				System.out.println(" ");
//			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			
			File temp = File.createTempFile("tmp", ".opt", new File("C:\\Users\\Badr Azeri\\Desktop\\EB C+ MNH\\Formation\\temp"));
			temp.deleteOnExit();
			
			PrintWriter writer;
			writer = new PrintWriter(temp);
			writer.println(
					"-PACKAGEFILE=C:\\Users\\Badr Azeri\\Desktop\\EB C+ MNH\\Formation\\ExstreamPackage_FORMATION.pub");
			writer.println(
					"-MSGRESOURCE=C:\\Users\\Public\\Documents\\HP Exstream\\HP Exstream 9.0.107\\MsgResource_fr-fr.dat");
			writer.println(
					"-KEY=BXP*IppXc7BcSL5OAaVGu3W0pkL4iNQd40CqQ2Ue3HgyDSsUfGjDbOxW1BMb7BMc6aoOA5jlZ3W0pkL4iNQdRCqh2Krz1HgyDSsUstgIhXP9n8mb7BMc6aoOA5jlZ3W0pkL4iNQdRCqh2Krz1HgyDSsUfR1");
			writer.println("-FILEMAP=FILEINPUT,C:\\Users\\Badr Azeri\\Desktop\\EB C+ MNH\\Data\\Sample.xml");
			writer.println("-FILEMAP=REF_Agences,C:\\Users\\Badr Azeri\\Desktop\\EB C+ MNH\\Data\\REF_Agences.csv");
			//writer.println("-OUTPUTFILE=C:\\Users\\Badr Azeri\\Desktop\\Formation\\output\\output.pdf");
			writer.println("-OUTPUTDIRECTORY=C:\\Users\\Badr Azeri\\Desktop\\EB C+ MNH\\Formation\\sortie\\");
			writer.println("-TRACKOUT=NONE");
			writer.println("-MESSAGEFILE=C:\\Users\\Badr Azeri\\Desktop\\EB C+ MNH\\Formation\\MonMessageRapport.xml");
			
			
			writer.println("-RUNMODE=PRODUCTION");
			writer.flush();
			writer.close();

			ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\Hewlett-Packard\\HP Exstream\\HP Exstream 9.0.107\\Engine_DBCS.exe", "-controlfile=" + temp.getPath());
			
			Process p = pb.start();
			p.waitFor();
			System.out.println(p.exitValue());

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
