/*
 * ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
 * Description:
 * This file is a class file of the package 'helpfulFunction' for the project 'Izi Management Software'. It is a Class created to 
 * facilitate the storage of an address
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

public class Address {
	
	// Variables that are the fields that usually makes up an address
	private String street;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    
    // Default value for the fields of an address
    static private String defaultStreet = "[No Street Provided]";
    static private String defaultCity = "[No City Provided]";
    static private String defaultState = "[No State Provided]";
    static private String defaultPostalCode = "[No Postal Code Provided]";
    static private String defaultCountry = "[No Country Provided]";

    /******************************** Getters and Setters for the variables of the class **********************************/
	    
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
	//______________________________________________________________________________________________________________________

	/*********************************** Overloaded Constructors for the abstract class ***********************************/
	
	//------------------------------------------ Main Constructor for the Class --------------------------------------------

    public Address(String street, String city, String state, String postalCode, String country) {
    	
    	// Assigning value to the field street if it's not empty
    	if(street != null && street.length() > 0) {
    		this.street = street;
    	}
		else {
			this.street = defaultStreet;
		}
    	
    	// Assigning value to the field city if it's not empty
    	if(city != null && city.length() > 0) {
    		this.city = city;
    	}
		else {
			this.city = defaultCity;
		}
    	
    	// Assigning value to the field state if it's not empty
    	if(state != null && state.length() > 0) {
    		this.state = state;
    	}
		else {
			this.state = defaultState;
		}

    	// Assigning value to the field postalCode if it's not empty
    	if(postalCode != null && postalCode.length() > 0) {
    		this.postalCode = postalCode;
    	}
		else {
			this.postalCode = defaultPostalCode;
		}
    	
    	// Assigning value to the field country if it's not empty
    	if(country != null && country.length() > 0) {
    		this.country = country;
    	}
		else {
			this.country = defaultCountry;
		}
    }
	//______________________________________________________________________________________________________________________

	//--------------- Constructors that calls the main constructor and pass default values for empty fields ----------------
	
    public Address(String street, String city, String state, String postalCode) {
        this(street, city, state, postalCode, defaultCountry);
    }
    public Address(String street, String city, String state) {
        this(street, city, state, defaultPostalCode, defaultCountry);
    }
    public Address(String street, String city) {
        this(street, city, defaultState, defaultPostalCode, defaultCountry);
    }
    public Address(String street) {
        this(street, defaultCity, defaultState, defaultPostalCode, defaultCountry);
    }
    public Address() {
        this(defaultStreet, defaultCity, defaultState, defaultPostalCode, defaultCountry);
    }
    //______________________________________________________________________________________________________________________

	
  	/****************************************** Functions for the Address class *******************************************/
    public String printFields() {
    	return String.format("Street: %s; City: %s; State: %s; PostalCode: %s; Country: %s;", 
    			street, city, state, postalCode, country);
    }
    
    public static Address parseAddressFromString(String input) {
        String street = Input.extractValue(input, "Street", ':', ';');
        String city = Input.extractValue(input, "City", ':', ';');
        String state = Input.extractValue(input, "State", ':', ';');
        String postalCode = Input.extractValue(input, "PostalCode", ':', ';');
        String country = Input.extractValue(input, "Country", ':', ';');

        return new Address(street, city, state, postalCode, country);
    }
    
    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + postalCode + ", " + country;
    }
}

