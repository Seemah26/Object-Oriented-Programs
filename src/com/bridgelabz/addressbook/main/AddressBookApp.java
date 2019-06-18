package com.bridgelabz.addressbook.main;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.implementation.AddressBookImplementation;
import com.bridgelabz.addressbook.manager.AddressBookManager;
import com.bridgelabz.util.Util;

public class AddressBookApp {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		AddressBookManager details = new AddressBookImplementation();

		details.fileRead();
		System.out.println(
				"Enter  \n"
				+ " 1--> To add person\n 2--> To remove person\n 3--> TO Sort by last name\n 4--> To sort by zipcode");
		int input = Util.getInt();
		switch (input) {
		case 1: {
			System.out.println("Enter first name : ");
			String firstName = Util.getString();
			System.out.println("Enter last name : ");
			String lastName = Util.getString();
			System.out.println("Enter address : ");
			String address = Util.getString();
			System.out.println("Enter city name : ");
			String city = Util.getString();
			System.out.println("Enter state name : ");
			String state = Util.getString();
			System.out.println("Enter phone number : ");
			Long phoneNumber = Util.getLong();
			System.out.println("Enter zipcode : ");
			Long zipCode = Util.getLong();
			details.addPerson(firstName,lastName,zipCode,phoneNumber,city,state,address);
			details.writeFile();
			break;
		}
		case 2: {
			System.out.println("Enter name to be removed :");
			String removeName =Util.getString();
			details.removePerson(removeName);
			break;
		}
		case 3: {
			details.sortByLastName();
			break;
		}
		case 4: {
			details.sortByZipCode();
			break;
		}
		default:
			break;
		}
	}
}