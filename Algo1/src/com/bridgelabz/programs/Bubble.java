package com.bridgelabz.programs;

import java.util.Scanner;

/**
 * To sort an arr[] using bubble sort.
 *
 */
public class Bubble{

	public static void main(String []args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of array");
		int size= sc.nextInt();
		int arr[] = new int[size];
		
		System.out.println("Enter the element to sort");
		
		for(int i=0;i<size;i++) {
			arr[i]=sc.nextInt();
		}
		
		for(int i=0;i<size-1;i++) {
			int flag = 0;
			for(int j=0;j<size-1;j++) {
				
				if(arr[j]>arr[j+1]) {
					flag = flag+1;
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
			if(flag==0) {
				break;
			}
		}
		
		System.out.println("After sort");
		
		for(int i=0;i<size;i++) {
			System.out.println(" "+arr[i]);
		}
	}
}
