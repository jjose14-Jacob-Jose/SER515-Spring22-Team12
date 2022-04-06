package com.Yatri;

import java.io.File;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

import jline.console.ConsoleReader;

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

			if (response.equalsIgnoreCase("Y")) {

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

			if (response.equalsIgnoreCase("One Shape")) {

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

}
