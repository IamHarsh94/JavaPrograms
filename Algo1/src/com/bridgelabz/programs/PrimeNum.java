package com.bridgelabz.programs;
import java.util.Scanner;

import com.bridgelabz.util.Utility;

/**
 * @author To check prime num between 1 to 1000.
 *
 */
public class PrimeNum{

	public static void main(String []args) {
				
		Scanner sc =new Scanner(System.in);
		System.out.println("Prime num. between 1 to 1000 :");
	
		for(int i=1;i<=1000;i++) {
			int count=0;
				for(int j=1;j<=i;j++) {
					if(i%j==0) {
						count++;
						
					}
				}
				if(count==2) {
					System.out.println(i);
				}
		}
		Utility.numPalindrom();
	}
	
}