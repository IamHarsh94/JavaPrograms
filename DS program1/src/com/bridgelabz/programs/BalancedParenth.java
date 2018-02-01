package com.bridgelabz.programs;

import java.util.Scanner;
class Stack<T>{
	public int size;
	public int top;
	T arr[];
	
	Stack(int size){
		this.size=size;
		this.top=-1;
		arr= (T[]) new Object[size];
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
	public void push(T data) {
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
	public T top() {
		
		return arr[top];
	}

	
}

/**
 * @author Insert all opening brackets in stack and pop it by checking each top element of stack
 * and expression bracket
 *
 */
public class BalancedParenth{
	
	
	public static void main(String args[]){
		
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter a expression");
		String exp = sc.nextLine();
		int length = exp.length();
		Stack Jstack = new Stack(length);
			
		for (int i = 0; i < exp.length(); i++) {
			char ch = exp.charAt(i);
				if (ch == '[' || ch == '(' || ch == '{') {
					Jstack.push(ch);
				} 
				else if((ch == ']' || ch == '}' || ch == ')')&&(!Jstack.isEmpty()))
				{
						
					if (( (char)Jstack.top() =='(' && ch == ')')|| ((char) Jstack.top() == '{' && ch == '}')|| ((char) Jstack.top() == '[' && ch == ']')) {
						Jstack.pop();
					}
					else{
						System.out.println("Not balance");
						return;
					}
				}
				else
				{
					if((ch == ']' || ch == '}' || ch == ')')) {
						System.out.println("Not balance");
						break;
					}
				}
			}

		if (Jstack.isEmpty()) {
			System.out.println("Balance parenthesis");
		}
		else {
			System.out.println("Not balance");
		}
	}	
}