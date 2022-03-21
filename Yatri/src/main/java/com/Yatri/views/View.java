package com.Yatri.views;

import java.io.IOException;

import org.apache.log4j.Logger;

import jline.console.ConsoleReader;

public class View {

	ConsoleReader reader;
	Logger log= Logger.getLogger(View.class);

	public void getView() {
		try {
			String line;
			reader= new ConsoleReader();
			
			while ((line = reader.readLine()) != null) {
				line = line.trim();

				if (line.isEmpty()) {
					continue;
				}

				System.out.println("Line is :"+ line);
				log.info("Line is :"+ line);
				//String words[] = line.split("\\s+");

				//if (!executeCommand(words)) {
				//	System.out.println("invalid command!");
				//}
			}
		} catch (IOException e) {
			log.error("Exception while fetching view"+ e.getMessage());
		}
	}
}
