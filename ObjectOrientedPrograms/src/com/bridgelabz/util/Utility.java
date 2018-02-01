package com.bridgelabz.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import files.GenericQueue;

public class Utility {

	@SuppressWarnings("rawtypes")
	public static GenericQueue queue = new GenericQueue(35);
	@SuppressWarnings("static-access")
	public static String replaceMent(String message,String strToBeReplace,String replceStr) {
		String msg = message;
		Pattern pat = Pattern.compile(strToBeReplace);
		Matcher matcher = pat.matcher(msg);
		while(matcher.find()) {
			message = matcher.replaceAll(matcher.quoteReplacement(replceStr));
		}
		return message;
	}
	
	public static String[] assingCards() {
		String[] card = { "Club", "Diamond", "Heart", "Spade" };
		String[] rank = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		String[] deckOfCards = new String[52];
		int index = 0;
		for (int i = 0; i < card.length; i++) {
			for (int j = 0; j < rank.length; j++) {
				deckOfCards[index++] = card[i] + " " + rank[j];
			}
		}
		
		System.out.println("Before shuffle :");
		for(int i=0;i<deckOfCards.length;i++) {
			System.out.println(deckOfCards[i]);
		}
		
		
		return deckOfCards;
	}
	
	public static String[] shuffle(String[] deckCards) {
		for (int i = 0; i < deckCards.length; i++) {
			int random = (int) (Math.random() * (52));
			String temp = deckCards[i];
			deckCards[i] = deckCards[random];
			deckCards[random] = temp;
		}
		System.out.println("After shuffle :");
		for(int i=0;i<deckCards.length;i++) {
			System.out.println(deckCards[i]);
		}
		
		return deckCards;
	}
	
	public static String[][] distribute(String[] deckOfShuffleCards, int noOfPlayers, int noOfCards) {
		int index = 0;
		String[][] distributedCards = new String[noOfPlayers][noOfCards];
		for (int i = 0; i < noOfPlayers; i++) {
			for (int j = 0; j < noOfCards; j++) {
				distributedCards[i][j] = deckOfShuffleCards[index++];
			}
		}
		
		System.out.println("After distribute :");
		int count=1;
		for (int i = 0; i < noOfPlayers; i++) {
			
			System.out.println(" "+count+++" Player cards:");
			for (int j = 0; j < noOfCards; j++) {
				System.out.println(" "+distributedCards[i][j]);
			}
			System.out.println("");
		}
		
	return distributedCards;
	}

	@SuppressWarnings("unchecked")
	/*public static void printSortedCards(String[][] playerCards, int noOfPlayers, int noOfCards) {
		
		String[] cards = new String[noOfCards];
		
		for (int i = 0; i < noOfPlayers; i++) {
			
			for (int j = 0; j < noOfCards; j++) {
				
				cards[j] = playerCards[i][j];
			}
			
			queue.Enqueue(" "+(i+1)+"Player card :");
			sortCards(cards);
		}
		printCardsQueue();
	}
	
	@SuppressWarnings("unchecked")
	private static void sortCards(String[] cards) {
		String[] order = { "Ace","2", "3","4","5","6","7","8","9","10","Jack","Queen","King"};
	
		for (int i = 0; i < order.length; i++) {
			for (int j = 0; j < cards.length; j++) {
			
				if (cards[j] == order[i]) {
					queue.Enqueue(cards[j]);
					System.out.println("here");
				}
			}
		}
	}*/
	public static void printSortedCards(String[][] playerCards, int noOfPlayers, int noOfCards) {
		String[] cards = new String[noOfCards];
		for (int i = 0; i < noOfPlayers; i++) {
			for (int j = 0; j < noOfCards; j++) {
				cards[j] = playerCards[i][j];
			}
			queue.Enqueue("Cards Of Player " + (i + 1) + " are as follows..");
			sortCards(cards);
		}
	
	}
	private static void sortCards(String[] cards) {
		char[] rank = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'J', 'Q', 'K' };
		for (int i = 0; i < rank.length; i++) {
			for (int j = 0; j < cards.length; j++) {
				String card = cards[j];
				char cardRank = card.charAt(card.length() - 1);
				if (cardRank == rank[i])
					queue.Enqueue(card);
			}
		}
	}
	public static void printCardsQueue() {
		for(int i=0;i<60;i++) {
			System.out.println(queue.frontEle());
			queue.Dequeue();
		}
	}
}
