package com.Yatri;

/*
 * Credits:
 * 		url: https://gist.github.com/nathan-fiscaletti/9dc252d30b51df7d710a
 * 		author: Nathan Fiscaletti
 * 
 * Example Usage
 * 
 *      Color code format WITH background color -> :foreground,background:
 *   Color code format WITHOUT background color -> :foreground,N:
 *                           Reset Color format -> [RC]
 *   
 *   Example Use: 
 *   
 *              String ansiColoredString = 
 *                  ColorCodes.parseColors(
 *                      "Hello, This :blue,n:is[RC] a :red,white:response[RC]."
 *                  );
 *                  
 *              - or -
 *              
 *              String ansiColoredString = 
 *                  ColorCodes.RED + 
 *                  "Hello" + ColorCodes.WHITE + 
 *                  ". This is a " + 
 *                  ColorColorCodes.BLUE + 
 *                  "test";
 */

/**
 * Class used for ANSI Color manipulation in a console supporting ANSI color
 * codes
 */
public class ColorCodes {

	public static final String RESET = "\u001B[0m";
	public static final String GREEN = "\u001B[32;1m";
	public static final String YELLOW = "\u001B[33;1m";
	public static final String BLUE = "\u001B[34;1m";

}