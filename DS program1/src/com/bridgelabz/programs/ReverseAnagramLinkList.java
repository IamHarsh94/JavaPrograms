package com.bridgelabz.programs;
import java.util.Arrays;
import java.util.Scanner;
import com.bridgelabz.util.Utility;
@SuppressWarnings("hiding")

class GenericStack<LinkNode>{
	public int size;
	public int top;
	LinkNode arr[];
	
	@SuppressWarnings("unchecked")
	GenericStack(int size){
		this.size=size;
		this.top=-1;
		arr= (LinkNode[]) new Object[size];
	}
	
	public boolean isFull() {
		if(top==size-1) {
			return true;
		}
		return false;
	}
	public boolean isEmpty() {
		if(top==-1) {
			return true;
		}
		return false;
	}
	public void push(LinkNode data) {
		if(isFull()) {
			System.out.println("Stack is full");
			System.exit(0);
		}
		else {
			top++;
			arr[top]=data;
		}
	}
	public void pop() {
		if(isEmpty()) {
			System.out.println("Stack is empty");
			System.exit(0);
		}else {
			top--;
		}
	}
	public LinkNode topElement() {
		
		return arr[top];
	}
}
class LinkNode{
    protected int data;
    protected LinkNode next;
   
   LinkNode(int num){
        this.data = num;
        next = null;
    }
}
class LinkList{
	protected LinkNode head;
	   
    LinkList(){
        head = null;
    }
   
    /**
     * @param Accept num to insert and object of GeneicStack
     * 	to create linklist and add push each node into stack. 
     * @param obj
     */
    public void insertNum(int num,GenericStack<LinkNode> obj) {
    	
    	if(head==null) {
    	
    		head= new LinkNode(num);
    		obj.push(head);
    		
    	}else {
    	
    		LinkNode temp=head;
    		while(temp.next!=null) {
    			temp=temp.next;
    		}
    		LinkNode newNode = new LinkNode(num);
    		temp.next=newNode;
    		obj.push(newNode);
    		
    	}
    }
    /**
     * To print all nodes in linklist starting from head.
     */
    public void PrintLinkNode() {
    	
    	LinkNode temp=head;
    	while(temp!=null) {
    		
    		System.out.println(temp.data+" ");
    		temp=temp.next;
    	}
    }
    /**
     * @param To accept obj of stack and print all top element of stack and call pop function
     * till stack will not empty.
     */
    public void reverse(GenericStack<LinkNode> obj) {
    
    	System.out.println(	obj.topElement().data+" ");
    	obj.pop();
    }
}
/**
 * @author To get the all prime numbers and find the anagrams numbers in that
 * and store in the arr. and add each element into linklist.
 *
 */
public class ReverseAnagramLinkList {

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
	
		LinkList link = new LinkList();
		GenericStack<LinkNode> obj = new GenericStack<LinkNode>(158);
		
		
		for(int i=0;i<158;i++) {
			
			System.out.println(temp[i]);
			link.insertNum(temp[i], obj);
		}
		
		System.out.println("Before reverse");
		link.PrintLinkNode();
		System.out.println("After reverse");
		for(int i=0;i<157;i++) {
			link.reverse(obj);
		}
	}
	
}
