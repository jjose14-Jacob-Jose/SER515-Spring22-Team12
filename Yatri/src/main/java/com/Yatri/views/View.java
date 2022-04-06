package com.Yatri.views;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.Yatri.ColorCodes;
import com.Yatri.Render;

import jline.console.ConsoleReader;

public abstract class View {

	static ConsoleReader reader;
	static List<String> promptViews;
	Logger log= Logger.getLogger(View.class);
	String name;
	View previousView = null;

	public View(View previous, String name) {
		this.previousView = previous;
		this.name = name;	
	}

	static {
		promptViews = new ArrayList<String>();
		try {
			reader = new ConsoleReader();
		} catch (IOException e) {
			System.err.println("Error Occurred in Static block: "+ e.getMessage());	
			e.printStackTrace();
		}
	}

	public void getView() {

		setPrompt();

		try {
			String line;
			while ((line = reader.readLine()) != null) {
				line = line.trim();

				if (line.isEmpty()) {
					continue;
				}
				if (!executeCommand(line)) {
					log.info("invalid command!");
				}
			}
		} catch (IOException e) {
			log.error("Exception while fetching view"+ e.getMessage());
		}
	}

	/**
	 * @param words
	 * @return
	 * @throws IOException
	 */
	boolean executeCommand(String words) throws IOException {	

		Render service= new Render(reader);

		if (words.equalsIgnoreCase("init")) {

			// function to fetch Unity
			service.fetchUnity();	

			service.fetchURDF(authToken);

		}


		
	}


	/**
	 * 
	 */
	static void setPrompt() {
		StringBuilder prompt = new StringBuilder();

		for (int i = 0; i < promptViews.size(); i++) {
			String pv = promptViews.get(i);
			prompt.append(ColorCodes.BLUE + pv);

			if (i < promptViews.size() - 1)
				prompt.append(ColorCodes.BLUE + ">");
		}

		prompt.append(ColorCodes.YELLOW + "~" + ColorCodes.GREEN + "$ " + ColorCodes.RESET);

		reader.setPrompt(prompt.toString());
	}
}
