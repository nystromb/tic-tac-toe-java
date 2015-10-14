package main;

import java.util.Scanner;

public class GameApplication {
	Scanner input;
	Player p1, p2;
	
	public static void main(String[] args) {
		new GameApplication();
	}
	
	public GameApplication() {
		input = new Scanner(System.in);
		CommandLineInterface cli = new CommandLineInterface(input);
		
		int mode = cli.getModeFromUser();
		createPlayers(mode);
		
		GameModel game = new GameModel(new ThreeByThreeBoard(), p1, p2);
		game.addObserver(cli);
		run(game);
	}

	private void createPlayers(int mode) {
		if(mode == 2){
			p1 = new Human(input);
			p2 = new UnbeatablePlayer();
		}else if(mode == 3){
			p1 = new UnbeatablePlayer();
			p2 = new UnbeatablePlayer();
		}else {
			p1 = new Human(input);
			p2 = new Human(input);
		}
		
		p1.setPiece(GameToken.X);
		p2.setPiece(GameToken.O);
	}

	private void run(GameModel game) {
		while(!(game.isOver())){
			int move = game.currentPlayer.getMove(game);
			game.play(move);
		}
		System.out.println("Game Over!");
	}
}
