import java.util.Random;
import org.junit.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardData {
	/**
	 * makes the Image finalCard and ImageView finalImage public so they can be added to the group in cardMain
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
	}}
	
	/**
	 * this test case tests the resource stream that will find the Ace of Spades in the zipped file
	 * this code creates the image and imageview to display the image
	 */
	@Test
	public void ShowCardtest() {
		String AceofSpades = "00";
		Image testImage = new Image(getClass().getResourceAsStream("/res/"+AceofSpades+".png"));
		@SuppressWarnings("unused")
		ImageView testImageView = new ImageView(testImage);
	}
	/**
	 * this test case fills the suit and card arrays and builds the test string that would be used to find the card names in the file
	 * the string is then sent as output, numerous calls of this function should yield different numbers
	 */
	@Test
	public void MakeRandomCardString() {
		int suitTest[] = new int[3];
		int cardsTest[] = new int[12];
		for (int i = 0; i < suitTest.length; i++)
		{
			suitTest[i] =  i;
		}
		for(int j = 0; j<cardsTest.length;j++)
		{
			cardsTest[j] = j;
		}
		String findTestCard = "";
		int rnd = new Random().nextInt(suitTest.length);
		rnd = suitTest[rnd];
		findTestCard = findTestCard + rnd;
		int rnd2 = new Random().nextInt(cardsTest.length);
		rnd2 = cardsTest[rnd2];
		findTestCard = findTestCard + rnd2;
		System.out.println(findTestCard);
	}
	
	/**
	 * this test case will fill an array at a certain size 
	 * fill the array with numbers and output each number in the array
	 * this is used to test the creation of the images, suits and cardTypes
	 */
	@Test
	public void ShowArrayFill() {
		int size = 5;
		int[] nums = new int[size];
		for (int i = 0; i < size;i++) {
			nums[i] = i;
			System.out.println(nums[i]);
		}
		
	}
	}

