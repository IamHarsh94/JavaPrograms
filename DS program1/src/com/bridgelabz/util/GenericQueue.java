package com.bridgelabz.util;

public class GenericQueue<T> {

		private int front;
		private int rear;
		private T arr[];
		private int size;
		@SuppressWarnings("unchecked")
		
		public GenericQueue(int size){
			this.size=size;
			this.front=0;
			this.rear =0;
			arr =(T[])new Object[size];
		}
		public boolean isFull() {
			if(rear==size-1){
				return true;
			}else {
				return false;
			}
		}
		public boolean isEmpty() {
			if(front==size){
				return true;
			}
			else {
				return false;
			}
		}
		public void Enqueue(T data) {
			if(isFull()) {
				System.out.println("Queue is full");
			}else {
				
				
				arr[rear++]=data;
				
			}
		} 
		public void Dequeue() {
			if(isEmpty()){
				System.out.println("Queue is empty");
			}else {
				front++;
			}
		}
		public T frontEle() {
			
			return arr[front];
		}
}
