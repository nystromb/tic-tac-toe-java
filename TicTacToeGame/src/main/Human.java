package main;

import java.util.Scanner;

public class Human extends Player {
	private int move;
	Scanner input;
	
	public Human(Scanner input){
		this.input = input;
	}
	
	@Override
	public int getMove(GameModel game) {
		System.out.println("What is your next move?");
		
		while (true) {
	        System.out.print("> ");
	        String userInput = input.next();
	        try {
	        	move = Integer.parseInt(userInput);
	        } catch(NumberFormatException e){
	        	System.out.println("invalid");
	        }
	        
	        if(game.moveIsValid(move))
	        	break;
	    }
		
		return move;
	}

}