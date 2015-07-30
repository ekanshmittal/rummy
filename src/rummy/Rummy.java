package rummy;

public class Rummy {
	private String[] allRanks = { "Ace", "1", "2", "3", "4", "5", "6", "7", "8",
			"9", "10", "Joker", "Queen", "King" };
	private String[] allSuits = { "heart", "spade", "diamond", "club" };

	public Rummy() {

	}

	public static void main(String[] args) {
		Rummy rummy = new Rummy();
		for (int i = 0; i < 13; i++) {
			int rank = rummy.generateRandomNumber(13);
			int suit = rummy.generateRandomNumber(4);
			System.out.println(rummy.allRanks[rank] + " " + rummy.allSuits[suit]);
		}
	}

	private int generateRandomNumber(int maximum) {
		return 0 + (int) (Math.random() * maximum);
	}
}
