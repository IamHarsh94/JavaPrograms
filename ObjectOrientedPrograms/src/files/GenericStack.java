package files;

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