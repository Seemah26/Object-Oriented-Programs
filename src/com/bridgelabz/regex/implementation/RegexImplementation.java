package com.bridgelabz.regex.implementation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexImplementation {
	public static String replace(String first, String fullName, String phoneNum, String date, String line) {
		final String REGEX_NAME ="<<name>>"; 
		final String REGEX_FULL_NAME ="<<full name>>";
		final String REGEX_CONTACT = "x{10}";
		final String REGEX_DATE = "<<01/01/2016>>";
		Pattern name = Pattern.compile(REGEX_NAME);
		Matcher match = name.matcher(line);
		line = match.replaceAll(first);

		Pattern  p2= Pattern.compile(REGEX_FULL_NAME);
		Matcher m2 = p2.matcher(line);
		line = m2.replaceAll(fullName);

		Pattern p3 = Pattern.compile(REGEX_CONTACT);
		Matcher m3 = p3.matcher(line);
		line = m3.replaceAll(phoneNum);

		Pattern p4 = Pattern.compile(REGEX_DATE);
		Matcher m4 = p4.matcher(line);
		line = m4.replaceAll(date);
		return line;
	}
}


