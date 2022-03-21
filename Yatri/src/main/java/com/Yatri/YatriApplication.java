package com.Yatri;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Yatri.views.View;

@SpringBootApplication
public class YatriApplication {

	public static void main(String[] args) {
		View view = new View();
		
		System.out.println("Getting View");
		view.getView();
	}
}
