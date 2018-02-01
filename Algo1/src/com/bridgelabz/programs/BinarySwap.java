package com.bridgelabz.programs;
import java.util.*;
/**
 * @author To convert decimal num into binary num.
 *
 */
public class BinarySwap{

	public static void main(String []args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a num :");
		int num = sc.nextInt();
		String binary = Integer.toBinaryString(num);
		System.out.println("Binary is :"+binary);
		char ch[] = binary.toCharArray();
		char copy[] = new char[ch.length];
		int j=0;
		for(int i=ch.length-1;i>=0;i--) {
			copy[j++]=ch[i];
		}
		System.out.println("New num is :");
		System.out.println(copy);
	}
}
