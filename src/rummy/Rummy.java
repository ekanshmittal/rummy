package rummy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Rummy {
	private String[] allRanks = { "Ace", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "Jack", "Queen", "King","Joker" };

	private String[] allSuits = { "heart", "spade", "diamond", "club" };

    private List<Card> hand;
    private List<Card> requiredHand;

	public Rummy() {
        hand = new ArrayList<Card>();
	}

	public void addCard(int rank, String suit){
		Card card = new Card(rank, suit);
        hand.add(card);
	}

	private int generateRandomNumber(int maximum) {
		return 0 + (int) (Math.random() * maximum);
	}

    public void sortHandbySuit(){
        Collections.sort(hand, new Comparator<Card>() {
            public int compare(Card o1, Card o2) {
                return o1.getSuit().compareTo(o2.getSuit());
            }
        });
    }

    public void sortHandbyRank(){
        Collections.sort(hand);
    }

    private List<Integer> subtract(){
        ArrayList<Integer> diff = new ArrayList<Integer>();
        for (int i = 1; i < hand.size(); i++)
            diff.add(hand.get(i).getRank() - hand.get(i-1).getRank());

        return diff;
    }

    private int findMinimumCards() {
        sortHandbyRank();
        findPreExistingSequences();
        for (int diff : subtract())
            System.out.println(diff);

        return 0;
    }

    private void findPreExistingSequences(){

    }

	public static void main(String[] args) {
		int[] numRanks = new int[14];
		for (int i = 0; i < numRanks.length; i++){
			numRanks[i] = i++;
		}

		String[] charSuits = { "A", "B", "C", "D" };

		Rummy rummy = new Rummy();
		for (int i = 0; i < 13; i++) {
			int rank = numRanks[rummy.generateRandomNumber(13)];
			String suit = charSuits[rummy.generateRandomNumber(4)];
			rummy.addCard(rank, suit);
		}

        //only function to be called
        System.out.println(rummy.findMinimumCards());

        for (Card card:rummy.hand)
            System.out.println(card);
	}
}
