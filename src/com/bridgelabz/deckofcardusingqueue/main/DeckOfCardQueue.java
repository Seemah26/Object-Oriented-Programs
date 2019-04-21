package com.bridgelabz.deckofcardusingqueue.main;

import com.bridgelabz.deckofcardusingqueue.implementation.DeckQueueImplementation;
import com.bridgelabz.deckofcardusingqueue.manager.DeckOfCardkManager;

public class DeckOfCardQueue {

	public static void main(String[] args) {

		DeckOfCardkManager card = new DeckQueueImplementation();

		card.initDeck();

		card.shuffleDeck();

		card.totalDeck();

		card.printDeck();
	}

}
