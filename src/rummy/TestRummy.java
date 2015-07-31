package rummy;

import org.junit.Test;

public class TestRummy {
	@Test
	public void testRandom(){
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
	}

}
