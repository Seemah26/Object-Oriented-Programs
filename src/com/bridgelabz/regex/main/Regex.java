package com.bridgelabz.regex.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.bridgelabz.regex.implementation.RegexImplementation;
import com.bridgelabz.util.Util;

public class Regex {

	public static void main(String[] args) throws FileNotFoundException {
		RegexImplementation data = new RegexImplementation();
		FileReader f = new FileReader("C:\\Users\\RDRL\\Desktop\\seema\\regex.txt");
		@SuppressWarnings("resource")

		BufferedReader read = new BufferedReader(f);
		String line = "";
		String word = "";
		try {
			while ((word = read.readLine()) != null) {
				line = word;
			}
			System.out.println(line);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Please enter the first name");
		String firstName = Util.getString();
		System.out.println("Please enter the last name");
		String lastName = Util.getString();
		String fullName = firstName + " " + lastName;
		System.out.println("Please enter your 10 digit phone number");
		String phoneNum = Util.getString();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String formattedDate = dateFormat.format(date);

		String message = data.replace(firstName, fullName, phoneNum, formattedDate, line);

		System.out.println(message);
	}
}