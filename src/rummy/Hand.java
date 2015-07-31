package rummy.src.rummy;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hand {
    private List<Card> cards;
	public Hand(List<Card> cards) {
        this.cards = cards;
	}

	public boolean isSequence() {
		return true;
	}

    public boolean canBeSequence(){
        return true;
    }

	public boolean isNaturalSequence() {
		return true;
	}

    public boolean canBeNaturalSequence(){
        return true;
    }

	public boolean isTriplet() {
		return areSuitsDifferent() && isRankSame()
				&& cards.size() == 3;
	}

    public boolean canBeTriplet(){
        return true;
    }

	public boolean isQuad() {
		return areSuitsDifferent() && isRankSame()
				&& cards.size() == 4;	}

    public boolean canBeQuad() {
        return true;
    }

	public boolean isPent() {
		return areSuitsDifferent() && isRankSame()
				&& cards.size() == 5;
    }

    public boolean canBePent(){
        return true;
    }

	private boolean isRankSame() {
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

	private boolean areSuitsDifferent() {
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

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
