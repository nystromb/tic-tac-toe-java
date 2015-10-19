package main;

import java.util.Scanner;

public class Human extends Player {
	private int move;
	CommandLineInterface cli;
	
	public Human(CommandLineInterface cli){
		this.cli = cli;
	}
	
	@Override
	public int getMove(GameModel game) {
		return move;
	}

}