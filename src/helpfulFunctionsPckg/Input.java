/*
 * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * Description:
 * This file is a class file of the package 'helpfulFunction' for the project 'Izi Management Software'. It is an abstract Class that 
 * has functions to take inputs from the keyboard or from files.
 * 
 * This class is part of the package 'helpfulFunction'. The package 'helpfulFunction', created for this program, has classes and 
 * methods that can facilitate creating java program that takes in user input, especially from the Command Line Interface. 
 * 
 * File Name: 				Input.java
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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.io.IOException;


public abstract class Input {
	
	// Variables related to the Input Class
	public static final String fileError = " - It's possible that the program does not have appropriate access to read/write on disk";
	
	// Those symbols are printed out to indicate that the program is waiting for user input
	public static final String inputIndicator = "==> ";

	// Function to read a line from the user through the keyboard
	public static String readLineKeyboard() {
		
		String keyboardInput = null;
		
		// Variable of class BufferedReader that takes in characters pressed from the keyboard
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			// "\033[2m" is the escape sequence for Faint characters in most Command Line Interface
			System.out.print("\033[2m");
			
			keyboardInput = reader.readLine();		// taking in characters until "Enter" is pressed
			
			// "\033[0m" is the escape sequence to reset to the default format of characters in most Command Line Interface
			System.out.print("\033[0m");
		}
		catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
		return keyboardInput;
	}
	
	// Function that takes in instruction and available choices, then ask the user to make a choice and check if it's a valid choice
	// The function returns the (index + 1) of the choice from the available choices
	public static int getUserChoice(String[] availableChoices, String instructions) {
		
		// Initializing variables with default values
		int userChoice = -1;
		String userInput = null;
		boolean validInput = false;
		
		// Loop to ask the user for a choice until a valid choice is selected
		do {
			System.out.println();
			System.out.println(instructions);
			System.out.print(inputIndicator);
			userInput = readLineKeyboard();
			System.out.println();
			
			// Loop that compare the user response to the available choices
			for (int i = 0; i < availableChoices.length; i++) {
				if((userInput.compareToIgnoreCase(availableChoices[i])) == 0) {
					userChoice = i + 1;
					validInput = true;
					break;
				}
			}
			if (validInput == false) {
				System.out.println("Invalid Option");
			}
		}while(validInput == false);
		
		return userChoice;
	}
	
	// Function that opens a text file and create an array of lines for each line of a text file 
	public static String[] readTextFileToArray(String filePath) {
        ArrayList<String> linesList = new ArrayList<>();

        // Open the file for reading
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read each line and add it to the ArrayList
            while ((line = reader.readLine()) != null) {
                linesList.add(line);
            }
        } catch (IOException e) {
			System.err.println(e + fileError);
			e.printStackTrace();
		}

        // Convert the ArrayList to an array
        String[] linesArray = new String[linesList.size()];
        linesArray = linesList.toArray(linesArray);

        return linesArray;
    }
	
	// Function that extract a string from another string giving its keyword, start indication and end indication
	public static String extractValue(String input, String field, char startChar, char endChar) {
        String fieldStart = field + startChar;
        int startIndex = input.indexOf(fieldStart) + fieldStart.length();
        int endIndex = input.indexOf(endChar, startIndex);
        return input.substring(startIndex, endIndex).trim();
    }

}
