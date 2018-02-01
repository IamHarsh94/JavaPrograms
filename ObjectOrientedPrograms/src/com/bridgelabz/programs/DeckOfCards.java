package com.bridgelabz.programs;

import com.bridgelabz.util.Utility;

public class DeckOfCards {

	public static void main(String[] args) {
		int noOfPlayers = 4;
		int noOfCards = 9;
	    String[] deckOfCards = Utility.assingCards();
	    String[] deckOfShuffleCards = Utility.shuffle(deckOfCards);
	    String[][] playerCards=Utility.distribute(deckOfShuffleCards,noOfPlayers,noOfCards);
	    
		System.out.println("Cards after sorting...");
		Utility.printSortedCards(playerCards,noOfPlayers,noOfCards);
		Utility.printCardsQueue();
	}

}