package rummy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Hand {
	private ArrayList<Card> cards;

	public Hand(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public boolean isSequence(ArrayList<Card> cards) {
		return true;
	}

	public boolean isNaturalSequence(ArrayList<Card> cards) {
		return true;
	}

	public boolean isTriplet(ArrayList<Card> cards) {
		return areSuitsDifferent(cards) && isRankSame(cards)
				&& cards.size() == 3;
	}

	public boolean isQuad(ArrayList<Card> cards) {
		return areSuitsDifferent(cards) && isRankSame(cards)
				&& cards.size() == 4;
	}

	public boolean isSequenceOfFive(ArrayList<Card> cards) {
		return areSuitsDifferent(cards) && isRankSame(cards)
				&& cards.size() == 5;
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void displayCardsInHand() {
		for (Card card : cards) {
			System.out.print(card.toString() + " ");
		}
	}

	private boolean isRankSame(ArrayList<Card> cards) {
		boolean isRankSame = true;
		Set<Integer> ranks = new HashSet<Integer>();

		for (Card card : cards) {
			if (ranks.isEmpty()) {
				ranks.add(card.getRank());
			} else if (!ranks.contains(card.getRank())) {
				isRankSame = false;
				break;
			}

		}
		return isRankSame;
	}

	private boolean areSuitsDifferent(ArrayList<Card> cards) {
		boolean areSuitsDifferent = true;
		Set<String> suits = new HashSet<String>();

		for (Card card : cards) {
			if (suits.isEmpty()) {
				suits.add(card.getSuit());
			} else if (suits.contains(card.getSuit())) {
				areSuitsDifferent = false;
				break;
			}
		}
		return areSuitsDifferent;
	}
}
