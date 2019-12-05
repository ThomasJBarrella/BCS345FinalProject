import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import org.junit.*;

@SuppressWarnings("unused")
public class cardMain extends Application {

	public static void main(String[] args) {
		/**
		 * @param args Runs the program
		 */
		launch(args);
	}
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		/**
		 * creating a new instance of CardData
		 * getCards method will generate 4 random cards
		 */
		CardData d = new CardData();
		d.getCards();
		
		/**
		 * creates the top pane with buttons to find a soultion and refresh
		 * creates the center pane
		 * creates the bottom pane to verfy user equation and to enter another expression
		 */
		Button btnSolu = new Button("Find a Solution");
		TextField txt = new TextField();
		Button btnRefresh = new Button("Refresh");
		HBox  top = new HBox(btnSolu,txt,btnRefresh);
		top.setAlignment(Pos.BASELINE_CENTER);
		top.setSpacing(10);
	
		
		HBox center = new HBox();
        center.setAlignment(Pos.CENTER);
        center.setSpacing(10);
        center.setPadding(new Insets(10));
		
        
		Button btnVerify = new Button("Verify");
		TextField txt2 = new TextField();
		Label lbl = new Label("Enter an expression: ");
		HBox bottom = new HBox(10,lbl,txt2,btnVerify);
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		
		/**
		 * combines all 3 previously created panes into one pane
		 */
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10));
        pane.setTop(top);
        pane.setCenter(center);
        pane.setBottom(bottom);
        
        /**
         * @param pane Used to show the pane used to combine all 3 panes
         */
        Group grp = new Group(pane);
        
        /**
         * this creates the four cards to be shown on screen
         * initially the first card will be 75 x units over, but the rest get multiplied to add space
         * the cards are then added to CardData d created earlier
         */
        for(int i=0; i<d.finalImage.length;i++) { 
			d.finalImage[i].setX(d.finalImage[i].getX()+195*i+75);
			center.getChildren().add(d.finalImage[i]);
		}
        /**
         * when the mouse is clicked, the current cards are removed from the group and then d.getCards() is called again,
         * creating 4 new random cards
         */
		btnRefresh.setOnMouseClicked(n->{ 
				for(int i=0; i<d.finalImage.length;i++) {
					center.getChildren().remove(d.finalImage[i]);
				}
				
				d.getCards();
				for(int i=0; i<d.finalImage.length;i++) {
					d.finalImage[i].setX(d.finalImage[i].getX()+195*i+75);	
					center.getChildren().add(d.finalImage[i]);
				}
			});
			
     /**
      * sets and shows the scene on primaryStage
      */
		Scene sn = new Scene(grp);
		primaryStage.setScene(sn);
		primaryStage.show();
	} }

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
