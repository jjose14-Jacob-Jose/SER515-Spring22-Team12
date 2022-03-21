package com.Yatri;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Yatri.views.UnityView;

@SpringBootApplication
public class YatriApplication{

	public static void main(String[] args) {

		UnityView view = new UnityView();

		System.out.println("Getting View");
		view.getView();
	}

}
