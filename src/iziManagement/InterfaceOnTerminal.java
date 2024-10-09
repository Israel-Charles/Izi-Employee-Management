/*
 * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * Description:
 * This file is a class file of the package 'iziManagement' for the project 'Izi Management Software'. It is the Class that holds 
 * the necessary functions to run the program on the Command Line Interface
 * 
 * File Name: 				InterfaceOnTerminal.java
 * File Version:            1.0
 * File Author:				Israel Charles
 * Created On:          	12/15/2023
 * Last Modification On:    12/25/2023
 * Last Modification By:  	Israel Charles
 * 
 * Parent Project:          Izi Management Software
 * Parent Package:			iziManagement
 * Project Folder Name:		IziManagementProject
 * Parent Main File:		SetupAndRun.java
 * Project Version:         1.0
 * 
 *////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package iziManagement;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import helpfulFunctionsPckg.Input;
import helpfulFunctionsPckg.TerminalStringFormat;

public abstract class InterfaceOnTerminal extends TerminalStringFormat{
	
	// Variables used for the menu options of the program
	static final String menuTitle = "- Main Menu -\n";
	static final String menuInstruction = "\n(To select an option, type the number or character in front of it and press 'Enter')\n\n";
	static final String timeTracking = "1 - Time Tracking\n";
	static final String registerEmployee = "2 - Register an Employee/Volunteer\n";
	static final String modifyEmployee = "3 - Modify an Employee/Volunteer\n";
	static final String removeEmployee = "4 - Remove an Employee/Volunteer\n";
	static final String generatePayStub = "5 - Generate Pay Stubs\n";
	static final String generateReport = "6 - Generate Reports\n";
	static final String printCompany = "C - Output Company Info and Preference\n";
	static final String modifyCompany = "P - Modify Company Info and Preference\n";
	static final String exitProgram = "Z - Exit Program\n";
	
	static final String returnInstruction = "\n(Type 'X' and press 'Enter' to return to the main menu)";
	
	// Function that runs the program on the Command Line Interface
	public static void run() {
			
		// Opening and verifying the configuration file; or create one if it does not exist
		try {
			SetupAndRun.configFile = new File(SetupAndRun.configFileName);
			if (SetupAndRun.configFile.createNewFile() || (!(SetupAndRun.isConfFileValid()))) {
				configureCompany();
			}

			// Running the software
			CompanyInfo.getCompanyInfoFromFile();
			
			// Outputting the main menu
			mainMenu();
			
		}catch(IOException e) {
			System.err.println(e + Input.fileError);
			e.printStackTrace();
		}
	}
	
	// Function that output the main menu on the terminal
	public static void mainMenu() {
		int userInput = getUserChoice(new String[] {"1", "2", "3", "4", "5", "6", "C", "P", "Z"}, menuToString());

		// Actions based on options selected
		switch (userInput) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			outputCompanyInfo();
			break;
		case 8:
			modifyComopanyInfo();
			break;
		case 9:
			break;
		}
	}
	
	// Function to output the information of the company this program is set up for
	public static void outputCompanyInfo() {
		System.out.println(boldText(CompanyInfo.printInString()));
		System.out.println(boldText("\n\t" + underlineText("Preferences\n")) 
				+ boldText("Data Location: " + CompanyInfo.getDataLocation()));
		System.out.println(italicText(returnInstruction));
		int userInput = getUserChoice(new String[] {"X"}, "");
		
		if(userInput == 1) {
			mainMenu();
		}
		
	}
	
	// Function that modify the information of the company this program is set up for
		public static void modifyComopanyInfo() {
			final String instruction = centerText(boldText("\n- Modify Company Info -\n"), 100)
					+ CompanyInfo.printInString()
					+ "\n\n\t" + underlineText("Preferences\n") 
					+ "Data Location: " + CompanyInfo.getDataLocation()
					+ boldText("\n\nWhat information of the Company would you like to modify?\n")
					+ italicText(menuInstruction)
					+ "1 - Name\n"
					+ "2 - Address\n"
					+ "3 - Phone Number\n"
					+ "4 - Email Address\n"
					+ "R - Reconfigure all information and preferences of the company\n"
					+ italicText(returnInstruction) + "\n";
			
			int userInput = getUserChoice(new String[] {"1", "2", "3", "4", "R", "X"}, instruction);

			// Actions based on options selected
			switch (userInput) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				mainMenu();
				break;
			}
		}
	
	// Function that returns the main menu in the form of one string
	public static String menuToString() {
		return "----------------------------------------------------------------------------------------------------\n\n" 
				+ centerText(boldText(menuTitle), 100) + italicText(menuInstruction) + timeTracking + registerEmployee 
				+ modifyEmployee + removeEmployee + generatePayStub + generateReport + printCompany + modifyCompany + exitProgram;
	}
	
	// Function that configure the program to a specific Company
		public static void configureCompany() {
			
			// Variables that hold text instruction for the program
			final String setupText = "To set up the Management Software, enter the following Company Info";
			final String confirmInfo = "Whould you like to continue with the following information for the company? (Yes or No)";
			final String dataInstruction = "Enter '1' if you would like to save future data Locally or Enter '2' if you would like to "
					+ "save future data on a mySQL Server.";
			
			// Outputing instruction in italic for the user to enter information related to the Company 
			System.out.println(italicText(setupText));
			System.out.println();

			// Function from the 'CompanyInfo' class that takes input from user to configure information related to the Company
			CompanyInfo.setCompanyInfo();

			// Creating an array of options to pass it, along with instructions, to a function that allow users to make a selection
			String[] userChoices = {"Yes", "No"};

			int userInput = -1;								// Default value for the variable that holds the User Input
			
			// Loop to allow user to re-enter info for the company just in case there was a mistake entered
			do{
				// Obtaining user choice, from the function that allow user to make selection, where '1' is 'Yes' and '2' is 'No'
				userInput = getUserChoice(userChoices, italicText(confirmInfo) + "\n\n" + boldText(CompanyInfo.printInString()) + "\n");
				
				// Make user re-enter info if the answered 'No' to the confirmation request
				if (userInput == 2) {
					System.out.println();
					CompanyInfo.setCompanyInfo();
				}
			}while (userInput != 1);						// Loop until user answer 'yes' to the confirmation message
			
			// Saving the Company Info locally on the configuration file
			try {
				PrintWriter writeToConfigFile = new PrintWriter(SetupAndRun.configFileName);
				
				// Creating a date format to save the date and time of the file creation
				Date date = new Date();
				
				// Writing to the configuration file
				writeToConfigFile.println(SetupAndRun.deleteWarning);
				writeToConfigFile.println(SetupAndRun.dateFormat.format(date));
				writeToConfigFile.println("{");
				writeToConfigFile.printf("\tName: %s\n", CompanyInfo.getName());
				writeToConfigFile.printf("\tAddress: {%s}\n", CompanyInfo.getAddress().printFields());
				writeToConfigFile.printf("\tPhone: %s\n", CompanyInfo.getPhoneNumber());
				writeToConfigFile.printf("\tEmail: %s\n", CompanyInfo.getEmailAddress());
				writeToConfigFile.println("}");

				userInput = -1;									// Reassigning default value to the User Input Variable
				
				// Passing an array of options, along with instructions, to a function that allow users to make a selection
				userInput = getUserChoice(new String[] {"1", "2"}, italicText(dataInstruction) + "\n");
				
				if (userInput == 1) {
					writeToConfigFile.println("Data Preference: Local");
				}
				else if (userInput == 2) {
					writeToConfigFile.println("Data Preference: MySQL");
				}
				
				writeToConfigFile.close();
			}catch(IOException e) {
				System.err.println(e + Input.fileError);
				e.printStackTrace();
			}
			
		}
	

}