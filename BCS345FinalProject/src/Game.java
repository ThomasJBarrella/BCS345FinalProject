import javafx.scene.Group;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Game extends Application{
	
	public void start(Stage primaryStage) throws Exception{
		
		Label lbl = new Label();
		lbl.setLayoutX(200);lbl.setLayoutY(200);
		lbl.setText("Here it is");
		Button btn = new Button();
		btn.setLayoutX(200);btn.setLayoutY(250);
		btn.setText("Get New Cards");
		
		Group grp = new Group(lbl, btn);
		Scene sn = new Scene(grp,1000,800);
		
		primaryStage.setScene(sn);
		primaryStage.show();
	}
	
	public static void main(String[] args)
	{
		launch(args);
		/*in the zipped folder for images, I renamed all of the images to match the system where:
		 * Spades are equal to 0, Diamonds are equal to 1, Clubs are equal to 2 and Hearts are equal to 3
		 * We can create an array called Suit of length 0-3 that will choose 1 of these suits randomly
		 * The same will apply to the cards, Ace = 0, 2 = 1, 3= 2, 4 = 3, etc up to King = 12
		 * In the file, 00 is the Ace of Spades and 312 is the King of Hearts
		 * This will allow us to randomly generate a suit and number, 4 times (one for each card), 
		 * as long as there are no duplicate cards generated within the same set of 4, it executes
		 * if there is a duplicate, we can make it give a new card
		 * then we add up the total score, if it equals 24, a new window saying YOU WON! appears, if not
		 * the option to reshuffle appears and the game continues
		 */
	}

	
	
}
