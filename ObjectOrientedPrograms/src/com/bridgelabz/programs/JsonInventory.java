package com.bridgelabz.programs;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import files.Inventory;

public class JsonInventory {
	private static Scanner sc =new Scanner(System.in);
	public static void main(String args[]) throws IOException, ParseException {
	
		int ch;
		File file= new File("/home/bridgeit/eclipse-workspace/ObjectOrientedPrograms/src/files/Simple.json");
		do {
			System.out.println("1:Add Inventory : ");
			int choice = sc.nextInt();
			switch(choice) {
					case 1:Operation(file);
						break;		
					default:
				}
			System.out.println("Do you want to continue : press 1");
			ch = sc.nextInt();
		}while(ch==1);
		
		System.out.println("Want to calculate values of every Inventory press:1");
		int no = sc.nextInt();
		if(no==1) {
			Calculate(file);
		}
	}
		  
		public static void Calculate(File file) throws FileNotFoundException, IOException, ParseException {
			
			JSONParser parse = new JSONParser();	
			Object obj = parse.parse(new FileReader(file));
			JSONObject outerObj = (JSONObject) obj;
			JSONObject inventory = (JSONObject) outerObj.get("Inventory");
			
		   System.out.println("*****Value of Rice******");
		   JSONArray riceArr = (JSONArray) inventory.get("Rice");
		   double TotalValueR=0;
		   for(int i=0;i<riceArr.size();i++ ) {
			   
			    JSONObject elem = (JSONObject) riceArr.get(i);
			    double value = ((double)elem.get("Price")) * ((double)elem.get("Weight"));
			    TotalValueR=TotalValueR+value;
			    System.out.println("Value of "+elem.get("Name")+" is :"+value);
		   }
		   System.out.println("value of total rice : "+TotalValueR);
		   
		   System.out.println("*****Value of Pulses*****");
		   JSONArray pulsesArr = (JSONArray) inventory.get("Pulses");
		   double TotalValueP=0;
		   for(int i=0;i<pulsesArr.size();i++ ) {
			   
			    JSONObject elem = (JSONObject) pulsesArr.get(i);
			    double value = ((double)elem.get("Price")) * ((double)elem.get("Weight"));
			    TotalValueP=TotalValueP+value;
			    System.out.println("Value of "+elem.get("Name")+" is :"+value);
		   }
		   System.out.println("value of total rice : "+TotalValueP);
		
		   System.out.println("*****Value of Wheats*****");
		   JSONArray wheatsArr = (JSONArray) inventory.get("Pulses");
		   double TotalValueW=0;
		   for(int i=0;i<wheatsArr.size();i++ ) {
			   
			    JSONObject elem = (JSONObject) wheatsArr.get(i);
			    double value = ((double)elem.get("Price")) * ((double)elem.get("Weight"));
			    TotalValueW=TotalValueW+value;
			    System.out.println("Value of "+elem.get("Name")+" is :"+value);
		   }
		   System.out.println("value of total rice : "+TotalValueW);
		}
		
	
	
		public static void Operation(File file) throws IOException, ParseException {
			
			Inventory info = new Inventory();
			
			System.out.println("Rice :R , Pulses :P , Wheats :W ");
			char choice = sc.next().charAt(0);
			info.setChoice(choice);
			
			System.out.println("Enter name :");
			String name = sc.next();
			info.setName(name);
			
			System.out.println("Enter a weight:");
			double weight = sc.nextDouble();
			info.setWeight(weight);
			
			System.out.println("Enter a price:");
			double price = sc.nextDouble();
			info.setPrice(price);
			
			if(file.length()==0) {
				createJsonObj(info,file);
			}
			else {
				addToJsonFile(info,file);
			}
			
				
				
		}
		
		@SuppressWarnings("unchecked")
		public static void createJsonObj(Inventory info,File file) throws IOException, ParseException {
			
			JSONObject myJson =new JSONObject();
			JSONArray myJsonArr = new JSONArray();
			JSONObject inventory = new JSONObject();
			JSONObject outerObj = new JSONObject();
			
			myJson.put("Name", info.getName());
			myJson.put("Price",info.getPrice());
			myJson.put("Weight",info.getWeight());
			myJsonArr.add(myJson);
			
			if(info.getChoice()=='r'||info.getChoice()=='R') {
				
				inventory.put("Rice", myJsonArr);
			}
			else if(info.getChoice()=='p'||info.getChoice()=='P') {
			
				inventory.put("Pulses", myJsonArr);
			}
			else if(info.getChoice()=='w'||info.getChoice()=='W') {
			
				inventory.put("Wheats", myJsonArr);
			}
			outerObj.put("Inventory", inventory);
			EncodingIntoFile(outerObj,file);
		}
		
		@SuppressWarnings("resource")
		public static void EncodingIntoFile(JSONObject outerObj,File file) throws IOException {
			FileWriter fileWriter = new FileWriter(file);
			fileWriter.write(outerObj.toString());
			fileWriter.close();
		}
	
		@SuppressWarnings("unchecked")
		public static void addToJsonFile(Inventory info,File file) throws FileNotFoundException, IOException, ParseException {
			
			JSONObject myJson =new JSONObject();
			
			myJson.put("Name", info.getName());
			myJson.put("Weight", info.getWeight());
			myJson.put("Price",info.getPrice());
			
			JSONParser parse =new JSONParser();
			Object obj = parse.parse(new FileReader(file));
			@SuppressWarnings("unused")
			JSONObject outerObj = (JSONObject) obj;
			JSONObject inventory = (JSONObject) outerObj.get("Inventory");
			
			
			if(info.getChoice()=='r'||info.getChoice()=='R') {
				if((JSONArray)inventory.get("Rice")==null) {
					JSONArray riceArr = new JSONArray();
					riceArr.add(myJson);
					inventory.put("Rice", riceArr);
				}else {
					JSONArray riceArr = (JSONArray)inventory.get("Rice");
					riceArr.add(myJson);
					inventory.put("Rice", riceArr);
				}	
			}else if(info.getChoice()=='p'||info.getChoice()=='P') {
				if((JSONArray) inventory.get("Pulses")==null) {
					JSONArray pulsesArr =new JSONArray();
					pulsesArr.add(myJson);
					inventory.put("Pulses", pulsesArr);
				}else {
					JSONArray PulsesArr = (JSONArray) inventory.get("Pulses");
					PulsesArr.add(myJson);
					inventory.put("Pulses", PulsesArr);
				}	
			}else if(info.getChoice()=='w'||info.getChoice()=='W') {
				if((JSONArray) inventory.get("Wheats")==null) {
					JSONArray WeightArr = new JSONArray();
					WeightArr.add(myJson);
					inventory.put("Wheats",WeightArr);
				}else {
					JSONArray WeightArr = (JSONArray) inventory.get("Wheats");
					WeightArr.add(myJson);
					inventory.put("Wheats", WeightArr);
				}
			}
			outerObj.put("Inventory", inventory);
			EncodingIntoFile(outerObj,file);
		}
}