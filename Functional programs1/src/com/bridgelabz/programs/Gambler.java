package com.bridgelabz.programs;

import java.util.Scanner;

/**
 *  start with round and place fair 10 bets until he/she goes broke or reach the goal
 *
 */
public class Gambler{

	
	public static void main(String []args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Initial cash :");
		double inCash = sc.nextInt();
		System.out.println("Enter Your Goal :");
		int goal = sc.nextInt();
		System.out.println("How many time u want to play :");
		int times = sc.nextInt();
		System.out.println("How many money you want to bets in Each round");
		int betsAmount = sc.nextInt();
		int round = 0;
		double wins = 0;
	
		for(int i=1;i<times;i++) {
			double bets;
			double cash = inCash;
			
			while((cash>0)&&(cash<goal)) {
				
				double ran = Math.random();
				
				if(ran<0.5) {
					cash= cash+betsAmount;
				}
				else{
					cash = cash-betsAmount;
				}
			}
				if(cash==goal) {
					wins++;
				}
	
		}
		System.out.println((int)wins+" Win Out of "+times);
		System.out.println("Per of game won :"+(wins/times)*100);
		
	}
}
