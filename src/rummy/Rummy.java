package rummy;

import java.util.*;

public class Rummy {
	private String[] allRanks = { "Ace", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "Jack", "Queen", "King","Joker" };

	private String[] allSuits = { "heart", "spade", "diamond", "club" };

    private List<Card> hand;
    private List<Card> requiredHand;
    private List<Card> avTriplets;
    private List<Card> canBeTriplets;
    private List<Card> avNaturalSequences;
    private List<Card> canBeNaturalSequences;
    private List<Card> avSequences;
    private List<Card> canBeSequences;
    private List<Card> avQuad;
    private List<Card> canBeQuads;
    private List<Card> avPents;
    private List<Card> canBePents;
    private HashMap<String, Integer> possibleHands;

	public Rummy() {
        hand = new ArrayList<Card>();
	}

	public void addCard(int rank, String suit){
		Card card = new Card(rank, suit);
        hand.add(card);
	}

	public int generateRandomNumber(int maximum) {
		return 0 + (int) (Math.random() * maximum);
	}

    public void sortHandBySuit(){
        Collections.sort(hand, new Comparator<Card>() {
            public int compare(Card o1, Card o2) {
                return o1.getSuit().compareTo(o2.getSuit());
            }
        });
    }

    public void sortHandByRank(){
        Collections.sort(hand);
    }

    private List<Integer> subtract(){
        ArrayList<Integer> diff = new ArrayList<Integer>();
        for (int i = 1; i < hand.size(); i++)
            diff.add(hand.get(i).getRank() - hand.get(i-1).getRank());

        return diff;
    }

    private int findMinimumCards() {
        findExistingLinks();
        findCreatableLinks();
        findPossibleHands();
        displayBestHands();
        for (int diff : subtract())
            System.out.println(diff);

        return 0;
    }

    private void displayBestHands() {
        boolean ASC = true;
        Map<String, Integer> sortedMapAsc = sortByComparator(possibleHands, ASC);
        printMap(sortedMapAsc);
    }

    private void findExistingLinks(){
        sortHandByRank();
        for (int i = 0; i < hand.size() - 3; i++){
            Hand co = new Hand(hand.subList(i,i + 3));
            if (co.canBeTriplet())
                avTriplets.addAll(co.getCards());
            if (co.canBeNaturalSequence())
                avNaturalSequences.addAll(co.getCards());
            if (co.canBeSequence())
                avSequences.addAll(co.getCards());
        }

        for (int i = 0; i < hand.size() - 5; i++){
            Hand co = new Hand(hand.subList(i,i + 5));
            if (co.isPent())
                avPents.addAll(co.getCards());
        }

        for (int i = 0; i < hand.size() - 4; i++){
            Hand co = new Hand(hand.subList(i,i + 4));
            if (co.isQuad())
                avQuad.addAll(co.getCards());
        }
    }

    private void findCreatableLinks() {
        sortHandBySuit();
        for (int i = 0; i < hand.size() - 3; i++){
            Hand co = new Hand(hand.subList(i,i + 3));
            if (co.isTriplet())
                canBeTriplets.addAll(co.getCards());
            if (co.isNaturalSequence())
                canBeNaturalSequences.addAll(co.getCards());
            if (co.isSequence())
                canBeSequences.addAll(co.getCards());
        }

        for (int i = 0; i < hand.size() - 5; i++){
            Hand co = new Hand(hand.subList(i,i + 5));
            if (co.canBePent())
                canBePents.addAll(co.getCards());
        }

        for (int i = 0; i < hand.size() - 4; i++){
            Hand co = new Hand(hand.subList(i,i + 4));
            if (co.canBeQuad()  )
                canBeQuads.addAll(co.getCards());
        }
    }

    private void findPossibleHands() {

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

       /* for (Card card:rummy.hand)
            System.out.println(card);*/
	}

    private static Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, final boolean order)
    {

        List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

        // Sorting the list based on values
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>()
        {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                if (order)
                {
                    return o1.getValue().compareTo(o2.getValue());
                }
                else
                {
                    return o2.getValue().compareTo(o1.getValue());

                }
            }
        });

        // Maintaining insertion order with the help of LinkedList
        Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> entry : list)
        {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public static void printMap(Map<String, Integer> map)
    {
        for (Map.Entry<String, Integer> entry : map.entrySet())
        {
            System.out.println("Key : " + entry.getKey() + " Value : "+ entry.getValue());
        }
    }
}
