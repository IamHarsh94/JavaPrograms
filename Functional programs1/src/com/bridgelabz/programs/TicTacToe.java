package com.bridgelabz.programs;
import java.util.Scanner;

 class Sample{
	private char [][] board;
	private char currentPlayerChoice;
	
	Sample(){
		Scanner sc =new Scanner(System.in);
		board = new char[3][3];
		System.out.println("Enter choice X or O :");
		char choice = sc.next().charAt(0);
		this.setCurrentPlayerChoice(choice);
		System.out.println("Game Start :");
		initializeBoard();
	}

	/**
	 * To initialize a board with default values (-)
	 */
	public void initializeBoard() {
			
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]='-';
			}
		}
	}
	/**
	 * To Print all board values using 2D array 
	 */
	public void printBoard() {
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(board[i][j]+" | ");
			}
			System.out.println("");
		}
	}
	/**
	 * To enter user mark at perticular position on index basis
	 * @param c
	 */
	public void EnterMark(int r,int c){
	
		if((r>=0)&&(r<3)) {
			if((c>=0)&&(c<3)) {
				if(board[r][c]=='-'){
					board[r][c]=getCurrentPlayerChoice();
				}
			}
		}
	}
	/**
	 * To verify c1 ,c2 and c3 are same or not
	 */
	public boolean checkSame(char c1,char c2,char c3) {
			if((c1!='-')&&(c1!=' ')&&(c1==c2)&&(c2==c3)) {
				return true;
			}
		return false;
	}
	/**
	 * To check each and all rows are same or not on the index basis
	 * if yes then return true or false
	 */
	public boolean checkRow() {
		for(int i=0;i<3;i++) {
			if(checkSame(board[i][0] , board[i][1],board[i][2])==true) {
				return true;
			}
		}
		return false;
	}
	/**
	 * To check each and all column are same or not on the index basis
	 * if yes then return true or false
	 */
	public boolean checkCol() {
		for(int i=0;i<3;i++) {
			if(checkSame(board[0][i],board[1][i],board[2][i])==true) {
				return true;
			}
		}
		return false;
	}
	/**
	 * To check both diagonal same or not by hardcoded values
	 */
	public boolean checkDiago() {
			for(int i=0;i<3;i++){
				if(checkSame(board[0][0],board[1][1],board[2][2])==true || checkSame(board[0][2],board[1][1],board[2][0])==true){
					return true;
				}
			}
		return false;
	}
	public boolean checkWinner() {
			return (checkRow() || checkCol() || checkDiago());
	}
	public void changePlayerStatus() {
		if((getCurrentPlayerChoice()=='X')||(getCurrentPlayerChoice()=='x')) {
			setCurrentPlayerChoice('O');
		}else {
			setCurrentPlayerChoice('X');
		}
	}
	public char getCurrentPlayerChoice() {
		return currentPlayerChoice;
	}

	public void setCurrentPlayerChoice(char currentPlayerChoice) {
		this.currentPlayerChoice = currentPlayerChoice;
	}
}
public class TicTacToe{

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		Sample obj = new Sample();
		obj.printBoard();
		char ch;
		int count=0;
			while(true) {
				
				System.out.println("Player : "+obj.getCurrentPlayerChoice()+"th turn");
				
				System.out.println("Enter position of Row & Column");
				int r = sc.nextInt();
				int c = sc.nextInt();
				obj.EnterMark(r, c);
				obj.printBoard();
				if(obj.checkWinner()) {
					System.out.println(obj.getCurrentPlayerChoice()+" Win the game");
					break;
				}
				obj.changePlayerStatus();
				count++;
				if(count==9) {
					System.out.println("No one win..match draw..");
					break;
				}
			}
			
	}
	
}

