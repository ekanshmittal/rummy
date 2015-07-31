package rummy;
import java.util.List;

public class Card implements Comparable<Card>{
	private Integer rank;
	private String suit;
    private String name;
	public Card(Integer rank, String suit) {
		this.rank = rank;
		this.suit = suit;
        this.name = rank + suit;
	}

    public Integer getRank() {
		return rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

	public Card findNextCard() {
		return null;
	}
	
	public List<Card> findAllCardsOfSameSuit(){
		return null;
	}

	public int compareTo(Card o) {
		return Integer.compare(this.rank, o.rank);
	}

    @Override
    public String toString() {
        return name;
    }
}
