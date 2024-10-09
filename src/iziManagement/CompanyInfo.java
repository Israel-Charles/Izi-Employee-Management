/*
 * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * Description:
 * This file is a class file of the package 'iziManagement' for the project 'Izi Management Software'. It is the Class that holds 
 * the basic information of the Company that this program is set up for.
 * 
 * File Name: 				CompanyInfo.java
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
 * Project Version:             	1.0
 * 
 *////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

package iziManagement;

//External Packages and classes for the program and imported for this file
import helpfulFunctionsPckg.*;

// Abstract class that holds information about the company to set up the program for
public abstract class CompanyInfo extends TerminalStringFormat{
	
	// Variables for the class
	static private String name;
	static private Address address;
    static private String phoneNumber;
    static private String emailAddress;
    
    // Variable that holds preferences for the program
    static private String dataLocation;
    
    // Default values for the variables of the class
    static private String defaultName = "[No Name provided]";
    static private Address defaultAddress = new Address();
    static private String defaultPhoneNumber = "[No Phone Number provided]";
    static private String defaultEmailAddress = "[No Email Address provided]";

	// Variables that hold text instruction for the program
	static private String addressInstruction = "(Enter Address in the format \"[Street], [City], [State], [Zip Code], [Country]\")";

	/*************************** Getters and Overloaded Setters for the variables of the class ****************************/
	
	//------------------------------------------------------ Name ----------------------------------------------------------
    public static String getName() {
		return name;
	}
	public static void setName(String name) {
		CompanyInfo.name = name;
	}
	public static void setName() {
		// Output field label in bold
		System.out.print(boldText("Company Name:\t\t"));
		String name = readLineKeyboard().trim();
		if(name != null && name.length() > 0) {
			setName(name);
		}
		else {
			setName(defaultName);
		}
		
	}
	//______________________________________________________________________________________________________________________
	
	//----------------------------------------------------- Address --------------------------------------------------------
	public static Address getAddress() {
		return address;
	}
	public static void setAddress(Address address) {
		CompanyInfo.address = address;
	}
	public static void setAddress() {
		String addressString = null;
		System.out.println();
		
		// Output field label in bold and instructions for the address in italic
		System.out.println(boldText("Company Address:"));
		System.out.print("\t" + italicText(addressInstruction + "\n\t\t\t"));
		
		addressString = readLineKeyboard();
		System.out.println();

		// Splitting the user input into multiple strings that will serve as the different fields of the address
		String[] addressArray = addressString.split(",");
		
		// Removing white space from fields
		for (int i = 0; i < addressArray.length; i++) {
			addressArray[i] = addressArray[i].trim();
		}
		
		// Calling the appropriate constructor based on number of fields inputed
		if (addressArray.length == 5) {
			setAddress(new Address(addressArray[0], addressArray[1], addressArray[2], addressArray[3], addressArray[4]));
		}
		else if (addressArray.length == 4) {
			setAddress(new Address(addressArray[0], addressArray[1], addressArray[2], addressArray[3]));
		}
		else if (addressArray.length == 3) {
			setAddress(new Address(addressArray[0], addressArray[1], addressArray[2]));
		}
		else if (addressArray.length == 2) {
			setAddress(new Address(addressArray[0], addressArray[1]));
		}
		else if (addressArray.length == 1) {
			setAddress(new Address(addressArray[0]));
		}	
	}
	//______________________________________________________________________________________________________________________

	//-------------------------------------------------- Phone Number ------------------------------------------------------
	public static String getPhoneNumber() {
		return phoneNumber;
	}
	public static void setPhoneNumber(String phoneNumber) {
		CompanyInfo.phoneNumber = phoneNumber;
	}
	public static void setPhoneNumber() {
		// Output field label in bold
		System.out.print(boldText("Company Phone Number:\t"));
		String phoneNumber = readLineKeyboard().trim();
		if(phoneNumber != null && phoneNumber.length() > 0) {
			setPhoneNumber(phoneNumber);
		}
		else {
			setPhoneNumber(defaultPhoneNumber);
		}
	}
	//______________________________________________________________________________________________________________________

	//-------------------------------------------------- Email Address -----------------------------------------------------
	public static String getEmailAddress() {
		return emailAddress;
	}
	public static void setEmailAddress(String emailAddress) {
		CompanyInfo.emailAddress = emailAddress;
	}
	public static void setEmailAddress() {
		// Output field label in bold
		System.out.print(boldText("Company Email Address:\t"));
		String emailAddress = readLineKeyboard().trim();
		if(emailAddress != null && emailAddress.length() > 0) {
			setEmailAddress(emailAddress);
		}
		else {
			setEmailAddress(defaultEmailAddress);
		}
	}
	//______________________________________________________________________________________________________________________
	
	//--------------------------------------------------- Preferences ------------------------------------------------------
	public static String getDataLocation() {
		return dataLocation;
	}
	public static void setDataLocation(String dataLocation) {
		CompanyInfo.dataLocation = dataLocation;
	}
	//______________________________________________________________________________________________________________________

	/*********************************** Overloaded Constructors for the abstract class ***********************************/
	
	//------------------------------------------ Main Constructor for the Class --------------------------------------------
	CompanyInfo(String name, Address address, String phoneNumber, String emailAddress){
		CompanyInfo.name = name;
		CompanyInfo.address = address;
		CompanyInfo.phoneNumber = phoneNumber;
		CompanyInfo.emailAddress = emailAddress;
	}
	//______________________________________________________________________________________________________________________

	//--------------- Constructors that calls the main constructor and pass default values for empty fields ----------------
	CompanyInfo(String name, Address address, String phoneNumber){
		this(name, address, phoneNumber, defaultEmailAddress);
	}
	CompanyInfo(String name, Address address){
		this(name, address, defaultPhoneNumber, defaultEmailAddress);
	}
	CompanyInfo(String name){
		this(name, defaultAddress, defaultPhoneNumber, defaultEmailAddress);
	}
	CompanyInfo(){
		this(defaultName, defaultAddress, defaultPhoneNumber, defaultEmailAddress);
	}
	//______________________________________________________________________________________________________________________

	
	/****************************************** Functions for the abstract class ******************************************/
	
	// Function that takes in userInput to set the variables of the class
	public static void setCompanyInfo() {
		setName();
		setAddress();
		setPhoneNumber();
		setEmailAddress();
	}
	
	// Function that gets company data from configuration file
	public static void getCompanyInfoFromFile() {
		String[] configFileLines = readTextFileToArray(SetupAndRun.configFileName);
		CompanyInfo.setName(configFileLines[3].substring("\tName: ".length()));
		CompanyInfo.setAddress(Address.parseAddressFromString(configFileLines[4]));
		CompanyInfo.setPhoneNumber(configFileLines[5].substring("\tPhone: ".length()));
		CompanyInfo.setEmailAddress(configFileLines[6].substring("\tEmail: ".length()));
		CompanyInfo.setDataLocation(configFileLines[8].substring("Data Preference: ".length()));
		
	}
	
	// Function that outputs all the fields in the class in the form of one bolded string
	public static String printInString() {
		return "Name:\t\t" + getName() + "\nAddress:\t" + getAddress() + 
				"\nPhone Number:\t" + getPhoneNumber() + "\nEmail Address:\t" + getEmailAddress();
	}
}
