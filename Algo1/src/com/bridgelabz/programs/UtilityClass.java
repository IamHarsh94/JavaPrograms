package com.bridgelabz.programs;

import java.util.Arrays;
import java.util.Scanner;

import com.bridgelabz.util.Utility;

public class UtilityClass{
	
public static void main(String []args) {
		 Scanner sc = new Scanner(System.in);
		 long arrTime[]  = new long[10];
		 int i=0;
		 System.out.println("Use binarySearch method for integer Press : 1");
		 System.out.println("Use binarySearch method for String press: 2");
		 System.out.println("Use insertionSort method for integer press: 3");
		 System.out.println("Use insertionSort method for String press: 4");
		 System.out.println("Use bubbleSort method for intege press: 5");
		 System.out.println("Use bubbleSort method for String press: 6");
		 int choice = sc.nextInt();
		 switch(choice) {
		 	case 1:
		 			long  s1 = System.nanoTime();
		 			Utility.binarySearchInt();
		 			long e1 = System.nanoTime();
		 			long T1 = e1-s1;
		 			arrTime[i++]=T1;
		 			
		 	case 2:
		 			long  s2 = System.nanoTime();
		 			Utility.binarySearchStr();
		 			long e2 = System.nanoTime();
		 			long T2 = e2-s2;
		 			arrTime[i++]=T2;
		 			
		 	case 3:
		 			long  s3 = System.nanoTime();		
		 			Utility.insertionSortInt();
		 			long e3 = System.nanoTime();
		 			long T3 = e3-s3;
		 			arrTime[i++]=T3;
		 		
		 	case 4:
		 			long  s4 = System.nanoTime();		
		 			Utility.insertionSortStr();
		 			long e4 = System.nanoTime();
		 			long T4 = e4-s4;
		 			arrTime[i++]=T4;
		 			
		 	case 5:	
		 			long  s5 = System.nanoTime();	
		 			Utility.bubbleSortInt();
		 			long e5 = System.nanoTime();
		 			long T5 = e5-s5;
		 			arrTime[i++]=T5;
		 			
		 	case 6:
		 			long  s6 = System.nanoTime();
		 			Utility.bubbleSortStr();
		 			long e6 = System.nanoTime();
		 			long T6 = e6-s6;
		 			arrTime[i++]=T6;
		 			break;
		 	default :
		 			System.out.println("Plz Enter Correct num");
		 			break;
		 }  
		 
		 
		 	for(int j=0;j<arrTime.length;j++) {
		 		long key = arrTime[j];
		 		int k =j-1;
		 		
		 		while((k>-1)&&(arrTime[k]<key)) {
		 			arrTime[k+1] = arrTime[k];
		 			k--;
		 		}
		 		
		 		arrTime[k+1] = key;
		 	}
		 			
		 	for(int j=0;j<arrTime.length;j++) {
		 		System.out.print(" "+arrTime[j]);
		 	}
		 	
	 }
 }

 