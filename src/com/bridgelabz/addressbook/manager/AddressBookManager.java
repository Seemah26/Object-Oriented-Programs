package com.bridgelabz.addressbook.manager;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

public interface AddressBookManager {
    public void addPerson(String firstName, String lastName, Long zipCode, Long phoneNumber, String city, String state, String address);
    public void removePerson(String name);
    public void sortByLastName();
    public void sortByZipCode();
    public void writeFile();
    public void fileRead() throws FileNotFoundException, IOException, ParseException;
}