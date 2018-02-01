package com.bridgelabz.programs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class RegularExpression {

	private static Scanner scanner = new Scanner(System.in);
	private static String[] pattern = { "<full name>", "<name>", "xxxxxxxxxx", "01/01/2016" };
	private static String[] replacePattern = new String[pattern.length];
	private static String message = "Hello <name>, We have your fullname as <full name> in our system. "
			+ "Your contact number is 91-xxxxxxxxxx. " + "Please,let us know in case of any clarification "
			+ "Thankyou BridgeLabz 27/01/2018.";

	public static void main(String args[]) {
		
		
		
		Date dt = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("DD/MM/YY");
		String str = formate.format(dt);
		System.out.println(str);
		
		
	}
}
