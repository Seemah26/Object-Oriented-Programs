package com.bridgelabz.deckofcardusingqueue.implementation;
import com.bridgelabz.deckofcardusingqueue.manager.DeckOfCardkManager;
import com.bridgelabz.util.Queue;
import com.bridgelabz.util.Util;

public class DeckQueueImplementation implements DeckOfCardkManager {

	
	String[] Suits = { "Clubs", "Diamonds", "Hearts", "Spades" };

	String[] Ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
	int n = Suits.length * Ranks.length;
	String[] deck = new String[n];
	Queue<Queue<String>> mainQueue = new Queue<Queue<String>>();
	Queue<String> queueLinkedList = new Queue<String>();
	@Override
	public void initDeck() {
		for (int i = 0; i < Ranks.length; i++) {
			for (int j = 0; j < Suits.length; j++) {
				deck[Suits.length * i + j] = Ranks[i] + "" + Suits[j];
	}
		}
	}
	@Override
	public void shuffleDeck() {
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
	}
	}
	@Override
	public void printDeck() {
		for (int i = 0; i < mainQueue.getSize(); i++) {
			Queue<String> queue2 = mainQueue.remove();
			System.out.println("---------------------------------------- Person " + (i + 1)
					+ " -------------------------------------------");
			for (int j = 0; j < queue2.getSize(); j++) {
				System.out.print(queue2.remove() + " ");
			}
			System.out.println();
		}
	}
	@Override
	public void totalDeck() {
		System.out.println("Total number of deck of cards are " + deck.length);
		for (int i = 0; i < 4; i++) {
			String[] demo = new String[9];
			for (int j = 0; j < 9; j++) {
				demo[j] = deck[i + j * 4];
			}

			String[] str2 =Util.bubble(demo);
			for (int k = 0; k < str2.length; k++) {
				queueLinkedList.insert(str2[k]);
			}
			mainQueue.insert(queueLinkedList);
			queueLinkedList = new Queue<String>();
			continue;
	}
	}
	
	

}