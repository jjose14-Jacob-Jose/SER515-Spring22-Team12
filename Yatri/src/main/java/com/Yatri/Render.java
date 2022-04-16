package com.Yatri;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import com.Yatri.utility.CreateXML;

import jline.console.ConsoleReader;
import jline.console.completer.AggregateCompleter;
import jline.console.completer.ArgumentCompleter;
import jline.console.completer.Completer;
import jline.console.completer.NullCompleter;
import jline.console.completer.StringsCompleter;

public class Render {

	ConsoleReader reader = null;
	Logger log= Logger.getLogger(Render.class);

	public Render(ConsoleReader reader) {
		super();
		this.reader = reader;
	}

	public Render() {

	}

	/**
	 * Method to fetch Unity
	 * @return
	 */
	public void fetchUnity(){

		try {
			reader.setPrompt(ColorCodes.BLUE + "Do you want to download pre confgured unity? [Y] Yes \t [N] No:" + ColorCodes.RESET);
			String response = reader.readLine();

			if (response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("Yes")) {

				String fileURL="https://public-cdn.cloud.unity3d.com/hub/prod/UnityHubSetup.exe";
				URL url = new URL(fileURL);
				log.info("Starting downloading Unity");

				FileUtils.copyURLToFile(url, new File("UnityHubSetup.exe"));

				log.info("Download complete. Please go to SER515-Spring22-Team12\\Yatri\\target folder to find exe unity file");

			}
		}catch(Exception ex) {
			log.error("Exception occured :"+ ex.getMessage());
		}
	}


	/**
	 * Method to fetch URDF file 
	 */
	public void fetchURDF(){
		try {
			reader.setPrompt(ColorCodes.BLUE + "Select design of rover to be implemented:" + ColorCodes.RESET);
			String response = reader.readLine();

			if (response.trim().equalsIgnoreCase("One Shape")) {

				String fileURL="https://raw.githubusercontent.com/ros/urdf_tutorial/ros1/urdf/01-myfirst.urdf";
				URL url = new URL(fileURL);
				log.info("Fetching URDF");

				FileUtils.copyURLToFile(url, new File("urdf.xml"));

				log.info("URDF file downloaded at SER515-Spring22-Team12\\Yatri\\target folder.");

			}
		}catch(Exception ex) {
			log.error("Exception occured :"+ ex.getMessage());
		}
	}


	/**
	 * Method to fetch URDF file 
	 * @param completer 
	 */
	public void fetchCustomizedURDF(Completer completer){

		if(null != completer) {
			reader.removeCompleter(completer);
		}

		List<Completer> completers = new ArrayList<Completer>();
		completers.add(new ArgumentCompleter(new StringsCompleter("blue","orange"), new NullCompleter()));
		completer = new AggregateCompleter(completers);
		reader.addCompleter(completer);

		try {
			reader.setPrompt(ColorCodes.BLUE + "Select color of rover body to be implemented:" + ColorCodes.RESET);
			String bodyColor = reader.readLine();
			
			log.info("Body Color chosen: "+ bodyColor);

			reader.removeCompleter(completer);

			completers = new ArrayList<Completer>();
			completers.add(new ArgumentCompleter(new StringsCompleter("bigger","smaller"), new NullCompleter()));
			completer = new AggregateCompleter(completers);
			reader.addCompleter(completer);

			reader.setPrompt(ColorCodes.BLUE + "Select size of the Right wheels for rover:" + ColorCodes.RESET);
			String rightWheelSize = reader.readLine();
			
			log.info("Right Wheel Size chosen: "+ rightWheelSize);

			reader.setPrompt(ColorCodes.BLUE + "Select size of the Left wheels for rover:" + ColorCodes.RESET);
			String leftWheelSize = reader.readLine();
			
			log.info("Left Wheel Size chosen: "+ leftWheelSize);

			log.info("Customizing Rover: Please wait");

			CreateXML xml= new CreateXML();
			xml.preparebaseURDF(bodyColor,rightWheelSize,leftWheelSize);

			log.info("URDF file downloaded at SER515-Spring22-Team12\\Yatri\\target folder.");
			
		}catch(Exception ex) {
			log.error("Exception occured :"+ ex.getMessage());
		}
	}

}
