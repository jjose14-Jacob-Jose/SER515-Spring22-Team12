package com.Yatri.views;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class UnityView extends View {

	Logger log= Logger.getLogger(UnityView.class);

	public UnityView() {
	}

	@Override
	boolean executeCommand(String words) throws IOException {

		String fileURL="https://public-cdn.cloud.unity3d.com/hub/prod/UnityHubSetup.exe";
		URL url = new URL(fileURL);

		if(words.trim().equalsIgnoreCase("Download Unity")) {
			log.info("Starting downloading Unity");

			FileUtils.copyURLToFile(url, new File("UnityHubSetup.exe"));
		}
		return true;
	}
}
