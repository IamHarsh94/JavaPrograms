package com.bridgelabz.programs;

import java.util.Scanner;

/**
 * To Print wind chill depends on user input using formula
 *
 */
public class WindChill{

	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Temperature :");
		double T = sc.nextDouble();
		System.out.println("Enter wind speed/hour :");
		double V = sc.nextInt();
	
		if((T<51) && (V<120||V>3)) {
			double ans = 35.74 + (0.6215*T) + ((0.4275*T)-35.75)*(Math.pow(V, 0.16));
			System.out.println("Wind chill is :"+ans);
		}
		else {
			System.out.println("Enter correct values...");
		}
		
	}
}
