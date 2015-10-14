package main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Human extends Player {
	private int move;
	Scanner input;
	
	public Human(Scanner in){
		this.input = in;
	}
	
	@Override
	public int getMove(GameModel game) {
		do {
			System.out.println("What move would you like to make?");
			try{
				move = input.nextInt();
			}catch(InputMismatchException e){
				continue;
			}
		} while (move < 1 && move > game.board.getCellCount());
		
		return move;
	}

}