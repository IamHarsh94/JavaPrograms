package com.bridgelabz.programs;
import java.util.Scanner;
import com.bridgelabz.util.Utility;
import com.bridgelabz.util.GenericLinkList;
import com.bridgelabz.util.GenericQueue;
public class QueueAnagram {

	public static void main(String []args){
		int temp[]=new int[180];
		Scanner sc =new Scanner(System.in);
		 
		String str1[] = Calculate.primeNum();
		String str2[] = new String[168];
		
		for(int i=0;i<168;i++) {
			str2[i]=str1[i];
		}
		int count =0;
		
		for(int i=0;i<str1.length;i++) {
			for(int j=i+1;j<str1.length;j++) {
				  if(Utility.isAnagram(str1[i],str2[j])) {
					  
					  	temp[count++]=Integer.valueOf(str1[i]);
					  	temp[count++]=Integer.valueOf(str1[j]);
				  }
			}
		}
	
		GenericQueue link = new GenericQueue<>(158);
		System.out.println("Before insert to Queue...");
		for(int i=0;i<158;i++) {
			System.out.println(temp[i]);
		}
		GenericLinkList list=new GenericLinkList();
		for(int i=0;i<158;i++) {
			list.insertData(temp[i]);
		}
		list.PrintLinkNode(link);
		while(!link.isEmpty()) {
			System.out.println(link.frontEle());
			link.Dequeue();
		}
		
	
	}
}	
	