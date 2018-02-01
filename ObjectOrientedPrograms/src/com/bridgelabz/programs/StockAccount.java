package com.bridgelabz.programs;

import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

import com.bridgelabz.util.StockOperation;

import files.CompanyShare;

public class StockAccount {

	public static void main(String args[]) throws IOException, ParseException {
		Scanner sc = new Scanner(System.in);
		char ch;
		do {
			System.out.println("1:Buy 2:Sell");
			int choice= sc.nextInt();
			
			switch(choice) {
			
			case 3:StockOperation.createAccount();
				break;
			case 1:CompanyShare compshare = StockOperation.buyStocks();
				if(compshare!=null) {
					StockOperation.saveUserFile(compshare);
				}else {
					System.out.println("Data not stored in compshare Object");
				}
				break;
			case 2:StockOperation.sell();
					StockOperation.save();
				break;
			default:	
			
			}
			System.out.println("Do you want to continue :y/Y");
			ch =sc.next().charAt(0);
		}while(ch=='y'||ch=='Y');
	}
}
