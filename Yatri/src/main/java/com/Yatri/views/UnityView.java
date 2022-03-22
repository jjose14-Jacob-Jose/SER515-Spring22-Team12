package com.Yatri.views;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

public class UnityView extends View {

	Logger log= Logger.getLogger(UnityView.class);

	public UnityView() {
		super(null, "Unity");
	}

	@Override
	boolean executeCommand(String words) throws IOException {
		
		String fileURL="https://public-cdn.cloud.unity3d.com/hub/prod/UnityHubSetup.exe";

		if(words.trim().equalsIgnoreCase("Download Unity")) {
			log.info("Starting downloading Unity");

			try {
				URL myURL = new URL("https://public-cdn.cloud.unity3d.com/hub/prod/UnityHubSetup.exe");
				HttpURLConnection myURLConnection = (HttpURLConnection) myURL.openConnection();
				
				int responseCode = myURLConnection.getResponseCode();
				
		        if (responseCode == HttpURLConnection.HTTP_OK) {
		            String fileName = "";
		            String disposition = myURLConnection.getHeaderField("Content-Disposition");
		            String contentType = myURLConnection.getContentType();
		            int contentLength = myURLConnection.getContentLength();
		 
		            if (disposition != null) {
		                int index = disposition.indexOf("filename=");
		                if (index > 0) {
		                    fileName = disposition.substring(index + 10,
		                            disposition.length() - 1);
		                }
		            } else {
		                fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1,
		                        fileURL.length());
		            }
		 
		            log.info("Content-Type = " + contentType);
		            log.info("Content-Disposition = " + disposition);
		            log.info("Content-Length = " + contentLength);
		            log.info("fileName = " + fileName);
		 
		            InputStream inputStream = myURLConnection.getInputStream();
		            
		            String saveFilePath = "C://Users" + File.separator + fileName;
		             
		            FileOutputStream outputStream = new FileOutputStream(saveFilePath);
		 
		            int bytesRead = -1;
		            byte[] buffer = new byte[1024];
		            while ((bytesRead = inputStream.read(buffer)) != -1) {
		                outputStream.write(buffer, 0, bytesRead);
		            }
		 
		            outputStream.close();
		            inputStream.close();
		 
		            log.info("File downloaded");
		        } else {
		        	log.info("No file to download. Server replied HTTP code: " + responseCode);
		        }
		        myURLConnection.disconnect();
		        
			} 
			catch (MalformedURLException e) { 
				log.error("MalformedURLException Occured: "+ e.getMessage());
			} 
			catch (IOException e) {   
				log.error("IOException Occured: "+ e.getMessage());
			}
		}
		return true;
	}
}
