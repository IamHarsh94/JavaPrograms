package com.bridgelabz.programs;

import java.util.*;
/**
 * to calculate distinct random num and total random num we need to generate
 * @author bridgeit
 *
 */
public class CouponNum{

	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many Distinct num you want to generate :");
		int max = sc.nextInt();
		int distinct=0;
		int count=0;
		Random rn = new Random();
		double arr[] = new double[max];
		double arr1[] = new double[max+5];
		int j=0,k=0,flag =0;
	try {	
			while(distinct<max) {
	
	
			double rand	 = rn.nextInt(max+1);
			count++;
			if(!isContain(arr,max,rand)) {
			
				arr[j++]=rand;
				distinct++;
			}
			else {
				System.out.println("num "+rand);
				arr1[k++]=rand;
				
			}
			
		}
			System.out.println(count+" rand num we need to generate");
			for(int m=0;m<arr1.length;m++) {
				System.out.print(arr1[m]+",");
			}
			System.out.println(" ");
			System.out.println("Distinct num are :");
			for(int i=0;i<max;i++) {
				System.out.println(arr[i]);
			}
			flag =flag+1;
	}catch(Exception e) {
			if(flag==0) {
				System.out.println(count+" rand num we need to generate");
				for(int m=0;m<arr1.length;m++) {
					System.out.print(arr1[m]+",");
				}
				System.out.println(" ");
				System.out.println("Distinct num are :");
				for(int i=0;i<max;i++) {
					System.out.println(arr[i]);
				}
			}
			else {
				System.out.println("");
			}
		}	
	}
	/**
	 * To check the num is present in arr[] or not.
	 */
	private static boolean isContain(double arr[],int max,double rand) {
		
			for(int i=0;i<max;i++) {
				if(arr[i]==rand) {
					return true;
				}
			}
		return false;
	}
}
