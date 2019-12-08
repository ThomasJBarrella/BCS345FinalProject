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
	
	boolean isValid(CardData d, TextField txt2) {
        String txt = txt2.toString();
        String[] a = new String[4];
        int size = 0;
        int numAmount=0;
        char[] tokens = txt.toCharArray();
        for(int i = 0; i<=tokens.length;i++) {
        if(tokens[i] >= '0' && tokens[i] <= '9') {
            a[size]+=tokens[i];
            numAmount=0;
        }
        else if (numAmount==0){
            size++;
            numAmount++;
        }
    }
        for(int i = 0; i<=3; i++) {
            if(!(Integer.parseInt(a[i])==(d.validNum[i]))){
                return false;
            }
        }
        return true;
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
         * When the verify button is pressed, it will evaluate what is in the text field
         * If the evaluation returns 24, they did it.
         * Either way, it will open up a new window that will tell them if they won or lost
         * if they lost, they will get the value that expression evaluate returned
         */
        btnVerify.setOnMouseClicked(p->{
        	if (isValid(d, txt2) == true)
        	{
        		if(Expression.evaluate(txt2.getText())==24) {
        			Stage secStage = new Stage();
        			Label lbl2 = new Label("Hurray!");
        			lbl2.setLayoutX(100);
        			lbl2.setLayoutY(100);
        			Group grp2 = new Group(lbl2);
        			Scene sn2 = new Scene(grp2,250,250);
        			secStage.setScene(sn2);
        			secStage.setTitle("You did it!");
        			secStage.show();
        		}
        		else {
        			Stage secStage = new Stage();
        			Label lbl2 = new Label("Failure, you ended up with: "+Expression.evaluate(txt2.getText()));
        			lbl2.setLayoutX(15);
        			lbl2.setLayoutY(15);
        			Group grp2 = new Group(lbl2);
        			Scene sn2 = new Scene(grp2,250,250);
        			secStage.setScene(sn2);
        			secStage.setTitle("Wrong!");
        			secStage.show();
        		}
    			}
        	else{
        		Stage secStage = new Stage();
        		Label lbl2 = new Label("Failure: Numbers aren't valid, please try again");
        		lbl2.setLayoutX(15);
        		lbl2.setLayoutY(15);
        		Group grp2 = new Group(lbl2);
        		Scene sn2 = new Scene(grp2,250,250);
        		secStage.setScene(sn2);
        		secStage.setTitle("Error");
        		secStage.show();
        	}});
        
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
	} 
}


