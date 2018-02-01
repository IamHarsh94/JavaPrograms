package com.bridgelabz.programs;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.bridgelabz.util.BooksOperations;

public class AddressBook {
	public static Scanner sc = new Scanner(System.in);
		public static void main(String args[]) throws IOException, ParseException {
			BooksOperations operate = new BooksOperations();
			char ch;	
			do {
				System.out.println("1:Add address, 2:Edit information, 3:Delete person details 4:Sort data");
				int choice = sc.nextInt();
				
				switch(choice) {
					case 1:operate.addAdress();
						break;
					case 2:operate.edit();
						break;
					case 3:operate.delete();
						break;
					case 4:operate.sortData();
						break;
					default:
				}	
					System.out.println("Do you want to continue..Press Y/N ");
					ch =sc.next().charAt(0);
					
				}while(ch=='y'||ch=='Y');
		
			}
	
}