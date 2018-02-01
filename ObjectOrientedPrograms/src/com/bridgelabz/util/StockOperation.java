package com.bridgelabz.util;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.bridgelabz.programs.JsonInventory;

import files.CompanyShare;
import files.GenericLinkList;
import files.GenericQueue;

public class StockOperation {
	public static Scanner scanner =new Scanner(System.in);
	public static String fileAddress ="/home/bridgeit/eclipse-workspace/ObjectOrientedPrograms/src/files/Stock.json";
	public static String ClientFile="/home/bridgeit/eclipse-workspace/ObjectOrientedPrograms/src/files/Client.json";
	public static String RecordFile="/home/bridgeit/eclipse-workspace/ObjectOrientedPrograms/src/files/record.json";
	public static Stock stock = new Stock();
	public static CompanyShare comObj = new CompanyShare();
	
	@SuppressWarnings("rawtypes")
	public static GenericLinkList list = new GenericLinkList();
	@SuppressWarnings("rawtypes")
	public static GenericQueue queue = new GenericQueue(10);
	@SuppressWarnings("rawtypes")
	public static Stack stack= new Stack();
	public static long priceOfOneShare=0;
	
	
	public static void addStockDetails(String filepath) throws IOException, ParseException {
		File file = new File(filepath);
		
		System.out.println("Enter Stock name:");
		while(true) {
			String name =scanner.nextLine();
			if(!name.isEmpty()) {
				stock.setStockName(name);
				break;
			}
		}
			
		
		System.out.println("Enter no of Shares:");
		long numshare =scanner.nextLong();
		stock.setNymOfshares(numshare);
		
		System.out.println("Enter price of each share:");
		long price =scanner.nextLong();
		stock.setPriceOfShare(price);
		
		if(file.length()==0) {
			createJsonObj(stock,file);
		}else {
			addToJsonObj(stock,file);
		}
	}
	@SuppressWarnings("unchecked")
	public static void createJsonObj(Stock stock,File file) throws IOException {
		JSONObject Obj = new JSONObject();
		JSONObject outer = new JSONObject();
		JSONArray jsonArr = new JSONArray();
		
		Obj.put("StockName",stock.getStockName());
		Obj.put("NoOfshare", stock.getNymOfshares());
		Obj.put("PriceOfEachShare",stock.getPriceOfShare());
		jsonArr.add(Obj);
		outer.put("Stock", jsonArr);
		WriteIntoFile(outer,file);
	}
	@SuppressWarnings("unchecked")
	public static void addToJsonObj(Stock stock,File file) throws FileNotFoundException, IOException, ParseException {
		JSONObject Obj = new JSONObject();
		JSONObject outer = new JSONObject();
		
		Obj.put("StockName",stock.getStockName());
		Obj.put("NoOfshare",stock.getNymOfshares());
		Obj.put("PriceOfEachShare",stock.getPriceOfShare());
		
		JSONParser parse = new JSONParser();
		Object outerObj = parse.parse(new FileReader(file));
		JSONObject readObj = (JSONObject) outerObj; 
		JSONArray jsonArr = (JSONArray) readObj.get("Stock");
		jsonArr.add(Obj);
		outer.put("Stock",jsonArr); 
		WriteIntoFile(outer,file);
	}
	public static void WriteIntoFile(JSONObject obj,File file) throws IOException {
		FileWriter write = new FileWriter(file);
		write.write(obj.toString());
		write.flush();
	}

	public static void calculateStock(String filePath) throws FileNotFoundException, IOException, ParseException {
		File file =new File(filePath);
		JSONParser parse = new JSONParser();
		Object readObj = parse.parse(new FileReader(file));
		JSONObject outer = (JSONObject) readObj;
		long totalValue=0;
		long total=0;
		JSONArray jsonArr = (JSONArray) outer.get("Stock");
		System.out.println("All the stock are:-");
		for(int i=0;i<jsonArr.size();i++) {
			 System.out.println(jsonArr.get(i));
		}
		System.out.println("value of each stock:-");
		for(int i=0;i<jsonArr.size();i++) {
		   JSONObject simple =(JSONObject) jsonArr.get(i);
		   total=(long)simple.get("NoOfshare")*(long)simple.get("PriceOfEachShare");
		   System.out.println("Value of "+simple.get("StockName")+" is "+total);
		   totalValue=totalValue+total;
		}
		System.out.println("Total vlaue is:- "+totalValue);
	}
	
	public static void createAccount() throws IOException {
	
		System.out.println("Enter User file name:");
		String path = scanner.nextLine();
		stock.setFilePath(path);
		File file = new File(stock.getFilePath());
		if(file.exists()) {
			System.out.println("file is already present.... give another name:");
			createAccount();
		}else {
			if(file.createNewFile())
				System.out.println("File is created...");
		}
	}
	
	public static CompanyShare buyStocks() throws FileNotFoundException, IOException, ParseException {
		Scanner sc = new Scanner(System.in);
		CompanyShare data=null;
		JSONObject StockInfo =null;
		printStock();
		System.out.println("Enter name of the stock..you want to buy..");
		String stockName;
		
		stockName =sc.nextLine();
			
	
		System.out.println("stockName :"+stockName);
		
		StockInfo = SearchStock(stockName,fileAddress);
		char ch;
		if(StockInfo!=null) {
			CompanyShare compshare = buy(StockInfo,stockName); // object return
			data=compshare;
		}else {
			System.out.println("Sorry this stock is not present..");
			System.out.println("Would you like to buy another stock y/Y");
			ch = scanner.next().charAt(0);
			if(ch=='y'||ch=='Y') {
				buyStocks();
			}else {
				System.out.println("Thank you..");
			}
		}
		
		return data;
	}
	
	public static void printStock() throws FileNotFoundException, IOException, ParseException {
		JSONParser parse = new JSONParser();
		Object obj = parse.parse(new FileReader(fileAddress));
		JSONObject outerObj = (JSONObject) obj;
		JSONArray jsonArr = (JSONArray) outerObj.get("Stock");
		System.out.println("present stocks are...");
		for(int i=0;i<jsonArr.size();i++) {
			JSONObject Jobj=(JSONObject) jsonArr.get(i);
			System.out.println(Jobj.toString());
		}
	}
	
	public static JSONObject SearchStock(String stockName,String fileAddress) throws FileNotFoundException, IOException, ParseException {
		JSONObject data = null;
		JSONParser parse = new JSONParser();
		File file = new File(fileAddress);
		 Object JObj = parse.parse(new FileReader(file));
		 JSONObject outerObj = (JSONObject) JObj;
		 
		JSONArray jsonArr = (JSONArray) outerObj.get("Stock"); 
		for(int i=0;i<jsonArr.size();i++) {
			System.out.println("then here");
			JSONObject jObj=(JSONObject) jsonArr.get(i);
			if(jObj.get("StockName").equals(stockName)) {
				data=jObj;
				break;
			}
		}
		System.out.println("return statement");
		return data;
	}
	@SuppressWarnings("unchecked")
	public static CompanyShare buy(JSONObject StockInfo,String stockName) throws FileNotFoundException, IOException, ParseException {
		CompanyShare compshare  = null;
		System.out.println("Enter unique symbol");
		String symbol = scanner.nextLine();
		System.out.println("How many share you want to buy:");
		int share = scanner.nextInt();
		
		long price =(long)StockInfo.get("PriceOfEachShare");
		if((long)StockInfo.get("NoOfshare")==0)
		{
			System.out.println("SorrystockName "+StockInfo.get("StockName")+" share already buyed..");
		}
		else if((long)StockInfo.get("NoOfshare")>=share)
		{
			
			priceOfOneShare = price/(long)StockInfo.get("NoOfshare");
			long clientSharePrice=share*priceOfOneShare;
			long remainingShares = (long)StockInfo.get("NoOfshare")-share;
			long constantDataPrice=priceOfOneShare*remainingShares;
			
			UpdateShare(remainingShares,StockInfo,constantDataPrice);
			
			Date dt = new Date(); 
			SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
			String date = formate.format(dt);
			String status="Purchased";
			compshare =new CompanyShare(stockName, symbol, share, constantDataPrice,date,status);
			
			list.insertData(compshare);
			queue.Enqueue(date);
			stack.push("purchased");
			
			System.out.println("share purches successfully");
			
			File file = new File(ClientFile);
			FileWriter fw = new FileWriter(ClientFile);
			if(file.length()==0) {
				JSONObject simple = new JSONObject();
				JSONArray jArr = new JSONArray();
				JSONObject outer = new JSONObject();
				simple.put("StockName",StockInfo.get("StockName"));
				simple.put("NoOfshare",share);
				simple.put("PriceOfEachShare",clientSharePrice);
				jArr.add(simple);
				outer.put("StockDetails", jArr);
				fw.write(outer.toString());
				fw.flush();
			}
			else {
				JSONParser parse = new JSONParser();
				Object obj=parse.parse(new FileReader(file));
				JSONObject outer= (JSONObject) obj;
				
				JSONObject simple = new JSONObject();
				simple.put("StockName",StockInfo.get("StockName"));
				simple.put("NoOfshare",share);
				simple.put("PriceOfEachShare",clientSharePrice);
				JSONArray jArr = (JSONArray) outer.get("StockDetails");
				jArr.add(simple);
				outer.put("StockDetails", jArr);
				fw.write(outer.toString());
				fw.flush();
			}
			System.out.println("Client data updated...");
		}
		else {
			System.out.println("Only "+StockInfo.get("NoOfshare")+" Stock of "+StockInfo.get("StockName")+" is remaining");
		}
		return compshare;
	
		
	}
	
	
	@SuppressWarnings("unchecked")
	public static void UpdateShare(long remainShare,JSONObject StockInfo,long price1) throws FileNotFoundException, IOException, ParseException {
		
		File file = new File(fileAddress);
			
		if(file.length()==0) {
			System.out.println("Constant data not available..");
		}else {
			
			JSONParser parse = new JSONParser();
			Object Jobj = parse.parse(new FileReader(file));
			JSONObject outer = (JSONObject) Jobj;
			JSONArray jARR = (JSONArray) outer.get("Stock");
			JSONObject obj;
			for(int i=0;i<jARR.size();i++) {
				obj=(JSONObject) jARR.get(i);
				
				if(obj.get("StockName").equals(StockInfo.get("StockName"))) {
				
					obj.put("NoOfshare", remainShare);
					obj.put("PriceOfEachShare", price1);
				}
			}
			
			JSONObject outerNew = new JSONObject();
			outerNew.put("Stock",jARR);
			
			FileWriter fw  = new FileWriter(file);
			fw.write(outerNew.toString());
			fw.flush();
			System.out.println("Constant data updated...");
		}
	}
	
	public static void updateConstantData() {
		
	}
	@SuppressWarnings("unchecked")
	public static void saveUserFile(CompanyShare comshare) throws FileNotFoundException, IOException, ParseException {
		
		File file = new File(RecordFile);
		
		JSONObject simple = new JSONObject();
		simple.put("Stock Simbol",comshare.getStockSymbol());
		simple.put("StockName",comshare.getStockName());
		simple.put("NoOfshare",comshare.getNoOfShares());
		simple.put("PriceOfEachShare",comshare.getPrice());
		simple.put("Transaction Status",comshare.getStatus());
		simple.put("Date and Time",comshare.getDateTime());
		
		if(file.length()==0) {
			creatObj(simple,file);
		}
		else {
			
			addObj(simple,file);
		}
	}
	@SuppressWarnings("unchecked")
	public static void creatObj(JSONObject simple,File file) throws IOException {
		
		JSONObject outer = new JSONObject();	
		JSONArray jArr = new JSONArray();
		jArr.add(simple);
		outer.put("StockDetails", jArr);
		
		FileWriter fw = new FileWriter(file);
		fw.write(outer.toString());
		fw.flush();
	}
	@SuppressWarnings("unchecked")
	public static void addObj(JSONObject simple,File file) throws IOException, ParseException {
		
		JSONParser parse = new JSONParser();
		Object obj = parse.parse(new FileReader(file));
		JSONObject outer = (JSONObject) obj;
		JSONArray jArr = (JSONArray) outer.get("StockDetails");
		jArr.add(simple);
		outer.put("StockDetails",jArr);
		
		FileWriter fw = new FileWriter(file);
		fw.write(outer.toString());
		fw.flush();
	}
	
//////////////////////////////////////////////////////////////////////////////////////
	
	public static void sell() throws FileNotFoundException, IOException, ParseException {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a file name :");
		String fileName = sc.nextLine();
		String filePath="/home/bridgeit/eclipse-workspace/ObjectOrientedPrograms/src/files/"+fileName+".json";
		System.out.println("Enter a stock name to sell :");
		String stockName = sc.nextLine();
		
		boolean status = ToSearchStock(stockName,filePath);
		if(status) {
			System.out.println("Enter num of share to sell");
			int noOfShare = sc.nextInt();
			boolean flag=ToValidateShare(noOfShare,stockName,filePath);
			if(flag) {
					System.out.println("At how much price you want to sell your share");
					long sharePrice = sc.nextLong();
					
				boolean flag1=ToUpdate(noOfShare,sharePrice,stockName,filePath);
					if(flag1) {
						
						System.out.println("Selling successfully done..");
						
						
						
						
						
						
					}else {
						System.out.println("Client data not update...");
					}
					
			}else {
				System.out.println("Sorry u haven't this much share to sell..Do you want to sell again press :1");
				int b=scanner.nextInt();
				if(b==1) {
					sell();
				}
				else {
					System.out.println("Thank you...");
					return;
				}
			}
		}
		else {
			System.out.println("This stock is not present..like to sell another press :1");
			int a = scanner.nextInt();
			if(a==1) {
				sell();
			}
			System.out.println("Thank you...");
			return;
		}
	}
	
	public static boolean ToValidateShare(int noOfShare,String stockName,String filePath) throws FileNotFoundException, IOException, ParseException {
		boolean flag=false;
		File file = new File(filePath);
		JSONParser parse = new JSONParser();
		Object obj =parse.parse(new FileReader(file));
		JSONObject jOBJ = (JSONObject) obj;
		JSONArray jARR = (JSONArray) jOBJ.get("StockDetails");
		for(int i=0;i<jARR.size();i++) {
			JSONObject jsonObj = (JSONObject) jARR.get(i);
			if(jsonObj.get("StockName").equals(stockName)) {
				if((long)jsonObj.get("NoOfshare")>=noOfShare) {
					flag=true;
				}
			}
		}
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean ToUpdate(int noOfShare,long sharePrice,String stockName,String filePath) throws FileNotFoundException, IOException, ParseException {
		
		File file = new File(filePath);
		boolean flag=false;
		if(file.length()==0) {
			System.out.println("Client file empty..");
			System.exit(0);
		}else {
						
			long remShare;
			JSONParser parse = new JSONParser();
			Object obj =parse.parse(new FileReader(file));
			JSONObject outer = (JSONObject) obj;
			JSONArray Jarr = (JSONArray) outer.get("StockDetails");
			JSONObject ObjLoop;
			for(int i=0;i<Jarr.size();i++) {
				ObjLoop=(JSONObject) Jarr.get(i);
				if(ObjLoop.get("StockName").equals(stockName)) {
					 remShare=(long)ObjLoop.get("NoOfshare")-noOfShare;
					 long newPrice = noOfShare*sharePrice;
					 ObjLoop.put("NoOfshare", remShare);
					 ObjLoop.put("PriceOfEachShare",newPrice);
				}
			}
			JSONObject outerNew = new JSONObject();
			outerNew.put("StockDetails",Jarr);
			FileWriter fw = new FileWriter(file);
			fw.write(outerNew.toString());
			fw.flush();
			flag=true;
			
			stockDataUpdate(noOfShare,sharePrice,stockName);
			
		}
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public static void stockDataUpdate(int noOfShare,long sharePrice,String stockName) throws IOException, ParseException {
		Scanner sc = new Scanner(System.in);
		File file = new File(fileAddress);
				if(file.length()==0) {
			System.out.println("Stock data empty...");
		}else {
			System.out.println("Enter a Stock Symbol");
			String symbol = sc.nextLine();
			comObj.setStockSymbol(symbol);
			
			Date dt=new Date();
			SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yyyy - hh:mm");
			String date=formate.format(dt);
			JSONParser parse = new JSONParser();
		 	Object obj = parse.parse(new FileReader(file));
		 	JSONObject jsonOBJ = (JSONObject) obj;
		 	JSONObject temp;
		 	JSONArray Jarr = (JSONArray) jsonOBJ.get("Stock");
		 	for(int i=0;i<Jarr.size();i++) {
		 		temp=(JSONObject) Jarr.get(i);
		 		if(temp.get("StockName").equals(stockName)) {
		 				
		 		long totalShare=(long)temp.get("NoOfshare")+noOfShare;
		 		long priceToMinus =sharePrice*noOfShare;
		 		long remPrice =(long)temp.get("PriceOfEachShare")-priceToMinus;	
		 			temp.put("NoOfshare", totalShare);
		 			temp.put("PriceOfEachShare", remPrice);
		 			comObj.setStockName((String)temp.get("StockName"));
		 			comObj.setNoOfShares((int)totalShare);
		 			comObj.setDate(date);
		 			comObj.setPrice(remPrice);
		 			comObj.setStatus("sell");
		 		}
		 	}
		 	JSONObject outer = new JSONObject();
		 	 outer.put("Stock",Jarr);
		 	 
		 	 FileWriter fw = new FileWriter(file);
		 	 fw.write(outer.toString());
		 	 fw.flush();
		 	 System.out.println("Stock update successfully");
		}	
	}
	public static boolean ToSearchStock(String stockName,String filePath) throws FileNotFoundException, IOException, ParseException {
		boolean flag=false;
		JSONParser parse = new JSONParser();
		File file = new File(fileAddress);
		 Object JObj = parse.parse(new FileReader(file));
		 JSONObject outerObj = (JSONObject) JObj;
		 
		JSONArray jsonArr = (JSONArray) outerObj.get("Stock"); 
		for(int i=0;i<jsonArr.size();i++) {
			System.out.println("then here");
			JSONObject jObj=(JSONObject) jsonArr.get(i);
			if(jObj.get("StockName").equals(stockName)) {
				
				flag=true;
			}
		}
		System.out.println("return statement");
		return flag;
	}
	
	@SuppressWarnings("unchecked")
	public static void save() throws FileNotFoundException, IOException, ParseException {
		list.insertData(comObj);
		queue.Enqueue(comObj.getDate());
		stack.push("sell");
		
		File file = new File(RecordFile);
	
	FileWriter fw = new FileWriter(RecordFile);
		if(file.length()==0) {
			JSONObject simple = new JSONObject();
			JSONArray jArr = new JSONArray();
			JSONObject outer = new JSONObject();
			simple.put("StockName",comObj.getStockName());
			simple.put("NoOfshare",comObj.getNoOfShares());
			simple.put("PriceOfEachShare",comObj.getPrice());
			simple.put("Transaction Status",comObj.getStatus());
			simple.put("Stock Simbol",comObj.getStockSymbol());
			simple.put("Date and Time",comObj.getDateTime());
			jArr.add(simple);
			outer.put("StockDetails", jArr);
			fw.write(outer.toString());
			fw.flush();
		}
		else {
			JSONParser parse = new JSONParser();
			Object obj=parse.parse(new FileReader(file));
			JSONObject outer=(JSONObject) obj;
			
			JSONObject simple = new JSONObject();
			simple.put("StockName",comObj.getStockName());
			simple.put("NoOfshare",comObj.getNoOfShares());
			simple.put("PriceOfEachShare",comObj.getPrice());
			simple.put("Transaction Status",comObj.getStatus());
			simple.put("Stock Simbol",comObj.getStockSymbol());
			simple.put("Date and Time",comObj.getDateTime());
			JSONArray jArr = (JSONArray) outer.get("StockDetails");
			jArr.add(simple);
			JSONObject newOuter= new JSONObject(); 
			newOuter.put("StockDetails", jArr);
			fw.write(newOuter.toString());
			fw.flush();
		}
		System.out.println("record data updated...");
	}
}
