package com.bridgelabz.programs;


import java.util.Scanner;

public class VendingMachine{

	static int arr[] = {1000,500,100,50,10,5,2,1};
	static int i=0;
	static int Total=0;
	public static void main(String args[]) {
		Scanner sc =new Scanner(System.in);
		
		
		System.out.println("Enter a amount :");
		int amount = sc.nextInt();
		
		calculate cal[] = new calculate[8];
		vendingMachin(amount,cal);
		
	}	

		/**
		 * @param To calculate Total minimum notes require for amount
		 */
		public static int vendingMachin(int amount,calculate []cal) {
			
			
			int count=0;
			int note = 0;
			
			if(i==arr.length){
			
				System.out.println("Total notes are "+Total);
				return -1;
			}
			if(amount==0) {
				
				System.out.println("Total notes are "+Total);
				return -1;
			}
			else {
				
					
					while(amount>=arr[i]){
						Total++;
						note = arr[i];
						count++;
						amount = amount-arr[i];
					}
					int m=0;
					 
					cal[m] = new calculate(note,count);
					i++;
					if(cal[m].note==0||cal[m].times==0) {
						
						System.out.print("");
					}
					else {
						cal[m].print();
					}
				m++;
					
			}
			
			return vendingMachin(amount,cal);
	}
}
class calculate{
	
	int note;
	int times;
	
	calculate(int note,int times){
		this.note =note;
		this.times =times;
		
	}
	
	public void print() {
		
		System.out.println(note+" Note is "+times+" Times");
	}
}