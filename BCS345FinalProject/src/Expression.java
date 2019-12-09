import java.util.Stack;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 

public class Expression {

	 public static int evaluate(String expression) 
	    { 
	       char[] tokens = expression.toCharArray(); 
	       	/**
	       	 * stack for numbers: "values"
	       	 * stack for operator: "ops"
	       	 */ 
	        Stack<Integer> output = new Stack<Integer>(); 

	        Stack<Character> ops = new Stack<Character>(); 


	        for (int i = 0; i < expression.length(); i++) 
	        { 
	        	 StringBuffer sbuf = new StringBuffer(); 
	        	 /**
	        	  * current token is a number, push it to stack for numbers
	        	  * there may be more than one digit in number, so the while loop accounts for that scenario
	        	  */
	             if  (tokens[i] >= '0' && tokens[i] <= '9') 
		            {
		                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') 
		                    sbuf.append(tokens[i++]); 
		               output.push(Integer.parseInt(sbuf.toString())); 
		            } 
	             /**
	              * the current token is an opening brace, push it to ops stack
	              */
	            else if (tokens[i] == '(') 
	                ops.push(tokens[i]); 


	            /**
	             * when the closing brace is encountered, solve the entire brace
	             * use the peek function to see what is in front of the operator stack
	             */
	            else if (tokens[i] == ')') 
	            { 
	                while (ops.peek() != '(') 
	                  output.push(applyOp(ops.pop(),output.pop(), output.pop())); 
	                ops.pop(); 
	            } 
	             /**
	              * current token is an operator
	              * while the top of "ops" has the same or greater precedence to current token (operator)
	              *apply operator on top of "ops" to top two elements in values stack
	              *push current token to "ops"
	              */ 
	            else if((tokens[i] == '+' || tokens[i] == '-' || 
	                     tokens[i] == '*' || tokens[i] == '/') )
	            { 
	                
	                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek())) 
	                    output.push(applyOp(ops.pop(), output.pop(), output.pop()));

	                ops.push(tokens[i]); 
	            } 
	        } 

	        /**
	         * expression has been parsed
	         * apply ops to remaining values
	         * return the result which is the top of values
	         */ 
	        while (!ops.empty()) 
	            output.push(applyOp(ops.pop(), output.pop(), output.pop())); 

	        return output.pop(); 
	    } 
	 	/**
	 	 * @param op1
	 	 * @param op2
	 	 * returns true if "op2" has higher or same precedence as "op1"
	 	 * otherwise it returns false
	 	 */ 
	    public static boolean hasPrecedence(char op1, char op2) 
	    { 

	        if (op2 == '(' || op2 == ')') 
	            return false; 
	        if ((op1 == '*' || op1 == '/')	&&  (op2 == '+' || op2 == '-'))
	            return false;

	        return true;

	    } 

	    /**
	     * @param op operator
	     * @param b operand
	     * @param a operand
	     * @return result
	     */
	    public static int applyOp(char op, int b, int a) 
	    { 
	    	/**
	    	 * if statement to delineate the operation
	    	 * cannot divide by zero clause implemented
	    	 */
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
	    	
	    	//evaluate(expression);
	    	//total = output.pop;
	    	
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