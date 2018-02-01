package com.bridgelabz.programs;
import java.util.Scanner;

/**
 *To calculate two roots by taking user input
 *
 */
public class Quadratic{

	public static void main(String []args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter value of a :");
		double a = sc.nextDouble();
		System.out.println("Enter value of b :");
		double b = sc.nextDouble();
		System.out.println("Enter value of c :");
		double c = sc.nextDouble();
		
		double delta = (b*b)-(4*a*c);
		System.out.println(delta);
		double X1 = (-b+Math.sqrt(delta)/(2*a));
		double X2 = (-b-Math.sqrt(delta)/(2*a));
		
		System.out.println("Root 1 of X :"+X1);
		System.out.println("Root 2 of X :"+X2);
	}
}
