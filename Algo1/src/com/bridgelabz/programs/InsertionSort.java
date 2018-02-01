package com.bridgelabz.programs;


import java.util.Scanner;
/**
* To sort an arr[] using insertion sort
* by taking input in a int formate.
*
*/
/*public class que7 {
	
	public static int[] Sort( int a[] , int size) {
		
		for(int j=1;j<size;j++) {
			
			int key = a[j];
			int i = j-1;
			
			while((i>-1)&&(a[i]>key)){
				
				 a[i+1] = a[i];
				 i--;
			}
			
			 a[i+1]=key;
		}
		return a;
	}

	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter size of arr");
		int size = sc.nextInt();
		int arr[] = new int[size];
		System.out.println("Enter a arr..");
		
		for(int i=0;i<size;i++) {
		arr[i] = sc.nextInt();
		}
		
		 int b[]  = Sort(arr,size);
		 
		 for(int i=0;i<size;i++ ){
			 System.out.print(" "+b[i]);
		 }
	}
}*/

/**
 * To sort an arr[] using insertion sort
 * by taking input in a string formate.
 *
 */
public class InsertionSort{
	
	public static void main(String []args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a string");
		String str = sc.nextLine();
		int length = str.length();
		
		char arr[] = new char[length];
		for(int i=0;i<length;i++) {
			arr[i] = str.charAt(i);
		}
		
		for(int j=1;j<length;j++) {
			 char  key = arr[j];
			 int i=j-1;
			 
			 while((i>-1)&&(arr[i]>key)) {
				 arr[i+1] = arr[i];
				 i--;
			 }
			 
			 arr[i+1] = key;
		}
		
		for(int k=0;k<length;k++){
			System.out.print(" "+arr[k]);
		}
	}
	
	
	
}

