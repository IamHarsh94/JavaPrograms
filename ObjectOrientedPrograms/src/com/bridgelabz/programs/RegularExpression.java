package com.bridgelabz.programs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.bridgelabz.util.Expression;
import com.bridgelabz.util.Utility;

public class RegularExpression {

	private static Scanner sc= new Scanner(System.in);
	private static String[] pattern = { "<full name>", "<name>", "xxxxxxxxxx", "01/01/2016" };
	private static String message = "Hello <name>,\nWe have your fullname as <full name> in our system. \n"
			+ "Your contact number is 91-xxxxxxxxxx. \n" + "Please,let us know in case of any clarification \n"
			+ "Thankyou BridgeLabz \n01/01/2016.";
	private static String[] replacePattern = new String[pattern.length];
	
	
	public static void main(String args[]) {
		int index=0;
		Expression exp = new Expression();
		System.out.println("Enter a full name:");
		String fullName = sc.nextLine();
		exp.setFullName(fullName);
		replacePattern[index++]=exp.getfullName();
		System.out.println("Enter name:");
		String name = sc.nextLine();
		exp.setName(name);
		replacePattern[index++]=exp.getName();
		System.out.println("Enter mobile no:");
		String mob = sc.nextLine();
		exp.setPhoneNumber(mob);
		replacePattern[index++]=exp.getPhoneNumber();
		Date dt = new Date();
		SimpleDateFormat sm =new SimpleDateFormat("DD/MM/YY");
		replacePattern[index++]=sm.format(dt);
		
		for(int i=0;i<pattern.length;i++) {
			message = Utility.replaceMent(message,pattern[i],replacePattern[i]);
		}
		System.out.println("");
		System.out.println(message);
	}
}
