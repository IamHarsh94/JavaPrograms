package com.bridgelabz.programs;

import java.util.Random;
import java.util.Scanner;

/**
 * to get value between 0 and 1. If < 0.5 then tails or heads 
 * @author bridgeit
 *
 */
public class FlipCoin {

	public static void main(String args[]) {
		Random ran = new Random();
		int head = 0;
		int tail = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter How Many times You Want to Flip");
		double flip = sc.nextInt();
		
		for(int i=1;i<=flip;i++){
			
			float num =ran.nextFloat();
			System.out.println(num);
			if(num<0.5){
				tail++;
			}
			else {
				head++;
			}
		}
		System.out.println("Head flip "+(head/flip)*100+"%");
		System.out.println("tail flip "+(tail/flip)*100+"%");
	}
}
