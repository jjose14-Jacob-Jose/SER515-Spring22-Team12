package com.Yatri.utility;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import org.junit.Test;

public class TestCreateXML {

	@Test
	public void testPreparebaseURDF() throws ParserConfigurationException, TransformerException {
		CreateXML xml= new CreateXML();
		xml.preparebaseURDF("orange","smaller","smaller");
	}
}
