package com.bridgelabz.programs;

import java.util.*;

import com.bridgelabz.util.Utility;
/**
 * @author To calculate monthly Payment by passing loan,year and interest to Satndard formula. 
 *
 */
public class MonthPay{

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter value of Principal Loan Amount (P) :");
		double P = sc.nextDouble();
		System.out.println("Enter years (Y) :");
		double Y = sc.nextDouble();
		System.out.println("Enter monthly interest in percentage (R) :");
		double R = sc.nextDouble();
		
		System.out.println("Monthly Payment is : "+String.format("%.2f",(Utility.mothlyPayment(P,Y,R))));
	}
}	

	

