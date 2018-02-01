package com.bridgelabz.programs;

import java.util.Scanner;

class Queue<T>
{
	private int front;
	private int rear;
	private int arr[];
	private int size;
	private int people;
	@SuppressWarnings("unchecked")
	Queue(int size,int people){
		this.size=size;
		this.front=0;
		this.rear =people;
		 
		arr =  new int[size];
		System.out.println("Queue is ready :");
	}
	public boolean isFull() {
		if(rear==size){
			return true;
		}else {
			return false;
		}
	}
	public boolean isEmpty() {
		if(front==rear){
			return true;
		}
		else {
			return false;
		}
	}
	public void Enqueue() {
		if(isFull()) {
			System.out.println("Queue is full");
		}else {
			
			rear = rear+1;
			
		}
	} 
	public void Dequeue() {
		if(isEmpty()){
			System.out.println("Queue is empty");
		}else {
			front++;
		}
	}
	public int NumOfPeople(){

		int NO =rear-front;
	
		return NO;
	}
}
/**
 * @author To create queue of user choice and bank cash counter.. 
 * each person transaction will diplay and after completing transaction pop it..
 * each person also able to add new person in queue and remove. 
 *
 */
public class BankingCashCounter 
{
	private static int BankBalance = 100000;
	
	public static void main(String args[]) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a size of queue");
		int size = sc.nextInt();
		System.out.println("Enter num of people in queue");
		int people = sc.nextInt();
		Queue obj = new Queue(size,people);
		int count=1;
		while(count<=people) {
			boolean flag;
			System.out.println(".*.*.*.*."+count+++" Person Transaction running ..*.*.*.*.");
			do {
				
				System.out.println("1:Deposite 2:Widrawdata 3:check bank balance 4:check num.of person in queue 5:Dequeue person 6:Add person in queue");
				int choice = sc.nextInt();
				if(choice==1) {
					System.out.println("Enter deposite money :");
					int money = sc.nextInt();
					BankBalance=BankBalance+money;
					System.out.println("BankBalance is :"+BankBalance);
				}
				else if(choice==2) {
					System.out.println("Enter widraw amount");
					int widraw = sc.nextInt();
					if(widraw>BankBalance) {
						System.out.println("Sorry insufficient balance");
					}
					else {
						BankBalance =BankBalance-widraw;
						System.out.println("BankBalance is :"+BankBalance);
					}
				}
				else if(choice==3){
					System.out.println("Current balance is: "+BankBalance);
				}
				else if(choice==4) {
					int NumOfPeople=obj.NumOfPeople();
					System.out.println("Num of people in queue "+NumOfPeople);
				}
				else if(choice==5){
					obj.Dequeue();
					int NumOfPeople=obj.NumOfPeople();
					System.out.println("Num of person remaining in queue "+NumOfPeople);
				}
				else if(choice==6){
					obj.Enqueue();
					int NumOfPeople=obj.NumOfPeople();
					System.out.println("Num of person remaining in queue "+NumOfPeople);
				}
				else {
					System.out.println("Wrong choice");
					System.exit(0);
				}
				System.out.println("Want to do another transaction 'true' or 'false'");
				flag = sc.nextBoolean();
			}while(flag);
			obj.Dequeue();
		}
	}
}
