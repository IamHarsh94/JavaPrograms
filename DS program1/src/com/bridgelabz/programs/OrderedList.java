package com.bridgelabz.programs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

class NodeCreate{
	
	char data;
	NodeCreate next;
	NodeCreate(char data){
		this.data =data;
		this.next =null;
	}
}
class linkListcreate{
	private NodeCreate head;
	static int count=0;
	linkListcreate(){
		head = null;
	}
	
	public void insertData(char no) {
		if(head==null) {
			 head = new NodeCreate(no);
		}
		else {
			NodeCreate temp = head;
			while(temp.next!=null) {
				
				temp = temp.next;
			}
		
			 temp.next = new NodeCreate(no);
		}
	}
	public void PrintList() {
		if(head==null) {
			System.out.println("List is Empty :");
			System.exit(0);
		}
		else {
			NodeCreate temp = head;
			while(temp!=null) {
				System.out.print(temp.data+" ");
				temp = temp.next;
			}
		}
	}
	public int search(char num) {
		int c=0;
        NodeCreate temp = head;
            while(temp!=null) {
                if(temp.data==num){
                   c++;
                }   
                temp = temp.next;
            }
        return c; 
	}
	/**
	 * @param Accept a num to remove from the list.
	 */
	public void remove(char num) {
		
		if(head.data==num) {
			
			head = head.next;
			
		}
		else{
		
			NodeCreate prev=null;
			NodeCreate temp = head.next;
			while(temp.data!=num){
				prev =temp;
				temp = temp.next;
			}
			prev.next=temp.next;
			temp=null;
		}
		
	}
	/**
	 * @param Accept num and insert a right position in the .linklist
	 */
	public void InsertRightPosition(char num) {
		
		if(num<head.data) {
			
			NodeCreate temp = new NodeCreate(num);
			temp.next =head;
			head=temp;
		}
		else {
			boolean flag = true;
			NodeCreate prev=head;
			NodeCreate temp=head.next;
			while(temp!=null) {
				
				if(num>temp.data) {
			
					prev=temp;
					temp=temp.next;
				}
				else {
			
					NodeCreate newNode = new NodeCreate(num);
					newNode.next=temp;
					prev.next=newNode;
					flag=false;
					break;
				}
			}
			if(flag) {
				NodeCreate temp1 = head;
				while(temp1.next!=null) {
					temp1 = temp1.next;
				}
				temp1.next =new NodeCreate(num); 
			}
		}
		
	}
	
	/**
	 * @param To write a each num in the file.
	 * @return
	 * @throws IOException
	 */
	public FileWriter writeFile(FileWriter fr) throws IOException {
		if(head==null) {
			System.out.println("List is Empty :");
			System.exit(0);
		}
		else {
			NodeCreate temp = head;
			while(temp!=null) {
				fr.write(temp.data+" ");
				temp = temp.next;
			}
		}
		return fr;
	}
}
/**
 * @param To read the integers from the file and sort
 * and take user input to search a num if num present in file then delete it otherwisw add it in right position.
 */
public class OrderedList{

	@SuppressWarnings("resource")
	public static void main(String []args) throws IOException {
		Scanner sc = new Scanner(System.in);
		File file=null;
		BufferedReader br =null;
		linkListcreate insert = new linkListcreate();
		try {
			file = new File("/home/bridgeit/Documents/Integer.txt");
			br = new BufferedReader(new FileReader(file));
			String line;
	        System.out.println("read the integers from the file and sort :");	
			while((line = br.readLine())!=null) {
	       
	        		String str= line;
	        		
	        		char SortArr[] = bubbleSort(str);
	        		int length = SortArr.length;
	        	for(int i=0;i<length;i++) {
	        		if(SortArr[i]==' ') {
	        			continue;
	        		}else {
	        			
	        			insert.insertData(SortArr[i]);
	        		}
	        	}
	        	
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			br.close();
		}  	
	        insert.PrintList(); 
	        System.out.println("");
	        System.out.println("Enter a element to search :");
	        char num=' ';
	        String strNo = sc.nextLine();
	        if(strNo.length()==1) {
	        	num = strNo.charAt(0);
	        }
	        else if(strNo.length()==2){
	        	char n = (char) (strNo.charAt(0)*(char)10);
	        		num = (char) (n+strNo.charAt(1));
	        }
	         int ch = insert.search(num);
	         /**
	          * @author 
	          *
	          */
	        if(ch==0) {
	        	System.out.println("Num is Not present in a list So we insert it");
	        	insert.InsertRightPosition(num);
	        	System.out.println("After insert :");
	        	insert.PrintList();
	          }
	        else{
	        	System.out.println(ch+" Times num present in a list & we delete it");
	        	for(int i=0;i<ch;i++) {
	        		insert.remove(num);
	        	}
	        	
	        }
	        FileWriter fr =null;
	        FileWriter fr1 =null;
	        try {
	            File writeFile = new File("/home/bridgeit/Documents/Integer.txt");
	            fr = new FileWriter(writeFile);
	            fr1 = insert.writeFile(fr);
	            System.out.println("");
	             System.out.println("updated list successfully added in file :");
	             
	        }catch(Exception e) {
	            e.printStackTrace();
	        }finally {
	            fr.close();
	            fr1.close();
	        }
	           
	     }
	/**
	 * @param To sort a char[] using bubble sort.
	 */
	public static char[] bubbleSort(String str){
		
		char charArr[] = str.toCharArray();  
		int size = charArr.length;
		
		for(int i=0;i<size-1;i++) {
			int flag = 0;
			for(int j=0;j<size-1;j++) {
				
				if(charArr[j]>charArr[j+1]) {
					flag = flag+1;
					char temp = charArr[j];
					charArr[j] = charArr[j+1];
					charArr[j+1] = temp;
				}
			} 
			if(flag==0){
				break;
			}
		}
		return charArr;
		
	}
}
