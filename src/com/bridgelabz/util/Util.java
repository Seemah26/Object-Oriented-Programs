package com.bridgelabz.util;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Util {
	

	
		private static Scanner scanner=new Scanner(System.in);
		public static int getInt() {
			return scanner.nextInt();
		}
		
		public static double getDouble() {
			return scanner.nextDouble();
		}
		public static String getString() {
			return scanner.next();
		}
		public static Long getLong() {
			return scanner.nextLong();
		}
		
		public class FileOperation {

			public FileReader readFile(String path) {

				try {
					File file = new File(path);
					FileReader fileReader = new FileReader(file);
					return fileReader;
				} catch (IOException e) {
					e.printStackTrace();

				}
				return null;
			}

		}
		
		public static <T extends Comparable<T>> T[] bubble(T[] array) {
			for (int j = 0; j < array.length; j++) {
				for (int i = j + 1; i < array.length; i++) {
					// comparing strings
					if (array[i].compareTo(array[j]) < 0) {

						T temp = array[j];
						array[j] = array[i];
						array[i] = temp;
					}

				}
			}
			for (int k = 0; k < array.length; k++) {
				System.out.println(array[k]);
			}
			return array;

		}


}	