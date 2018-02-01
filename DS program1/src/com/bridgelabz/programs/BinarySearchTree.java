package com.bridgelabz.programs;

import java.util.Scanner;

class MyQueue<TreeNode>{
	private int size;
	private int front;
	private int rear;
	private TreeNode[] arr;
	
	@SuppressWarnings("unchecked")
	MyQueue(){
		this.front=0;
		this.rear=0;
		this.size=20;
		arr=(TreeNode[])new Object[20];
	}	
	@SuppressWarnings("unchecked")
	MyQueue(int size){
		this.front=0;
		this.rear=0;
		this.size=size;
		arr=(TreeNode[])new Object[size];
	}
	public boolean isEmpty() {
		if(front==rear){
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isFull() {
		if(rear==size-1){
			return true;
		}else {
			
			return false;
		}
		
	}
	public void Enqueue(TreeNode data) {
		if(isFull()){
			System.out.println("Queue is full..");
		}
		else{
			arr[rear]=data;
			rear++;
		}
	}
	public void Dequeue() {
		if(isEmpty()){
			System.out.println("Queue is empty..");
		}else {
			front++;
		}
	}
	/**
	 * To get the Front element in each time
	 */
	public TreeNode FrontElem() {
		
		return arr[front];
	}
}

class TreeNode{
	public int data;
	public TreeNode leftNode;
	public TreeNode rightNode;
	
	TreeNode(){
	
		this.leftNode=null;
		this.rightNode =null;
	}
	TreeNode(int data){
		this.data=data;
		this.leftNode=null;
		this.rightNode=null;
	}
}
class BST{
	
	private TreeNode root;
	
	BST(){
		this.root=null;
	}
	
	/**To insert a tree element in the tree in aappropriate position
	 * @param data
	 */
	public void insert(int data) {
		if(root==null){
			root=new TreeNode(data);
		}else {
			TreeNode temp=root;
			TreeNode prev =null;
			while(temp!=null){
				prev=temp;
				if(data>temp.data) {
					temp=temp.rightNode;
				}else {
					temp=temp.leftNode;
				}
			}
			if(data>prev.data) {
				prev.rightNode=new TreeNode(data);
			}else {
				prev.leftNode=new TreeNode(data);
			} 
		}
	}
	/**
	 * To print a tree element by inserting in queue.
	 */
	public void BinarySearch() {
		System.out.println("By Binary search :");
		MyQueue <TreeNode>obj = new MyQueue<TreeNode>();
		obj.Enqueue(root);
		while(!obj.isEmpty()){
			TreeNode top = obj.FrontElem();
			System.out.println(top.data);
			obj.Dequeue();
			if(top.leftNode!=null){
				obj.Enqueue(top.leftNode);
			}
			if(top.rightNode!=null) {
				obj.Enqueue(top.rightNode);
			}
		}
	}
	public void passFun() {
		System.out.println("Inorder traverse");
		inOrder(root);
	}
	/**
	 * To travese the tree by inorder and print the data of each node 
	 * @param root
	 */
	public void inOrder(TreeNode root) {
		
		if(root!=null) {
			
			inOrder(root.leftNode);
			System.out.println(root.data);
			inOrder(root.rightNode);
		}
	}
	
}
/**
 * @author To accept the user element and insert into the tree
 *
 */
public class BinarySearchTree {

	public static void main(String []args) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter Tree Element and press '-1' to break ;");
		BST tree = new BST();
		while(true) {
			int a = sc.nextInt();
			if(a==-1) {
				break;
			}
			tree.insert(a);
		}
		tree.BinarySearch();
		tree.passFun();
	}
}