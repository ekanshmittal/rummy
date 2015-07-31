package rummy.src.rummy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CardsOperations {
	public CardsOperations() {

	}

	public boolean isSequence(List<Card> cards) {
		return true;
	}

	public boolean isNaturalSequence(List<Card> cards) {
		return true;
	}

	public boolean isTriplet(List<Card> cards) {
		return areSuitsDifferent(cards) && isRankSame(cards)
				&& cards.size() == 3;
	}

	public boolean isQuad(List<Card> cards) {
		return areSuitsDifferent(cards) && isRankSame(cards)
				&& cards.size() == 4;	}

	public boolean isSequenceOfFive(List<Card> cards) {
		return areSuitsDifferent(cards) && isRankSame(cards)
				&& cards.size() == 5;	}

	private boolean isRankSame(List<Card> cards) {
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

	private boolean areSuitsDifferent(List<Card> cards) {
		boolean areSuitsDifferent = true;
		Set<Character> suits = new HashSet<Character>();

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
