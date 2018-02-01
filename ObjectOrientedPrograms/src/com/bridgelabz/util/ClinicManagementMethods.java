package com.bridgelabz.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import files.DoctorInfo;

public class ClinicManagementMethods {

	private static Scanner sc = new Scanner(System.in);
	private String doctorFilePath="/home/bridgeit/eclipse-workspace/ObjectOrientedPrograms/src/files/doctorsFile.json";
	@SuppressWarnings("unused")
	private String patientFilePath="/home/bridgeit/eclipse-workspace/ObjectOrientedPrograms/src/files/PatientFile.json";
	@SuppressWarnings("unused")
	private String AppointmentPath="/home/bridgeit/eclipse-workspace/ObjectOrientedPrograms/src/files/Appointment.json";
	private  JSONObject docFileObj;
	private  JSONArray docFileArr;
	private  JSONObject patientFileObj;
	private  JSONArray patientFileArr;
	private  JSONObject appointFileObj;
	private  JSONArray appointFileArr;
	
	public ClinicManagementMethods() {
		docFileObj =new JSONObject();
		docFileArr =new JSONArray();
		patientFileObj= new JSONObject();
		patientFileArr=new JSONArray();
		appointFileObj=new JSONObject();
		appointFileArr=new JSONArray();
	}
	
	public void addDoctor() throws IOException, ParseException {
		File file = new File(doctorFilePath);
		
		if(file.length()==0) {
			addDoc();
		}else {
			addJsonDoc();
		}
	}
	public void addDoc() throws IOException{
		Scanner sc = new Scanner(System.in);
		
		DoctorInfo doc = new DoctorInfo();
		System.out.println("Enter doctor name :");
		String docName = sc.nextLine();
		doc.setDocName(docName);
		System.out.println("Enter doctor id :");
		String docId = sc.nextLine();
		doc.setDocId(docId);
		System.out.println("Enter doctor specialization");
		String docSpec = sc.nextLine();
		doc.setSpecialization(docSpec);
		System.out.println("Enter doctor availability");
		String aval = sc.nextLine();
		doc.setAvailability(aval);
		createjsonDoc(doc);
	}
	@SuppressWarnings("unchecked")
	public void createjsonDoc(DoctorInfo doc) throws IOException {
		JSONObject simple = new JSONObject();
		
		simple.put("DoctorName", doc.getDocName());
		simple.put("DocId", doc.getDocId());
		simple.put("Specialization",doc.getSpecialization());
		simple.put("Availability",doc.getAvailability());
		docFileArr.add(simple);
		docFileObj.put("DoctorList",docFileArr);
		writeIntoFile(doctorFilePath,docFileObj);
	}
	public void addJsonDoc() throws FileNotFoundException, IOException, ParseException {									///////////////////////new method
		Scanner sc = new Scanner(System.in);
		
		DoctorInfo doc = new DoctorInfo();
		System.out.println("Enter doctor name :");
		String docName = sc.nextLine();
		doc.setDocName(docName);
		System.out.println("Enter doctor id :");
		String docId = sc.nextLine();
		doc.setDocId(docId);
		System.out.println("Enter doctor specialization");
		String docSpec = sc.nextLine();
		doc.setSpecialization(docSpec);
		System.out.println("Enter doctor availability");
		String aval = sc.nextLine();
		doc.setAvailability(aval);
		addToDocjsonObj(doc);
	}
	@SuppressWarnings("unchecked")
	public void addToDocjsonObj(DoctorInfo doc) throws FileNotFoundException, IOException, ParseException {
		File file = new File(doctorFilePath);
		JSONObject simple = new JSONObject();
		JSONObject outer = new JSONObject();
		simple.put("DoctorName", doc.getDocName());
		simple.put("DocId", doc.getDocId());
		simple.put("Specialization",doc.getSpecialization());
		simple.put("Availability",doc.getAvailability());
		JSONParser parse = new JSONParser();
		Object  obj =parse.parse(new FileReader(file));
		JSONObject jsonObj = (JSONObject) obj;
		JSONArray jsonArr = (JSONArray) jsonObj.get("DoctorList");
		jsonArr.add(simple);
		outer.put("DoctorList", jsonArr);
		writeIntoFile(doctorFilePath,outer);
	}
	public void writeIntoFile(String filePath,JSONObject object) throws IOException {
		File file = new File(filePath);
		FileWriter fw = new FileWriter(file);
		fw.write(object.toString());
		fw.flush();
	}
	public void addPatient() throws IOException, ParseException {
		File file = new File(patientFilePath);
		if(file.length()==0) {
			patientAdd();
		}else {
			addJsonPat();
		}
	}
	public void patientAdd() throws IOException {
		Scanner sc =new Scanner(System.in);
		@SuppressWarnings("unused")
		PatientIInfo patient = new PatientIInfo();
		System.out.println("Enter patient name :");
		String pName = sc.nextLine();
		patient.setPatientName(pName);
		System.out.println("Enter patient id :");
		String pId =sc.nextLine();
		patient.setPatientId(pId);
		System.out.println("Enter patient mobile number :");
		String pMob=sc.nextLine();
		patient.setPatientMobile(pMob);
		createjsonPat(patient);
	}
	@SuppressWarnings("unchecked")
	public void createjsonPat(PatientIInfo patient) throws IOException {
		JSONObject simple = new JSONObject();
		simple.put("PatientName",patient.getPatientName());
		simple.put("PatientId", patient.getPatientId());
		simple.put("PatientMob",patient.getPatientMobile());
		patientFileArr.add(simple);
		patientFileObj.put("PatientDetails",patientFileArr);
		writeIntoFile(patientFilePath,patientFileObj);
	}
	
	public void addJsonPat() throws FileNotFoundException, IOException, ParseException {
		Scanner sc =new Scanner(System.in);
		@SuppressWarnings("unused")
		PatientIInfo patient = new PatientIInfo();
		System.out.println("Enter patient name :");
		String pName = sc.nextLine();
		patient.setPatientName(pName);
		System.out.println("Enter patient id :");
		String pId =sc.nextLine();
		patient.setPatientId(pId);
		System.out.println("Enter patient mobile number :");
		String pMob=sc.nextLine();
		patient.setPatientMobile(pMob);
		addToPatjsonObj(patient);
	}
	
	@SuppressWarnings("unchecked")
	public void addToPatjsonObj( PatientIInfo patient) throws FileNotFoundException, IOException, ParseException {
		File file = new File(patientFilePath);
		JSONObject simple = new JSONObject();
		simple.put("PatientName",patient.getPatientName());
		simple.put("PatientId", patient.getPatientId());
		simple.put("PatientMob",patient.getPatientMobile());
		JSONObject outer = new JSONObject();
		JSONParser parse = new JSONParser();
		Object  obj =parse.parse(new FileReader(file));
		JSONObject jsonObj = (JSONObject) obj;
		JSONArray jsonArr = (JSONArray) jsonObj.get("PatientDetails");
		jsonArr.add(simple);
		outer.put("PatientDetails", jsonArr);
		writeIntoFile(patientFilePath,outer);
	}
	public void appointment() throws FileNotFoundException, IOException, ParseException {
		Scanner scan = new Scanner(System.in);
		boolean flag;
		String str[]=new String[15];
		
		System.out.println("Enter a patient name");
		String patientName = scan.nextLine();
		flag=checkAvailablePatient(patientName);
		if(flag) {
			System.out.println("which specialization doctor you want to visit:");
			ArrayList<String> list =getDoctorSpecialization();
			
			int i=0;
			try {
				while(!list.isEmpty()) {
					System.out.println(" "+(i+1)+":"+list.get(i));
					i++;
				}
			}catch(Exception e) {
				
			}
			int choice = sc.nextInt();
			String Specialize = list.get(choice-1);
			HashMap<Integer, ArrayList<String>> map = getDoctor(Specialize);
			int j=0;
			try {
				
				while(!map.get(0).isEmpty()) {
					System.out.println(" "+(j+1)+":Dr."+map.get(0).get(j)+" Visiting Time :"+map.get(1).get(j));
					j++;
				}
			}catch(Exception e) {
			}
			String patientAge=null; 
			String visitTime=null;
			System.out.println("Select doctor :");
			int choice1 = scan.nextInt();
			scan.nextLine();
			String DocName=map.get(0).get(choice1-1);
			
			System.out.println("Enter patient age:");
			while(true) {
				
				patientAge = scan.nextLine();
				if(patientAge!=null) {
					break;
				}
			}
			System.out.println("Enter visiting time :");
			while(true) {
				visitTime = scan.nextLine();
				if(visitTime!=null) {
					break;
				}
			}
			takeAppointment(patientName,patientAge,visitTime,DocName);
			System.out.println("Appointment is fix and noted in file successefully...");
		}else {
			System.out.println("Sorry this patient not present in patient file plz add first:");
			System.out.println("would you like to enter another patient name :press Y/N");
			char ch = sc.next().charAt(0);
			if(ch=='y'||ch=='Y') {
				appointment();
			}else {
				System.out.println("Thank you for visiting...");
				return;
			}
		}
	}
	public boolean checkAvailablePatient(String patientName) throws FileNotFoundException, IOException, ParseException {
		boolean flag=false;
		File file = new File(patientFilePath);
		JSONParser parse = new JSONParser();
	    Object obj=parse.parse(new FileReader(file));
	    JSONObject outer = (JSONObject) obj;
	    JSONArray jArr = (JSONArray) outer.get("PatientDetails");
	    JSONObject compareObj;
	    for(int i=0;i<jArr.size();i++) {
	    	compareObj = (JSONObject) jArr.get(i);
	    	if(compareObj.get("PatientName").equals(patientName)) {
	    		flag=true;
	    	}
	    }
	    return flag;
	}
	public ArrayList<String> getDoctorSpecialization() throws FileNotFoundException, IOException, ParseException {
		ArrayList<String> list = new ArrayList<String>();	
		File file = new File(doctorFilePath);
		JSONParser parse = new JSONParser();
	    Object obj=parse.parse(new FileReader(file));
	    JSONObject outer = (JSONObject) obj;
	    JSONArray jArr = (JSONArray) outer.get("DoctorList");
	    JSONObject getSpeci;
	    if(jArr==null) {
	    	System.out.println("Enter doctors list first..");
	    	System.exit(0);
	    }
	    for(int i=0;i<jArr.size();i++) {
	    	getSpeci = (JSONObject) jArr.get(i);
	    	String specilization =(String) getSpeci.get("Specialization");
	    	if(list.contains(specilization)) {
	    		continue;
	    	}else {
	    		list.add(specilization);
	    	}
	    }
	    return list;
	}
	public HashMap<Integer, ArrayList<String>> getDoctor(String Specialize) throws FileNotFoundException, IOException, ParseException {
		HashMap<Integer , ArrayList<String>>  map = new HashMap<>();
		ArrayList<String> list1 = new ArrayList<String>();
		ArrayList<String> list2 = new ArrayList<String>();
		File file = new File(doctorFilePath);
		JSONParser parse = new JSONParser();
	    Object obj=parse.parse(new FileReader(file));
	    JSONObject outer = (JSONObject) obj;
	    JSONArray jArr = (JSONArray) outer.get("DoctorList");
	    JSONObject getSpeci;
	    for(int i=0;i<jArr.size();i++) {
	    	getSpeci=(JSONObject) jArr.get(i);
	    	if(getSpeci.get("Specialization").equals(Specialize)) {
	    		list1.add((String)getSpeci.get("DoctorName"));
	    		list2.add((String)getSpeci.get("Availability"));
	    	}
	    }
	    map.put(0, list1);
	    map.put(1,list2);
	    return map;
	}
	@SuppressWarnings({ "unused", "unchecked" })
	public void takeAppointment(String patientName,String patientAge,String visitTime,String DocName) throws FileNotFoundException, IOException, ParseException {
	
		File file = new File(AppointmentPath);
		if(file.length()==0) {
			JSONObject simple = new JSONObject();
			simple.put("DocName", DocName);
			simple.put("patientName", patientName);
			simple.put("patientAge",patientAge);
			simple.put("visitTime", visitTime);
			appointFileArr.add(simple);
			appointFileObj.put("Appointment", appointFileArr);
			writeIntoFile(AppointmentPath,appointFileObj);

		}else {
			JSONParser parse = new JSONParser();
			Object  obj =parse.parse(new FileReader(file));
			JSONObject jsonObj = (JSONObject) obj;
			JSONArray jsonArr = (JSONArray) jsonObj.get("Appointment");
			JSONObject simple = new JSONObject();
			simple.put("DocName", DocName);
			simple.put("patientName", patientName);
			simple.put("patientAge",patientAge);
			simple.put("visitTime", visitTime);
			jsonArr.add(simple);
			appointFileObj.put("Appointment", jsonArr);
			writeIntoFile(AppointmentPath,appointFileObj);
		}
			    
	}
	
	public void search() throws FileNotFoundException, IOException, ParseException {
		
		
		System.out.println("1:To Doctor 2:To Patient");
		int a = sc.nextInt();
		
		switch(a) {
			
		case 1:	System.out.println("1:By Name ,2:By Id ,3:By Specialization");
				int b=sc.nextInt();	
				
					switch(b) {
						
						case 1:System.out.println("Enter name of the doctor ");
							String name = sc.next();
							docSearch(name);
							break;
						case 2:System.out.println("Enter Id of the doctor ");
							String id = sc.next();
							docSearch(id);
							break;
						case 3:System.out.println("Enter Specialization of the doctor ");
							String speci = sc.next
									();
							docSearch(speci);
							break;
						default:	
							System.out.println("Enter correct choice...");
					}
				break;	
		case 2:	System.out.println("1:By Name ,2:By Id ,3:By Mobile num");
				int c=sc.nextInt();
				switch(c) {
				
				case 1:System.out.println("Enter name of the patient ");
					String name = sc.next();
					patientSearch(name);
					break;
				case 2:System.out.println("Enter Id of the patient ");
					String id = sc.next();
					patientSearch(id);
					break;
				case 3:System.out.println("Enter mob of the patient ");
					String mob = sc.next();
					patientSearch(mob);
					break;
				default:	
					System.out.println("Enter correct choice...");
				}
				break;
		default:
			System.out.println("Enter correct choice please...");
		}
	}
	public void docSearch(String choice1) throws FileNotFoundException, IOException, ParseException {
		
		File file  = new File(doctorFilePath);
		JSONParser parse = new JSONParser();
		Object obj = parse.parse(new FileReader(file));
		JSONObject outer = (JSONObject) obj;
		JSONArray jArr = (JSONArray) outer.get("DoctorList");
		JSONObject compareObj;
		for(int i=0;i<jArr.size();i++) {
			
			compareObj=(JSONObject) jArr.get(i);
			String name = (String) compareObj.get("DoctorName");
			String id = (String) compareObj.get("DocId");
			String speci = (String) compareObj.get("Specialization");
			
			if((name.equals(choice1))||(id.equals(choice1))||(speci.equals(choice1))){
				System.out.println(compareObj);
			}
		}
		
	}
	public void patientSearch(String choice2) throws FileNotFoundException, IOException, ParseException {
		File file  = new File(patientFilePath);
		JSONParser parse = new JSONParser();
		Object obj = parse.parse(new FileReader(file));
		JSONObject outer = (JSONObject) obj;
		JSONArray jArr = (JSONArray) outer.get("PatientDetails");
		JSONObject compareObj;
		for(int i=0;i<jArr.size();i++) {
			
			compareObj=(JSONObject) jArr.get(i);
			String name = (String) compareObj.get("PatientName");
			String id = (String) compareObj.get("PatientId");
			String mob = (String) compareObj.get("PatientMob");
			
			if((name.equals(choice2))||(id.equals(choice2))||(mob.equals(choice2))){
				System.out.println(compareObj);
			}
		}
	}
	
}
