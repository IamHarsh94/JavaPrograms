package com.bridgelabz.programs;

import java.util.Scanner;

/**
 * @author To conver decimal num to binary and check num is power of 2 or not.
 *
 */
public class ToBinary {
	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Decimal num :");
		int num = sc.nextInt();
		
		String binary = Integer.toBinaryString(num);
		System.out.println("Binary is :"+binary);
		int a = Integer.parseInt(binary);
		int j=1;
		int deci=0;
		int rem =1;
		while(a>0) {
			  rem=a%10;
			  deci=deci+rem*j;
			  j =j*2;
			  a =a/10;
		}
		char ch[] = binary.toCharArray();
		int count=0;
		int sum =0;
		for(int i=ch.length-1;i>=0;i--){
			if(ch[i]=='1') {
				System.out.print(sum+(int)(Math.pow(2, count))+"+");
				sum = sum+(int)(Math.pow(2, count));
			}
			count++;
		}
		System.out.println(" sum is :"+sum);
		if(sum==num) {
			System.out.println("power of 2");
		}
		else {
			System.out.println("Not power of 2");
		}
	}
	
	
}