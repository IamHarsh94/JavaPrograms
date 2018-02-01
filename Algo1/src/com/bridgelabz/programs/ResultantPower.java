package com.bridgelabz.programs;

import java.util.Scanner;

public class ResultantPower{

	public static void main(String []args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Decimal num :");
		int num = sc.nextInt();
		String binary = Integer.toBinaryString(num);
		System.out.println("Binary num is :"+binary);
		
		char binNum[] = binary.toCharArray();
		char zero[] = new char[8];
	
				for(int i=0;i<=7;){
					zero[i++] = '0';
				}
		int l1 =zero.length-1;		
		for(int i = binNum.length-1;i>=0;i--) {
			zero[l1--] = binNum[i];
		}
		System.out.println("Represented in 8 byte :");
		System.out.println(zero);
		int first=0;
		int last = zero.length -1;
		int mid =0;
		if((first+last)%2==0) {
			mid = (first+last)/2;
		}
		else {
			mid = 1+(first+last)/2;
		}
		while(mid<=last) {
				
			char temp = zero[mid];
			zero[mid] = zero[first];
			zero[first]=temp;
			first++;
			mid++;
		}
		System.out.println("After Swapping num is:");
		System.out.println(zero);
		
		int a = Integer.parseInt(new String(zero));
		int rem =0;
		int deci =0;
		int i=1;
		
		while(a>0) {
		
			rem=a%10;
			deci=deci+rem*i;
			i=i*2;
			a =a/10;
		}
		System.out.println("Decimal of num After Swapping is : "+deci);
	}	
}