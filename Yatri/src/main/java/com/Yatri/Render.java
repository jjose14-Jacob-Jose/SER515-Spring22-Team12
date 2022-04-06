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

			}
		}catch(Exception ex) {
			log.error("Exception occured :"+ ex.getMessage());
		}
	}


	public void fetchURDF(){

	}

}
