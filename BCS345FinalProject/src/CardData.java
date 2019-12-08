import java.util.Random;
import org.junit.*;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CardData {
	/**
	 * makes the Image finalCard and ImageView finalImage public so they can be added to the group in cardMain
	 */
	Image finalCard[] = new Image[4]; 
	ImageView finalImage[] = new ImageView[4];
	int validNum[] = new int[4];
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
	/**
	 * The next if statement block adds the value to the card
	 */
	if(findCard.length()==2) {
	if(findCard.endsWith("0")) {
		validNum[i]=1;
	}
	else if(findCard.endsWith("1")) {
		validNum[i]=2;
	}
	else if(findCard.endsWith("2")) {
		validNum[i]=3;
	}
	else if(findCard.endsWith("3")) {
		validNum[i]=4;
	}
	else if(findCard.endsWith("4")) {
		validNum[i]=5;
	}
	else if(findCard.endsWith("5")) {
		validNum[i]=6;
	}
	else if(findCard.endsWith("6")) {
		validNum[i]=7;
	}
	else if(findCard.endsWith("7")) {
		validNum[i]=8;
	}
	else if(findCard.endsWith("8")) {
		validNum[i]=9;
	}
	else if(findCard.endsWith("9")) {
		validNum[i]=10;
	}
	}
	else {
		if(findCard.endsWith("0")) {
		validNum[i]=11;//010,110,210,310
		} 
		else if(findCard.endsWith("1")) {
			validNum[i]=12;
		}
		else {
			validNum[i]=13;
		}
	}
		
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


