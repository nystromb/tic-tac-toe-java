package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class GameModel extends Observable {
	public Board board;
	public Player player1, player2, currentPlayer;

	public GameModel(Board board, Player player1, Player player2) {
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
		this.currentPlayer = player1;
	}

	public GameModel(GameModel game) {
		this.board = game.board;
		this.player1 = game.player1;
		this.player2 = game.player2;
		this.currentPlayer = game.currentPlayer;
	}
	
	public void play(int move) {
		if(moveIsValid(move)){
			board.putMove(move, this.currentPlayer.getPiece());
			switchTurns();
			setChanged();
			notifyObservers(this.board);
		}
	}
	
	public boolean moveIsValid(int move){
		if ((move >= 1 && move <= board.getCellCount()) && (board.getMove(move) == GameToken.EMPTY))
			return true;
		
		return false;
	}
	 
	private void switchTurns() {
		if(this.currentPlayer == this.player1){
			this.currentPlayer = this.player2;
		}else
			this.currentPlayer = this.player1;
	}

	public boolean isOver() {
		if (board.win(GameToken.X) || board.win(GameToken.O) || (getEmptySpots().size() == 0))
			return true;
		
		return false;
	}
	
	public List<Integer> getEmptySpots() {
		List<Integer> emptySpots = new ArrayList<Integer>();
		
		for(int index = 1; index <= board.getCellCount(); index++)
			if(board.getMove(index) == GameToken.EMPTY)
				emptySpots.add(index);
		
		return emptySpots;
	}
	
	public GameModel newGameState(int move){
		GameModel copy = new GameModel(this);
		copy.play(move);
		return copy;
	}
}