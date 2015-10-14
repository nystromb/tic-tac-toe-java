package main;
import java.util.InputMismatchException;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class CommandLineInterface implements Observer {
	Scanner input;
	int userMode;
	
	public CommandLineInterface(Scanner input){
		this.input = input;
	}
	
	public void update(Observable o, Object board) {
		printBoard((Board) board);
 	}

	private void printBoard(Board board) {
		for(int index = 1; index <= board.getCellCount(); index++){
			if(board.getMove(index) == GameToken.EMPTY){
				System.out.print(index + " ");
			}else{
				System.out.print(board.getMove(index) + " ");
			}
			
			if(index % Math.sqrt(board.getCellCount()) == 0){
				System.out.println("");
			}
		}
		System.out.println("");
	}

	public int getModeFromUser() {
		System.out.print("What game mode would you like to play?\n");
		System.out.print(" 1. Human vs. Human\n 2. Human vs. Computer\n 3. Computer vs. Computer\n\n");
	    while (true) {
	        System.out.print("> ");
	        String userInput = input.next();
	        try {
	        	userMode = Integer.parseInt(userInput);
	        } catch(NumberFormatException e){
	        	
	        }
	        
	        if(userMode == 1 || userMode == 2 || userMode == 3)
	        	break;
	    }
		return userMode;
	}
}