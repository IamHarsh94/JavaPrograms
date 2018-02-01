package com.bridgelabz.programs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * to calculate unique factor of user num 
 * @author bridgeit
 *
 */
public class Factor{
	
			public static void main(String []args) {
				
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter Num");
				int N = sc.nextInt();
				ArrayList arr = new ArrayList();
				for(int i=2;i<N;i++) {
					
					if(N%i==0) {
						arr.add(i);
					}
				}
				System.out.println(arr);
			}
}




