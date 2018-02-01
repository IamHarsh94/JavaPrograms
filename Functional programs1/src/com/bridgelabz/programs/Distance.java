package com.bridgelabz.programs;
import java.util.Scanner;

/**
 * to take command line arguments x and y and calculate distance by  sqrt(x*x + y*y)
 * @author bridgeit
 *
 */
public class Distance{

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a value of X :");
		int X =sc.nextInt();
		System.out.println("Enter value of Y :");
		int Y =sc.nextInt();
		
		double ans = Math.sqrt(Math.pow(X,2) + Math.pow(Y,2));
		System.out.println("Ans is "+ans);
	}
}
