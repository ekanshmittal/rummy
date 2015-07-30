package rummy;

import java.util.List;

public class Card {
	private Integer rank;
	private Character suit;

	public Card(Integer rank, Character suit) {
		this.rank = rank;
		this.suit = suit;
	}

	public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public Character getSuit() {
		return suit;
	}

	public void setSuit(Character suit) {
		this.suit = suit;
	}

	public Card findNextCard() {
		return null;
	}
	
	public List<Card> findAllCardsOfSameSuit(){
		return null;
	}
}
