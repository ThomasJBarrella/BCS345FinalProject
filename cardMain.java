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

public class cardMain extends Application {

	public static void main(String[] args) {
		
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		CardData d = new CardData();
		d.getCards();//get 4 random cards and display in center
		
		//Make top pane
		Button btnSolu = new Button("Find a Solution");
		TextField txt = new TextField();
		Button btnRefresh = new Button("Refresh");
		HBox  top = new HBox(btnSolu,txt,btnRefresh);
		top.setAlignment(Pos.BASELINE_CENTER);
		top.setSpacing(10);
	
		//Make center pane 
		HBox center = new HBox();
        center.setAlignment(Pos.CENTER);
        center.setSpacing(10);
        center.setPadding(new Insets(10));
		
        //make bottom pane 
		Button btnVerify = new Button("Verify");
		TextField txt2 = new TextField();
		Label lbl = new Label("Enter an expression: ");
		HBox bottom = new HBox(10,lbl,txt2,btnVerify);
		bottom.setAlignment(Pos.BOTTOM_CENTER);
		
		//the one pane to combine the three separate panes created
		BorderPane pane = new BorderPane();
		pane.setPadding(new Insets(10));
        pane.setTop(top);
        pane.setCenter(center);
        pane.setBottom(bottom);
        
        Group grp = new Group(pane);
        
        for(int i=0; i<d.finalImage.length;i++) { //creating the four cards on the screen
			d.finalImage[i].setX(d.finalImage[i].getX()+195*i+75);//initially the first card will be 75 x units over, but the rest get multiplied to 
																  //add space
			center.getChildren().add(d.finalImage[i]);
		}
        
		btnRefresh.setOnMouseClicked(n->{ //when you click the mouse, the current cards are removed from the group and then d.getCards() is called again
									   //creating 4 new random cards.
				for(int i=0; i<d.finalImage.length;i++) {
					center.getChildren().remove(d.finalImage[i]);
				}
				
				d.getCards();
				for(int i=0; i<d.finalImage.length;i++) {
					d.finalImage[i].setX(d.finalImage[i].getX()+195*i+75);	
					center.getChildren().add(d.finalImage[i]);
				}
			});
			
     
		Scene sn = new Scene(grp);
		primaryStage.setScene(sn);
		primaryStage.show();
	} }
