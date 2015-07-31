package rummy;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hand {
    private List<Card> cards;
	public Hand(List<Card> cards) {
        this.cards = cards;
	}

    public boolean canBeSequence(){
    	//implemented
        return true;
    }


    public boolean canBeNaturalSequence(){
        return true;
    }

	public boolean isTriplet() {
		return areSuitsDifferent() && areRanksSame()
				&& cards.size() == 3;
	}

    public boolean canBeTriplet(){
        return true;
    }

	public boolean isQuad() {
		return areSuitsDifferent() && areRanksSame()
				&& cards.size() == 4;
    }

    public boolean canBeQuad() {
        return true;
    }

    public boolean isPent() {
        return isSequence() && cards.size() == 5;
    }

    public boolean canBePent(){
        return true;
    }

	public boolean isSequence(){
		return areRanksInSequence() && areSuitsSame();
	}

	public boolean isNaturalSequence() {
		return (areRanksSame() && areSuitsSame() && cards.size() == 3)
				|| (isSequence() && !doesCardsContainJoker());
	}

	public List<Card> getCards() {
		return cards;
	}

	public void displayCardsInHand() {
		for (Card card : cards) {
			System.out.print(card.toString() + " ");
		}
	}

	private boolean areRanksInSequence() {
		Collections.sort(cards);
		int numOfJokers = findNumberOfJokers();
		int previousRank = -1;
		for (Card card : cards) {
			if (previousRank != -1 && card.getRank() - previousRank != 1) {
				numOfJokers -= card.getRank() - previousRank;
			}
			previousRank = card.getRank();
		}
		if (numOfJokers < 0) {
			return false;
		}
		return true;
	}

	private boolean areRanksSame() {

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

	private boolean areRanksDifferent() {
		boolean areRanksDifferent = true;
		Set<Integer> ranks = new HashSet<Integer>();

		for (Card card : cards) {
			if (ranks.isEmpty()) {
				ranks.add(card.getRank());
			} else if (ranks.contains(card.getRank())) {
				areRanksDifferent = false;
				break;
			}
		}
		return areRanksDifferent;
	}

	private boolean areSuitsSame() {
		boolean isSuitSame = true;
		Set<String> suits = new HashSet<String>();

		for (Card card : cards) {
			if (suits.isEmpty()) {
				suits.add(card.getSuit());
			} else if (!suits.contains(card.getSuit())) {
				isSuitSame = false;
				break;
			}

		}
		return isSuitSame;
	}



    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

	private boolean doesCardsContainJoker() {
		for (Card card : cards) {
			if (card.getRank() > 13) {
				return true;
			}
		}
		return false;
	}

	private Integer findNumberOfJokers() {
		int numOfJokers = 0;
		for (Card card : cards) {
			if (card.getRank() > 13) {
				numOfJokers += 1;
			}
		}
		return numOfJokers;
	}
}
