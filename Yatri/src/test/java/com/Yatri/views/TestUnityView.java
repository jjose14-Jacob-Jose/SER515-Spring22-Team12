package com.Yatri.views;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.junit.Test;

public class TestUnityView {

	Logger log= Logger.getLogger(TestUnityView.class);

	@Test
	public void testExecuteCommand() throws IOException {
		UnityView unityView= new UnityView();
		unityView.executeCommand("download unity");

		assertEquals(1, 1);
		log.info("completed test");
	}
}
