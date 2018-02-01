package com.bridgelabz.programs;

import java.util.Scanner;

/**
 * To taking user input in celsius/fahrenheit and convert into celsius/fahrenheit.
 *
 */
public class TempConversion{

	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("press 1 To Convert Celsius To Fahrenheit :");
		System.out.println("press 2 To Convert Fahrenheit  To Celsius :");
		int choice = sc.nextInt();
		
		switch(choice) {
			
		case 1:
				System.out.println("Enter a temperature in Celsius :");
				double temp = sc.nextDouble();
				double ans = (temp*9/5)+32;
				System.out.println("Temp in Fahrenheit is :"+ans);
			break;
		case 2:
				System.out.println("Enter a temperature in Fahrenheit :");
				double temp1 = sc.nextDouble();
				double ans1 =  (temp1-32)*5/9;
				System.out.println("Temp in Celsius is :"+ans1);
			break;
		default :
			System.out.println("Enter correct choice..");	
		}
	}
}
