import java.util.Random;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardData {
	/**
	 * makes the Image and ImageView public so they can be added to the group in cardMain
	 */
	Image finalCard[] = new Image[4]; 
	ImageView finalImage[] = new ImageView[4];
	public void getCards() {	
	int suit[] = new int[3];
	int cards[] = new int[12];
	/**
	 * searches for the cards based on a string, put together in the style of suit first and card number or type second
	 */
	for (int i = 0; i < suit.length; i++)
	{
		suit[i] =  i;
	}
	for(int j = 0; j<cards.length;j++)
	{
		cards[j] = j;
	}
	/**
	 * string is created that is used to match the name of the card images in the attached zipped file
	 * creates and searches the zipped file for a random card based on two random numbers, 
	 * each set of numbers represents the suit and card number respectively
	 */
	String findCard = "";
	int rnd = new Random().nextInt(suit.length);
	rnd = suit[rnd];
	findCard = findCard + rnd;
	int rnd2 = new Random().nextInt(cards.length);
	rnd2 = cards[rnd2];
	findCard = findCard + rnd2;
	
	/**
	 * searches the file for a file with the same name as the string findCard
	 * creates each card randomly then adds the card image to view
	 * the first card sets the initial y value, and all iterations are located at the same y value, lining them up horizontally
	 */
	for(int i = 0; i<finalCard.length; i++) { 
	finalCard[i] = new Image(getClass().getResourceAsStream("/res/"+findCard+".png")); 
	finalImage[i] = new ImageView(finalCard[i]); 
	finalImage[i].setY(200); 
	findCard = "";
	rnd = new Random().nextInt(suit.length);
	findCard = findCard + rnd;
	rnd2 = new Random().nextInt(cards.length);
	rnd2 = cards[rnd2];
	findCard = findCard + rnd2;					
	}
}}

