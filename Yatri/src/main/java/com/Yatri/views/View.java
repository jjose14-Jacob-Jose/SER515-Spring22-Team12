package com.Yatri.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.Yatri.ColorCodes;
import com.Yatri.Render;

import jline.console.ConsoleReader;
import jline.console.completer.AggregateCompleter;
import jline.console.completer.ArgumentCompleter;
import jline.console.completer.Completer;
import jline.console.completer.NullCompleter;
import jline.console.completer.StringsCompleter;

public class View {

	static ConsoleReader reader;
	static List<String> promptViews;
	static Completer completer;
	Logger log= Logger.getLogger(View.class);
	String name;
	View previousView = null;

	public View() {	
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

		reader.removeCompleter(completer);

		addTabProperties();

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
		boolean result=false;

		try {
			if (words.equalsIgnoreCase("init")) {

				// function to fetch Unity
				service.fetchUnity();	

				// function to fetch URDF
				service.fetchURDF();
				
				// function Rover URDF
				service.fetchCustomizedURDF(completer);
				result= true;
			}

		}catch(Exception ex) {
			log.error("Exception Occured: " + ex.getMessage());
			result= false;
		}
		return result;
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


	void addTabProperties() {	

		List<Completer> completers = new ArrayList<Completer>();
		completers.add(new ArgumentCompleter(new StringsCompleter("One Shape"), new NullCompleter()));
		completer = new AggregateCompleter(completers);
		reader.addCompleter(completer);

	}
}
