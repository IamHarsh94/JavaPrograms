package com.bridgelabz.programs;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.bridgelabz.util.StockOperation;

public class StockReport {

	
	static String filePath = "/home/bridgeit/eclipse-workspace/ObjectOrientedPrograms/src/files/Stock.json";
	static Scanner sc =new Scanner(System.in);
	public static void main(String args[]) throws IOException, ParseException {
	char ch;
		
		do {
			System.out.println("1:Press To Add Stock 2:press To calculate value of each stock");
			int choice = sc.nextInt();	
			switch(choice) {
				case 1:StockOperation.addStockDetails(filePath);
					break;
				case 2:StockOperation.calculateStock(filePath);	
				default:	
		
			}
		System.out.println("Add more stock press : y/Y");
		ch = sc.next().charAt(0);
		}while(ch=='y'||ch=='Y');
	}
}