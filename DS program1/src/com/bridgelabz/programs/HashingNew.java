package com.bridgelabz.programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

import com.bridgelabz.util.GenericLinkList;

public class HashingNew {

	public static void main(String args[]) throws IOException {
		
		GenericLinkList<Integer> gList;
		Scanner sc = new Scanner(System.in);
		File file=null;
		
		ArrayList<Integer> arrlist = new ArrayList<>();
		
	try {
		
		Scanner c  = new Scanner(new File("/home/bridgeit/Documents/newFile.txt"));
		
	        	while(c.hasNext()) {
	        		arrlist.add(c.nextInt());
	        	}
	        	System.out.println(arrlist);	
	        
	        	LinkedHashMap<Integer, GenericLinkList<Integer>> map = new LinkedHashMap<Integer, GenericLinkList<Integer>>();
	    		for (Integer integer : arrlist){
	    			
	    			int slotNo = integer%11;
	    			gList = map.get(slotNo);
	    			if( gList == null )
	    			{
	    				gList = new GenericLinkList<Integer>();
	    				map.put(slotNo, gList);
	    			}
	    			gList.insertData(integer);
	    		}
	    			
	    		System.out.println("Enter Number you want to search ");
	    		int num = sc.nextInt();
	    		int SlotNumber= num%11;
	    			    		
	    		gList = map.get(SlotNumber);
	    		
	    		if(arrlist.contains(num))
	    		{
	    			System.out.println("Number is present so deleted");
	    			gList.remove(num);
	    		}
	    		else
	    		{
	    			System.out.println(num+" is not present so add it");
	    			gList.insertData(num);
	    		}
	    		System.out.println("After operation");
	    		System.out.println("map of :"+ SlotNumber+"th Elements :");
	    		map.get(SlotNumber).PrintLinkNode();
	    		 
	        
		}catch(Exception e)  {
			e.printStackTrace();
		}finally {
			sc.close();
		}
	
	
	}	
}

