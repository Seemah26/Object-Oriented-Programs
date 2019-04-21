package com.bridgelabz.deckofcards.main;

import com.bridgelabz.deckofcards.implementation.DeckOfCardImplementation;
import com.bridgelabz.deckofcards.manager.DeckOfCardManager;

public class DeckOfCard {

	public static void main(String[] args) {
		DeckOfCardManager card=new DeckOfCardImplementation();
		card.intializeCard();
		card.shuffleCard();
		card.displayCard();
	}

}
