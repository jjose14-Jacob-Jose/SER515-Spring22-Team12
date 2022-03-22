package com.Yatri;

import org.apache.log4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Yatri.config.Config;
import com.Yatri.views.UnityView;

@SpringBootApplication
public class YatriApplication{
	
	static Logger log= Logger.getLogger(YatriApplication.class);

	public static void main(String[] args) {

		// Configuration to add appenders for Log4J		
		Config.configure();

		log.info("Fetching Unity Download View");
		UnityView view = new UnityView();
		view.getView();
	}

}
