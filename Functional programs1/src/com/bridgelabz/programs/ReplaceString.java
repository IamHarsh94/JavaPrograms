package com.bridgelabz.programs;
import java.util.*;


public class ReplaceString{

	/**
	 * To concatinate str with default string
	 * @param str User input string
	 */
	public static void replace(String str) {
		
		System.out.println("Hello "+str+", How are you?");
	}
	
	public static void main(String[]args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Name");
		String name = sc.nextLine();
		
		if(name.length()<3) {
			
			System.out.println("Name should have min 3 char");
		}else {
			
			ReplaceString.replace(name);
		}
	}
}
