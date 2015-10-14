package main;

import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class UnbeatablePlayer extends Player {
	private int bestMove;
	private int bestScore;
	
	public int getMove(GameModel game) {
		return minimax(game, 0);
	}
	
	private int minimax(GameModel game, int depth) {
		if(game.isOver())
			score(game.board, depth);
		
		List<Integer> moves = game.getEmptySpots();
		Map<Integer, Integer> scores = new Hashtable<Integer, Integer>(moves.size());
		
		for(Integer move : moves){
			GameModel copy = game.newGameState(move.intValue());
			scores.put(move, minimax(copy, depth+1));
		}
		
		if(game.currentPlayer.getPiece() == GameToken.X){
			bestScore = -100;
			for(Integer move : moves){
				if(scores.get(move) > bestScore){
					bestScore = scores.get(move);
					bestMove = move;
				}
			}
		}else { 
			bestScore = 100;
			for(Integer move : moves){
				if(scores.get(move) < bestScore){
					bestScore = scores.get(move);
					bestMove = move;
				}
			}
		}
		
		if(depth == 0){
			return bestMove;
		}else{
			return bestScore;
		}
	}
	
	private int score(Board board, int depth) {
		if (board.win(GameToken.X)) {
			return 10 - depth;
		} else if (board.win(GameToken.O)) {
			return depth - 10;
		} else {
			return 0;
		}
	}
}
