package com.bridgelabz.programs;
import java.util.Scanner;

class myClass{
	
	/**
	 * To calculate prime numbers between 1-1000
	 * and store in arr.
	 * @return return the 2D array with prime values.
	 */
	public static int[] calculatePrime() {
		int arr[] = new int[168];
		int m=0;
		for(int i=1;i<=1000;i++) {
			int count=0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count==2) {
				arr[m++]=i;
			}
		}
		return arr;
	}
	/**
	 * To store all prime numbers between 1-1000 in appropriate position in 2D array
	 * 
	 * @return return the 2D array with values.
	 */
	public static int[][] TwoDArr() {
		int [][]prime = new int [10][25];
		int arr[] = calculatePrime();
		int a=0,b=0,c=0,d=0,e=0,f=0,g=0,h=0,k=0,l=0;
		for(int i=0;i<168;i++) {
			
			if((arr[i]>0)&&(arr[i]<=100)){
				
				prime[0][a++]=arr[i];
			}
			else if((arr[i]>100)&&(arr[i]<=200)){
				prime[1][b++]=arr[i];
			}
			else if((arr[i]>200)&&(arr[i]<=300)) {
				prime[2][c++]=arr[i];
			}
			else if((arr[i]>300)&&(arr[i]<=400)) {
				prime[3][d++]=arr[i];
			}
			else if((arr[i]>400)&&(arr[i]<=500)) {
				prime[4][e++]=arr[i];
			}
			else if((arr[i]>500)&&(arr[i]<=600)) {
				prime[5][f++]=arr[i];
			}
			else if((arr[i]>600)&&(arr[i]<=700)) {
				prime[6][g++]=arr[i];
			}
			else if((arr[i]>700)&&(arr[i]<=800)) {
				prime[7][h++]=arr[i];
			}
			else if((arr[i]>800)&&(arr[i]<=900)) {
				prime[8][k++]=arr[i];
			}
			else {		
				prime[9][l++]=arr[i];
			}
		}
		return prime;
	}
	
}

/**
 * @author To pass 2D arr to function to calculate all prime numbers between 1-100
 * and print 2D array by avoiding 0 element.
 *
 */
public class PrimeNumStoreInRange {

	public static void main(String args[]) {
		Scanner sc =new Scanner(System.in);
		int [][]PrimeArr = myClass.TwoDArr();
		  for(int i=0;i<10;i++) {
			  for(int j=0;j<25;j++) {
				  if(PrimeArr[i][j]==0) {
					  continue;
				  }else {
					  System.out.print("|"+PrimeArr[i][j]+"|");
				  }
			  }
			  System.out.println("");
		  }
		
		
	}
}
