import java.util.Stack;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// it works but can still need some changes if can make any 

public class Expression {

	 public static int evaluate(String expression) 
	    { 
	       char[] tokens = expression.toCharArray(); 

	         //Stack for numbers: 'values' 
	        Stack<Integer> output = new Stack<Integer>(); 

	        // Stack for Operators: 'ops' 
	        Stack<Character> ops = new Stack<Character>(); 


	        for (int i = 0; i < expression.length(); i++) 
	        { 
	        	 StringBuffer sbuf = new StringBuffer(); 
	        	// Current token is a number, push it to stack for numbers 
	             if  (tokens[i] >= '0' && tokens[i] <= '9') 
		            {
		                // There may be more than one digits in number 
		                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
		                    sbuf.append(tokens[i++]); 
		               output.push(Integer.parseInt(sbuf.toString())); 
		            } 
	            // Current token is an opening brace you try and push it to ops stack  
	            else if (tokens[i] == '(') 
	                ops.push(tokens[i]); 


	            // Closing brace encountered, solve entire brace 
	            else if (tokens[i] == ')') 
	            { 
	            	// we use the peek to see what is in front of the operator stack
	                while (ops.peek() != '(') 
	                  output.push(applyOp(ops.pop(),output.pop(), output.pop())); 
	                ops.pop(); 
	            } 

	            // Current token is an operator. 
	            else if((tokens[i] == '+' || tokens[i] == '-' || 
	                     tokens[i] == '*' || tokens[i] == '/') )
	            { 
	                // While top of 'ops' has same or greater precedence to current 
	                // token, which is an operator. Apply operator on top of 'ops' 
	                // to top two elements in values stack 
	                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
	                    output.push(applyOp(ops.pop(), output.pop(), output.pop()));

	                // Push current token to 'ops'. 
	                ops.push(tokens[i]); 
	            } 
	        } 

	        // Entire expression has been parsed at this point, apply remaining 
	        // ops to remaining values 
	        while (!ops.empty()) 
	            output.push(applyOp(ops.pop(), output.pop(), output.pop())); 

	        // Top of 'values' contains result, return it 
	        return output.pop(); 
	    } 

	    // Returns true if 'op2' has higher or same precedence as 'op1', 
	    // otherwise returns false. 
	    public static boolean hasPrecedence(char op1, char op2) 
	    { 

	        if (op2 == '(' || op2 == ')') 
	            return false; 
	        if ((op1 == '*' || op1 == '/')	&&  (op2 == '+' || op2 == '-'))
	            return false;

	        return true;

	    } 


	    // A utility method to apply an operator 'op' on operands 'a'  
	    // and 'b'. Return the result. 
	    public static int applyOp(char op, int b, int a) 
	    { 
	    	// I changed this from a switch statement to an if
	    	if(op == '+') return a +b;
	    	else if(op == '-') return a - b;
	    	else if(op == '*') return a * b;
	    	else if(op == '/') 
	    		if(b == 0) {
	                throw new
	                UnsupportedOperationException("Cannot divide by zero"); }
	    		else return a / b; 


	    	return 0; 

	    }
	    
	    public void equation() {
	    	int total = 0;
	    	/**
			 * if the total of the given equation equals 24, the player has won the game
			 * if the player wins, shows a popup window that congratulates the player
			 */
			if (total == 24) {
				/**
				 * creates a new stage, titled "You Won"
				 */
				Stage winnerPopup = new Stage();
				
				winnerPopup.setTitle("You Won!");
				/**
				 * creates a label with a message telling the player they won,
				 * creates a button that when pressed closes the popup window
				 */
				Label congratText = new Label("Congratulations, you won the game!");
				Button winClose = new Button("Close this Window");
				winClose.setOnAction(e->winnerPopup.close());
				
				/**
				 * add the label an button to the scene
				 * positions the popup window in the center of the screen
				 * when the window is opened, it will be displayed until the player takes action to close it
				 */
				VBox winLayout = new VBox(10);
				winLayout.getChildren().addAll(congratText, winClose);
				winLayout.setAlignment(Pos.CENTER);
				
				Scene win = new Scene(winLayout, 400, 300);
				winnerPopup.setScene(win);
				winnerPopup.showAndWait();
			}
	    }
	    } 

       // put this in to check if it work 
	    // we would just need to get this on the verify button action