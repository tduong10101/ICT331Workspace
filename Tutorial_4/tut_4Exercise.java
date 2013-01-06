package Tutorial_4;

import java.io.*;
import java.util.*;

public class tut_4Exercise {
	public static void main(String[] arg0) {
		// Creat ouput and input files
		File fileInput = new File("H:\\eclipse\\Workspace\\demographics.txt");
		File fileOutput = new File("H:\\eclipse\\Workspace\\demographicsXmlOutput.txt");
		try {
			Scanner input = new Scanner(fileInput);
			ArrayList y = new ArrayList();
			while (input.hasNext()) {
				y.add(input.next());

			}
			input.close();
			PrintWriter output = new PrintWriter(fileOutput);
			output.println("<?xml version=“1.0” encoding=“ISO-8859-1”?>");
			for (int i = 0; i < y.size(); i++) {
				//if i is even output city name format
				if (i % 2 == 0) {
					output.println("<cities>");
					output.println("<item>");
					output.println("<city>"+y.get(i) + "</city>\n");
				} //else ouput median format
				else {
					output.println("<median>" + y.get(i)
							+ "</median>\n");
					output.println("</item>");
					output.println("</cities>");
				}
			}
			output.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println ("The system cannot find the path specified");
			System.exit(0);
		
		}

	}
}
