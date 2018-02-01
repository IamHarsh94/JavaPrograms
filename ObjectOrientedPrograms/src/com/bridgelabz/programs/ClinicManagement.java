package com.bridgelabz.programs;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.bridgelabz.util.ClinicManagementMethods;

public class ClinicManagement {
	public static Scanner sc =new Scanner(System.in);
	public static void main(String args[]) throws IOException, ParseException {
		ClinicManagementMethods clinicMethods = new ClinicManagementMethods();
		
		char ch;
		System.out.println("Enter your choice :");
		do {
			System.out.println("1:Add doctor ,2:Add patient ,3:Take Appointment ,4:Search");
			int choice = sc.nextInt();
			
			switch(choice) {
				
				case 1:clinicMethods.addDoctor(); 
					break;
				case 2:clinicMethods.addPatient();
					break;
				case 3:clinicMethods.appointment();
					break;
				case 4:clinicMethods.search();
					break;	
				default :
					System.out.println("Enter correct choice please...");
			}	
			System.out.println("");
			System.out.println("Do you want to continue press Y/N");
			ch = sc.next().charAt(0);
			
		}while(ch=='y'||ch=='Y');
			
		}
}
	

