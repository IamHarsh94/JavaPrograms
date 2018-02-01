package com.bridgelabz.programs;

import java.util.*;
/**
 * to calculate leap year (year%100!=0)&&(year%400==0)||(year%4==0)
 * @author bridgeit
 *
 */
public class LeapYear{

	public static void main(String []args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a year");
		int year = sc.nextInt();
		
		if((year%100!=0)&&(year%400==0)||(year%4==0)) {
			System.out.println(year+" Is Leap Year");
		}
		else {
			System.out.println(year+" Is Not Leap Year");
		}
	}
	
}
