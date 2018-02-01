package com.bridgelabz.util;

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

public class BooksOperations{

	private Scanner sc =new Scanner(System.in);
	private String filepath ="/home/bridgeit/eclipse-workspace/ObjectOrientedPrograms/src/files/Address.json";	
	private JSONArray addressBookArr;
	@SuppressWarnings("unused")
	private JSONObject AddressArrContainObj;
	private String ArrName ="Address Book";
	
	public BooksOperations(){
		addressBookArr = new JSONArray();
		AddressArrContainObj=new JSONObject();
	}
	
	public void addAdress() throws IOException, ParseException {
		File file = new File(filepath);
		
		if(file.length()==0) {
			getAddress(addressBookArr);
		}else {
			addressBookArr=getPresentArr();
			getAddress(addressBookArr);
		}
	}
	public void getAddress(JSONArray addressBookArr) throws IOException {
		
		System.out.println("Enter a name :");
		String name = sc.nextLine();
		System.out.println("Enter last name :");
		String lastName = sc.nextLine();
		System.out.println("Enter address :");
		String address = sc.nextLine();
		System.out.println("Enter city :");
		String city = sc.nextLine();
		System.out.println("Enter a state :");
		String state = sc.nextLine();
		System.out.println("Enter zip code :");
		String zip = sc.nextLine();
		System.out.println("Enter phone number :");
		String phoneNum = sc.nextLine();
		UserDetails userInfo = new UserDetails(name,lastName,address,city,state,zip,phoneNum);
		createJsonObj(userInfo,addressBookArr);
	}
	
	@SuppressWarnings("unchecked")
	public void createJsonObj(UserDetails userInfo,JSONArray addressBookArr) throws IOException {
		
		JSONObject simple = new JSONObject();
		
		simple.put("FirstName",userInfo.getFristName());
		simple.put("LastName", userInfo.getLastname());
		simple.put("Address", userInfo.getAddress());
		simple.put("City", userInfo.getCity());
		simple.put("State", userInfo.getState());
		simple.put("Zip", userInfo.getZipCode());
		simple.put("PhoneNum",userInfo.getPhoneNum());
		addressBookArr.add(simple);
		AddressArrContainObj.put("AddressBook", addressBookArr);
		System.out.println(AddressArrContainObj.toString());
		writeIntoFile(AddressArrContainObj);
	}
	
	public void writeIntoFile(JSONObject object) throws IOException {
		
		File file = new File(filepath);
		FileWriter fw = new FileWriter(file);
		fw.write(object.toString());
		fw.flush();
	}
	public JSONArray getPresentArr() throws FileNotFoundException, IOException, ParseException {
		File file = new File(filepath);
		JSONParser parse = new JSONParser();
		Object obj	= parse.parse(new FileReader(file));
		JSONObject outer = (JSONObject) obj;
		JSONArray array =(JSONArray) outer.get("AddressBook");
		return array;
	}
	public void edit() throws FileNotFoundException, IOException, ParseException {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter a name of person who's details you want to edit :");
		String name = sc1.nextLine();

		boolean flag=checkDetails(name);
		if(flag) {
			String []arr= {"","FirstName","LastName","Address","City","State","Zip","PhoneNum"};
			System.out.println("Enter key which u want to edit");
			System.out.println("1:FirstName ,2:LastName ,3:Address ,4:City ,5:State ,6:Zip ,7:PhoneNum");
			int key=sc1.nextInt();
			String param = arr[key];
			System.out.println("Enter a new "+param);
			String newParam =sc1.next();
			UpdateDetails(name,param,newParam);
		}else {
			System.out.println("the person not found..Do you want to try again press Y/N");
			char ch = sc1.next().charAt(0);
			if(ch=='y'||ch=='Y') {
				edit();
			}
		}
	}
	public boolean checkDetails(String name) throws FileNotFoundException, IOException, ParseException {
		boolean flag=false;
		File file = new File(filepath);
		JSONParser parse = new JSONParser();
		Object obj = parse.parse(new FileReader(file));
		JSONObject outer = (JSONObject) obj;
		JSONArray array = (JSONArray) outer.get("AddressBook");
		JSONObject compareObj;
		for(int i=0;i<array.size();i++) {
			compareObj = (JSONObject) array.get(i);
			if(compareObj.get("FirstName").equals(name)) {
				flag=true;
			}
		}
		return flag;
	}
	@SuppressWarnings("unchecked")
	public void UpdateDetails(String personName,String paramToBeReplace,String newParam) throws FileNotFoundException, IOException, ParseException {
		addressBookArr=getPresentArr();
		JSONObject compareObj;
		for(int i=0;i<addressBookArr.size();i++) {
			compareObj = (JSONObject) addressBookArr.get(i);
			if(compareObj.get("FirstName").equals(personName)) {
				compareObj.put(paramToBeReplace,newParam);
				System.out.println("new updation");
			}
		}
		AddressArrContainObj.put("AddressBook", addressBookArr);
		writeIntoFile(AddressArrContainObj);
	}
	public void delete() throws FileNotFoundException, IOException, ParseException {
		
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Enter first name who's record you want to delete");
		String firstName =sc1.nextLine();
		System.out.println("Enter last name who's record you want to delete");
		String lastName = sc1.nextLine();
		boolean flag=validatePerson(firstName,lastName);
		if(flag) {
				removePerson(firstName,lastName);
				System.out.println("Person remove successfully");
		}else {
			System.out.println("person not found in record...do you want to try again press Y/N");
			char ch = sc1.next().charAt(0);
			if(ch=='y'||ch=='Y') {
				delete();
			}
		}
	}
	public boolean validatePerson(String firstName,String lastName) throws FileNotFoundException, IOException, ParseException {
		boolean flag=false;
		File file = new File(filepath);
		JSONParser parse = new JSONParser();
		Object obj = parse.parse(new FileReader(file));
		JSONObject outer = (JSONObject) obj;
		JSONArray array = (JSONArray) outer.get("AddressBook");
		JSONObject compareObj;
		for(int i=0;i<array.size();i++) {
			compareObj = (JSONObject) array.get(i);
			if((compareObj.get("FirstName").equals(firstName))&&(compareObj.get("LastName").equals(lastName))) {
				flag=true;
			}
		}
		return flag;
	}
	@SuppressWarnings("unchecked")
	public void removePerson(String firstName,String lastName) throws FileNotFoundException, IOException, ParseException {
		File file = new File(filepath);
		JSONParser parse = new JSONParser();
		Object obj = parse.parse(new FileReader(file));
		JSONObject outer = (JSONObject) obj;
		JSONArray array = (JSONArray) outer.get("AddressBook");
		JSONObject compareObj;
		for(int i=0;i<array.size();i++) {
			compareObj = (JSONObject) array.get(i);
			if((compareObj.get("FirstName").equals(firstName))&&(compareObj.get("LastName").equals(lastName))) {
				array.remove(compareObj);
				AddressArrContainObj.put("AddressBook",array);
				break;
			}
		}
		writeIntoFile(AddressArrContainObj);
	}
	public void sortData() throws FileNotFoundException, IOException, ParseException {
		Scanner sc1 = new Scanner(System.in);
		System.out.println("1:By Name , 2:By Zip");
		int choice = sc1.nextInt();
			switch(choice) {
		
			case 1:sortByName();
					System.out.println("Successfully sort by name");
				break;
			case 2:sortByZip();
					System.out.println("Successfully sort by zip");
				break;
			default:	
		}
			
	}
	@SuppressWarnings("unchecked")
	public void sortByName() throws FileNotFoundException, IOException, ParseException {
		File file = new File(filepath);
		JSONParser parse = new JSONParser();
		Object obj = parse.parse(new FileReader(file));
		JSONObject outer = (JSONObject) obj;
		JSONArray array = (JSONArray) outer.get("AddressBook");
		JSONObject Obj1=null;
		JSONObject Obj2=null;
		JSONObject temp=null;
		for(int i=0;i<array.size()-1;i++) {
			for(int j=0;j<array.size()-1;j++) {
				Obj1=(JSONObject) array.get(j);
				Obj2=(JSONObject) array.get(j+1);
				String n1 = (String)Obj1.get("FirstName");
				String n2 = (String)Obj2.get("FirstName");
				String name1=n1.toLowerCase();
				String name2=n2.toLowerCase();
				if(name1.compareTo(name2)>0) {
					temp=(JSONObject) array.get(j);
					array.remove(j);
					array.add(j, Obj2);
					array.remove(j+1);
					array.add(j+1, temp);
				}
			}
		}
		AddressArrContainObj.put("AddressBook", array);
		writeIntoFile(AddressArrContainObj);
	}
	@SuppressWarnings("unchecked")
	public void sortByZip() throws FileNotFoundException, IOException, ParseException {
		File file = new File(filepath);
		JSONParser parse = new JSONParser();
		Object obj = parse.parse(new FileReader(file));
		JSONObject outer = (JSONObject) obj;
		JSONArray array = (JSONArray) outer.get("AddressBook");
		JSONObject Obj1=null;
		JSONObject Obj2=null;
		JSONObject temp=null;
		for(int i=0;i<array.size()-1;i++) {
			for(int j=0;j<array.size()-1;j++) {
				Obj1=(JSONObject) array.get(j);
				Obj2=(JSONObject) array.get(j+1);
				String zip1 = (String)Obj1.get("Zip");
				String zip2 = (String)Obj2.get("Zip");
				
				if(zip1.compareTo(zip2)>0) {
					temp=(JSONObject) array.get(j);
					array.remove(j);
					array.add(j, Obj2);
					array.remove(j+1);
					array.add(j+1, temp);
				}
			}
		}
		AddressArrContainObj.put("AddressBook", array);
		writeIntoFile(AddressArrContainObj);
	}
}
	

