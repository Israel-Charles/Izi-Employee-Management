/*
 * //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * Project:          		Izi Management Software
 * Project Folder Name:		IziManagementProject
 * Main File:				SetupAndRun.java
 * Version:             	1.0
 * 
 * Project Author:     		Israel Charles
 * Created On:          	12/15/2023
 * 
 * Last Modification On:    12/25/2023
 * Last Modification By:  	Israel Charles
 * //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

Description:
This program is a Employee Management Software.

*////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
package iziManagement;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.*;


// External Packages and classes created for the program
import helpfulFunctionsPckg.TerminalStringFormat;

public class SetupAndRun extends TerminalStringFormat{

	// Variables related to the configuration file of the program
	static final String configFileName = "configurationFile.conf";
	static File configFile;
	static final String deleteWarning = "**** DO NOT DELETE OR MODIFY THIS FILE - DOING SO MIGHT RESET THE PROGRAM ****";
	
	// ***** WARNING: MODIFYING THE DATE FORMAT MUST ALSO APPROPRIATELY MODIFY ITS REGULAR EXPRESSION PATTERN *****
	static final DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy - HH:mm:ss - z");
	static final String dateFormatRegex = "\\d{2}/\\d{2}/\\d{4} - \\d{2}:\\d{2}:\\d{2} - .+";

	//_____________________________________________________________________________________________________________

	//----------------------------------------------------- MAIN FUNCTION -------------------------------------------------------
	public static void main(String[] args) {
		
		// Variables that hold text instruction for the program
		final String WelcomeText = "Welcome to Izi Management Software!";
		final String ProgramEnvironmentText = "Press '1' then 'Enter' to continue the program on the Command Line Interface\n"
				+ "Press '2' then 'Enter' to continue the program on your Web Browser\n"
				+ "Press '3' then 'Enter' to continue the program on a local Graphical Interface (typical Apps)\n";

		// Output the welcome text centered, boxed, and bolded 
		System.out.println(boldText(centerText(boxLine(WelcomeText, "*"), 100)));
		System.out.println();
		
		InterfaceOnTerminal.run();

		/*
		// Creating an array of options and pass it, along with instructions, to a function that allow users to make a selection
		String[] userChoices = {"1", "2", "3"};
		int userChoice = getUserChoice(userChoices, ProgramEnvironmentText);
		
		// Program continuation based on the user's choice
		if (userChoice == 1) {
			InterfaceOnTerminal.run();
		}
		else if (userChoice == 2) {
			programOnWeb();
		}
		else if (userChoice == 3) {
			programOnGUI();
		}
		*/
	}
	//___________________________________________________________________________________________________________________________
	
	
	//--------------------------------------------------- SUPPORT FUNCTIONS -----------------------------------------------------
	
	// Function that runs the program as a web based Program on the default browser
	public static void programOnWeb() {
		try {
            Desktop.getDesktop().browse(new URI("https://www.google.com"));
            System.out.println("Opening Google...");
        } catch (IOException | URISyntaxException e) {
            System.out.println("Error opening Google: " + e.getMessage());
        }
	}
	
	// Function that runs the program as Java Swing GUI
	public static void programOnGUI() {
		
	}
	
	// Function to check if the configuration file is in the right format
	public static boolean isConfFileValid() {
		
		boolean isValid = true;
		int fileNumOfLines = 9;
		
		// Creating Regular Expression patterns
		String nameRegex = "[\t]Name: .+";
		String addressRegex = "[\t]Address: .+";
		String phoneRegex = "[\t]Phone: .+";
		String emailRegex = "[\t]Email: .+";
		String dataRegex = "Data Preference: .+";


		// Creating an array of lines for the text in the configuration file
		String[] configFileLines = readTextFileToArray(configFileName);
		
		// Check if file has the appropriate number of lines
		if (configFileLines.length != fileNumOfLines) {
			isValid = false;
		}
		
		// Check each line for its appropriate format
		else if (configFileLines[0].compareTo(deleteWarning) != 0) {
			isValid = false;
		}
		else if (!(configFileLines[1].matches(dateFormatRegex))) {
			isValid = false;
		}
		else if (configFileLines[2].compareTo("{") != 0) {
			isValid = false;
		}
		else if (!(configFileLines[3].matches(nameRegex))) {
			isValid = false;
		}
		else if (!(configFileLines[4].matches(addressRegex))) {
			isValid = false;
		}
		else if (!(configFileLines[5].matches(phoneRegex))) {
			isValid = false;
		}
		else if (!(configFileLines[6].matches(emailRegex))) {
			isValid = false;
		}
		else if (configFileLines[7].compareTo("}") != 0) {
			isValid = false;
		}
		else if (!(configFileLines[8].matches(dataRegex))) {
			isValid = false;
		}
		
		return isValid;
	}

}
