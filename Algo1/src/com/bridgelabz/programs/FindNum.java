package com.bridgelabz.programs;


import java.util.Scanner;

/**
 * To find a user guessing number using binary search.
 *
 */
public class FindNum{


	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter a num for range");
		
		int N = (int) Math.pow(2,sc.nextInt());
		int range = N-1;
		System.out.println("Think num between "+0+" to "+range);
		
		int low=0;
		int high=range;
		int mid = (low+high)/2;
		while(low!=mid) {
			
			
			System.out.println("Is your num present in "+low+" To "+mid+" Enter True or False");
			boolean flag =sc.nextBoolean(); 
			if(flag==true) {
				
				high = mid;
				mid = (low+high)/2;
			}
			else if(flag==false) {
			
				low = mid;
				mid = (low+high)/2;
			}
		}
		System.out.println("Whis one is our num "+low+" or "+high);
		int ans = sc.nextInt();
		System.out.println("Your Num is "+ans);
		}
	
	
}
