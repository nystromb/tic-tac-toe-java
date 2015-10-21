package main;

import java.util.Scanner;

public class GameApplication {	
	CommandLineInterface cli;
	GameModel game;
	private int mode;
	public Player p1, p2;
	
	public GameApplication(CommandLineInterface cli) {
		this.cli = cli;
		getUserGameMode();
		createPlayers();
		game = new GameModel(new ThreeByThreeBoard(), p1, p2);
		game.addObserver(cli);
	}

	private void getUserGameMode() {
		cli.promptGameMode();
		while(true){
			mode = cli.getGameInput();
			if(modeIsValid(mode)) break;
		}
		cli.printGameModeToUser(mode);
	}

	private boolean modeIsValid(int mode) {
		return (mode >= 1 && mode <= 3);
	}

	public void createPlayers() {
		if(mode == 1){
			p1 = new Human(cli);
			p2 = new Human(cli);
		}else if (mode == 2){
			p1 = new Human(cli);
			p2 = new UnbeatablePlayer();
		}else if(mode == 3){
			p1 = new UnbeatablePlayer();
			p2 = new UnbeatablePlayer();
		}
		
		p1.setPiece(GameToken.X);
		p2.setPiece(GameToken.O);
	}
	
	public void run(){
		while(!(game.isOver())){
			int move = game.currentPlayer.getMove(game);
			game.play(move);
		}
		System.out.println("Game Over!");
	}
	
	public static void main(String [] args){
		new GameApplication(
				new CommandLineInterface(
						new Scanner(System.in), System.out)).run();
	}
}
