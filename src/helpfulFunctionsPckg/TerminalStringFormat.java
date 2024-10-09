/*
 * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * Description:
 * This file is a class file of the package 'helpfulFunction' for the project 'Izi Management Software'. It is an abstract Class that 
 * has functions to format texts on the Command Line Interface.
 * 
 * This class is part of the package 'helpfulFunction'. The package 'helpfulFunction', created for this program, has classes and 
 * methods that can facilitate creating java program that takes in user input, especially from the Command Line Interface. 
 * 
 * File Name: 				TerminalStringFormat.java
 * File Version:            1.0
 * File Author:				Israel Charles
 * Created On:          	12/15/2023
 * Last Modification On:    12/25/2023
 * Last Modification By:  	Israel Charles
 * 
 * Parent Project:          Izi Management Software
 * Parent Package:			helpfulFunction
 * Project Folder Name:		IziManagementProject
 * Parent Main File:		SetupAndRun.java
 * Project Version:             	1.0
 * 
 *////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package helpfulFunctionsPckg;

public abstract class TerminalStringFormat extends Input{
	
	// Function that centers a text based on a given maximum amount of character per line
	public static String centerText(String stringToCenter, int maxWidth) {
		
		String centeredString = "";								// Declaring and initializing the variable of the string to return
		String[] lines = stringToCenter.split("\n");			// Creating an array of lines for the text that will be centered
		
		// Loop to center each line
		for (String line: lines) {
			line.trim();										// Removing leading and trailing whitespace from the line
			
			// Rearranging the staring position for the line if it has less characters than the maximum amount of characters per line
			if (maxWidth > line.length()) {
				
				// Number of blank space to place before the line for it to appear centered
				int padding = (maxWidth - line.length()) / 2;
				
				// Adding the centered line to the string to return
				centeredString += String.format("%" + padding + "s%s\n", "", line);
			}
			
			// No need for whitespace padding if the line is bigger than the maximum amount of character per line
			else {
				centeredString += line;
			}
		}
		
		// Returning the centered line(s)
		return centeredString;
	}
	
	// Function that put a line in between a box made of a given character
	public static String boxLine(String textLine, String boxCharsToUse) {
		
        int length = textLine.length();

        // Create the top border of the box
        StringBuilder box = new StringBuilder(boxCharsToUse.repeat(length + 4)).append("\n");

        // Create the sides of the box with the input string
        box.append(boxCharsToUse + " ").append(textLine + " ").append(boxCharsToUse + "\n");

        // Create the bottom border of the box
        box.append(boxCharsToUse.repeat(length + 4));

        return box.toString();
    }
	
	/* -------------------------------------------------------------------------------------------------------------------------------
	 * Note: The following functions might not work in all terminals
	 * "\033[0m" is the escape sequence to reset to the default format of characters in most Command Line Interface
	 * "\033[1m" is the escape sequence for Bolded characters in most Command Line Interface
	 * "\033[2m" is the escape sequence for Faint characters in most Command Line Interface
	 * "\033[3m" is the escape sequence for Italic characters in most Command Line Interface
	 * "\033[4m" is the escape sequence for Underlined characters in most Command Line Interface
	 *////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// Function that returns a text in a Bolded format
	public static String boldText(String stringToBold) {
		 return "\033[1m" + stringToBold + "\033[0m";
	}
	
	// Function that returns a text in a Italic format
	public static String italicText(String stringToBold) {
		 return "\033[3m" + stringToBold + "\033[0m";
	}
	
	// Function that returns a text in a Underlined format
	public static String underlineText(String stringToBold) {
		 return "\033[4m" + stringToBold + "\033[0m";
	}

}
