package com.bridgelabz.programs;
import java.util.Scanner;

/**
 * to multiply num by changing denominator each time
 * @author bridgeit
 *
 */
public class HarmonicNum{

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a length of series");
		int length =sc.nextInt();
		float sum=0;
		for(int i=1;i<=length;i++){
				sum=sum+(1/(float)i);
			System.out.print(" 1/"+i+" +");	
		}
		System.out.println(" ");
		System.out.println("Series Addition is "+sum);
	}
}
