import java.util.Random;

public class CardData {
	public void getCards() {
	int suit[] = new int[3];
	int cards[] = new int[12];
	//when searching for the cards, put together the string of numbers that are suit first, then cards
	//for instance, the Ace of Spades is 00, 0 from suit and 0 from cards
	for (int i = 0; i < suit.length; i++)
	{
		suit[i] =  i;
	}
	for(int j = 0; j<cards.length;j++)
	{
		cards[j] = j;
	}
	//create the string that will be used to match the card number in the zipped file
	String findCard = " ";
	int rnd = new Random().nextInt(suit.length);
	rnd = suit[rnd];
	findCard = findCard + rnd;
	int rnd2 = new Random().nextInt(cards.length);
	rnd2 = cards[rnd2];
	findCard = findCard + rnd2;
	//based on findCard, search the file and display the necessary card in the proper location
	}	
}

