package com.bridgelabz.programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.bridgelabz.util.Utility;

public class BinaryWordList{

	public static void main(String []args) throws IOException {
		Scanner sc =new Scanner(System.in);
		try {
			File file  = new File("/home/bridgeit/Documents/File.txt");
			BufferedReader br =new BufferedReader(new FileReader(file));
			 
			System.out.println("Enter the word to be searched :");
			String key = sc.next();
			
			String line;
			while((line = br.readLine())!= null){
			
				   if(Utility.findWord(line,key)) {
					   System.out.println("This Word is present in file..");
					   break;
				   }
				   
			}
			  System.out.println("This word is not present in file..");
			  
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
