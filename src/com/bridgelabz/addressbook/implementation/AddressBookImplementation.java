package com.bridgelabz.addressbook.implementation;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.addressbook.manager.AddressBookManager;
import com.bridgelabz.addressbook.model.Address;
import com.bridgelabz.util.Util;
import com.google.gson.Gson;

public class AddressBookImplementation implements AddressBookManager {

	JSONArray jsonArray;
	List<Address> addressList = new ArrayList<>();
	JSONObject jobject = new JSONObject();

	@Override
	public void fileRead() {
		JSONParser parser = new JSONParser();
		{
			try {
				jsonArray = (JSONArray) parser.parse(new FileReader(
						"D:\\javaproject\\Object Oriented Programs\\src\\com\\bridgelabz\\addressbook\\model\\AddressBook.json"));

				for (Object obj : jsonArray) {

					Address addressDetail = new Address();

					jobject = (JSONObject) obj;
					String firstName = (String) jobject.get("firstName");
					String lastName = (String) jobject.get("lastName");
					String city = (String) jobject.get("city");
					String address = (String) jobject.get("address");
					String state = (String) jobject.get("state");
					Long phoneNumber = (Long) jobject.get("phoneNumber");
					Long zipCode = ((Long) jobject.get("zipCode"));

					addressDetail.setFirstName(firstName);
					addressDetail.setLastName(lastName);
					addressDetail.setCity(city);
					addressDetail.setAddress(address);
					addressDetail.setState(state);
					addressDetail.setPhoneNumber(phoneNumber);
					addressDetail.setZipCode(zipCode);

					addressList.add(addressDetail);

				}
				System.out.println(jobject);
				System.out.println(addressList.toString());
			}

			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public void addPerson(String firstName, String lastName, Long zipCode, Long phoneNumber, String city, String state,
			String address) {
		Address address1 = new Address();
		address1.setFirstName(firstName);
		address1.setLastName(lastName);
		address1.setPhoneNumber(phoneNumber);
		address1.setCity(city);
		address1.setAddress(address);
		address1.setState(state);
		address1.setZipCode(zipCode);
		addressList.add(address1);
		addressList.forEach(details -> System.out.println(details.toString()));
	}

	@Override
	public void removePerson(String removeName) {
		addressList.removeIf(delete -> delete.getFirstName().equalsIgnoreCase(removeName));
		writeFile();
		System.out.println("Successfully removed elements from the list");
	}
	@Override
	public void sortByLastName() {
		addressList.sort((Address s1, Address s2) -> s1.getLastName().compareTo(s2.getLastName()));
		addressList.forEach(result -> System.out.println(result));
	}
	@Override
	public void sortByZipCode() {
		addressList.sort((Address s1, Address s2) -> s1.getZipCode().compareTo(s2.getZipCode()));
		addressList.forEach(details -> System.out.println(details));
	}
	@Override
	public void writeFile() {
		Gson gson = new Gson();
		String json =gson.toJson(addressList);
		try (FileWriter file = new FileWriter(
				"D:\\javaproject\\Object Oriented Programs\\src\\com\\bridgelabz\\commercialdataprocessing\\model\\StockApp.json")) {
			file.write(json);
			file.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}