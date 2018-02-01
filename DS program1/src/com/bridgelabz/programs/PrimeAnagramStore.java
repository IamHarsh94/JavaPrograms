package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.util.Utility;

class Calculate{
	static	int [][]prime = new int [10][180];
			static	int a=0;
			static int b=0;
			static int c=0;
			static int d=0;
			static int e=0;
			static int f=0;
			static int g=0;
			static int h=0;
			static int k=0;
			static int l=0;
	
	/**
	 * To add element in 2D array in appropriate position 
	 * @param no
	 */
	public static void  TwoDArr(int no) {
		
			if((no>0)&&(no<=100)){
				
				prime[0][a++]=no;
				
			}
			else if((no>100)&&(no<=200)){
				prime[1][b++]=no;
			}
			else if((no>200)&&(no<=300)) {
				prime[2][c++]=no;
			}
			else if((no>300)&&(no<=400)) {
				prime[3][d++]=no;
			}
			else if((no>400)&&(no<=500)) {
				prime[4][e++]=no;
			}
			else if((no>500)&&(no<=600)) {
				prime[5][f++]=no;
			}
			else if((no>600)&&(no<=700)) {
				prime[6][g++]=no;
			}
			else if((no>700)&&(no<=800)) {
				prime[7][h++]=no;
			}
			else if((no>800)&&(no<=900)) {
				prime[8][k++]=no;
			}
			else {		
				prime[9][l++]=no;
			}
		
	}
	/**
	 * To print all 2D array by row and column wise.
	 */
	public static void PrintTwoDArr() {
		System.out.println("Prime Num which anagram");
		for(int i=0;i<10;i++) {
			for(int j=0;j<25;j++) {
				if(prime[i][j]==0) {
					continue;
				}else {
					System.out.print("|"+prime[i][j]+"|");
				}
			}		
			System.out.println("");
		}
	}
	
	
	
	/**
	 * To calculate prime numbers between 1-1000
	 * and store it in String[] by converting integer value into String.
	 * @return
	 */
	public static String[] primeNum() {
		String str1[] = new String[168];
		int position=0;
		for(int i=1;i<1000;i++){
			int count=0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					count++;
				}
			}
			if(count==2) {
				str1[position++]=String.valueOf(i);
			}
		}
		return str1;
	}
	
}

/**
 * @author To get all prime numbers which are anagrams and store into an arr
 * then pass that arr to print function
 *
 */
public class PrimeAnagramStore {

	public static void main(String []args){
		int temp[]=new int[180];
		Scanner sc =new Scanner(System.in);
		 
		String str1[] = Calculate.primeNum();
		String str2[] = new String[168];
		
		for(int i=0;i<168;i++) {
			str2[i]=str1[i];
		}
		int count =0;
		
		for(int i=0;i<str1.length;i++) {
			for(int j=i+1;j<str1.length;j++) {
				  if(Utility.isAnagram(str1[i],str2[j])) {
					  
					  	temp[count++]=Integer.valueOf(str1[i]);
					  	temp[count++]=Integer.valueOf(str1[j]);
				  }
			}
		}
		
		for(int i=0;i<temp.length;i++) {
			Calculate.TwoDArr(temp[i]);
		}
			Calculate.PrintTwoDArr();
			
	}
	
}
