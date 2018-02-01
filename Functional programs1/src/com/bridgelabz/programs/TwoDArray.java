package com.bridgelabz.programs;
import java.util.Scanner;

/**
 * To store 2D array Depends on choice and print
 * @author bridgeit
 *
 */
public class TwoDArray{

	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Which array u want to creat.. ");
		System.out.println("Enter 1:Integer, 2:Double, 3:Boolean ");
		int choice= sc.nextInt();
		switch(choice) {
			case 1:
				System.out.println("Enter No.of col");
				int col = sc.nextInt();
				System.out.println("Enter No of Row");
				int row = sc.nextInt();
				
				int arr[][] =new int[row][col];
				System.out.println("Enter a Integer elements in the array:");
				
				for(int i=0;i<row;i++) {
					for(int j=0;j<col;j++) {
						arr[i][j] = sc.nextInt();
					}
				}
			
				for(int i=0;i<row;i++) {
					for(int j=0;j<col;j++) {
						System.out.print(" "+arr[i][j]);
					}
					System.out.println(" ");
				}
					break;
			case 2:
				System.out.println("Enter No.of col");
				int col1 = sc.nextInt();
				System.out.println("Enter No of Row");
				int row1 = sc.nextInt();
				
				double arr1[][] =new double[row1][col1];
				System.out.println("Enter a Double elements in the array:");
				
				for(int i=0;i<row1;i++) {
					for(int j=0;j<col1;j++) {
						arr1[i][j] = sc.nextDouble();
					}
				}
			
				for(int i=0;i<row1;i++) {
					for(int j=0;j<col1;j++) {
						System.out.print(" "+arr1[i][j]);
					}
					System.out.println(" ");
				}
			
					break;
			case 3:
				System.out.println("Enter No.of col");
				int col2 = sc.nextInt();
				System.out.println("Enter No of Row");
				int row2 = sc.nextInt();
				
				boolean arr2[][] =new boolean[row2][col2];
				System.out.println("Enter a Boolean elements in the array:");
				
				for(int i=0;i<row2;i++) {
					for(int j=0;j<col2;j++) {
						arr2[i][j] = sc.nextBoolean();
					}
				}
			
				for(int i=0;i<row2;i++) {
					for(int j=0;j<col2;j++) {
						System.out.print(" "+arr2[i][j]);
					}
					System.out.println(" ");
				}
			
					break;
			default :
					System.out.println("Wrong Option...try again.");
		}
	}	
}
