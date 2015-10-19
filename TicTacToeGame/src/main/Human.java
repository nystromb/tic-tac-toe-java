package main;

public class Human extends Player {
	CommandLineInterface cli;
	private int move;
	
	public Human(CommandLineInterface cli){
		this.cli = cli;
	}
	
	@Override
	public int getMove(GameModel game) {
		while(true){
			move = cli.getGameInput(); 
			if(game.moveIsValid(move)) return move;
		}
	}

}