package main;

import java.io.PrintStream;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class CommandLineInterface implements Observer {
	Scanner input;
	PrintStream output;
	
	public CommandLineInterface(Scanner input, PrintStream output){
		this.input = input;
		this.output = output;
	}
	
	public void update(Observable o, Object board) {
		printBoard((Board) board);
 	}

	private void printBoard(Board board) {
		for(int index = 1; index <= board.getCellCount(); index++){
			if(board.getMove(index) == GameToken.EMPTY)
				output.print(index);
			else
				output.print(board.getMove(index));
			
			if((index % Math.sqrt(board.getCellCount())) == 0)
				output.println("");
			else
				output.print("|");
		}
	}
}