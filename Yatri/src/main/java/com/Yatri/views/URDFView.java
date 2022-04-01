package com.Yatri.views;

import java.io.IOException;

import org.apache.log4j.Logger;

public class URDFView extends View {

	Logger log= Logger.getLogger(URDFView.class);

	public URDFView() {
		super(null, "URDF");
	}

	@Override
	boolean executeCommand(String words) throws IOException {

		// To Be Done
		String fileURL="";
		//URL url = new URL(fileURL);

		if(words.trim().equalsIgnoreCase("Prepare URDF")) {
			log.info("Preparing URDF");

			log.info("return requested URDF");
		}
		return true;
	}
}
