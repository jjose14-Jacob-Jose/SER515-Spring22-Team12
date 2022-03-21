package com.Yatri.commands;

import org.springframework.stereotype.Component;

import picocli.CommandLine.Command;

@Command(
		name = "unity",
		description = "Download Unity"
		)
@Component
public class Unity implements Runnable{

	@Override
	public void run() {
		System.out.println("Reached Unity Command");
	}

}
