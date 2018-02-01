package com.bridgelabz.programs;

import java.util.Scanner;

/**
 * to calculate power of 2 which <2^N
 * @author bridgeit
 *
 */
public class Power{

	public static void main(String []args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Value Of N");
		int N = sc.nextInt();
		int ans=1;
		if(N>0 && N<31){
			for(int i=1;i<=N;i++) {
			
				ans = ans*2;
				System.out.println("2^"+i+" is "+ans);
			}
		}
		else {
			System.out.println("Enter N between 0-31");
		}
	}
	
}
