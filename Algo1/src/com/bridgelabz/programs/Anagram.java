package com.bridgelabz.programs;
import java.util.Arrays;
import java.util.Scanner;

import com.bridgelabz.util.Utility;

public class Anagram {

	
	public static void main(String []args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter 1st string :");
		String str1 = sc.nextLine();
		System.out.println("Enter 2nd string :");
		String str2 = sc.nextLine();
		boolean flag =Utility.permutations(str1,str2);
		if(flag) {
			 System.out.println("Strings are anagram..");
		 
		 }	 
		 else {
			 System.out.println("String are not anagram..");
		 
		 }
	}
}
