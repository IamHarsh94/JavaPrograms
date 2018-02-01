package com.bridgelabz.programs;
import java.util.Scanner;

class QueueClass<T>{
	private int front;
	private int rear;
	private int size;
	private T arr[];
	
	@SuppressWarnings("unchecked")
	QueueClass(int size){
		this.front =-1;
		this.rear = -1;
		this.size=size;
		arr = (T[]) new Object[size];
	}
	
	public boolean isFull() {
		if(rear==size-1){
			return true;
		}
		return false;
	}
	public boolean isEmpty(){
		if(front==rear){
			return true;
		}else {
			return false;
		}
	}
	public void Enqueue(T ch) {
		if(isFull()) {
			System.out.println("Queue is full");
		}
		else {
			rear++;
			arr[rear] = ch;
		}
	}
	public T Front() {
		front++;
		return arr[front];
	}
	public T rear() {
		return arr[rear--];
	}
	public void Dequeue() {
		if(isEmpty()){
			System.out.println("Queue is empty");
		}
			front++;
	}
	/**
	 * @param Accept len of user input string and for loop will running upto len/2 
	 * take each time front element and compare with rear element 
	 * then pop front and increse rear.   
	 * @return
	 */
	public boolean compare(int length) {
	int len=(length/2)+1;
	int i=0;
	  for( ;i<len;i++) {
		  if(Front()==rear()){
			  Dequeue();
			  rear--;
		  }
		  else {
			  break;
		  }
	  }
	  if(i==len) {
		  return true;
	  }else {
		  return false;
	  }
	
	}
}
/**
 * Create a queue obj and 
 * @author To add a given string in the queue
 *
 */
public class PalindromeChecker {
	public static void main(String []args) {
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter a string :");
		String str = sc.nextLine();
		char ch[]=str.toLowerCase().toCharArray();
		int length = ch.length;
		QueueClass que = new QueueClass(length);
		for(int i=0;i<length;i++) {
			que.Enqueue(ch[i]);
		}
		 if(que.compare(length)) {
			 System.out.println("String is palindrom");
		 }
		 else {
			 System.out.println("String is not palindrom");
		 }
	}
}
