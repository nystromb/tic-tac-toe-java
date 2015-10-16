package main;

import java.util.ArrayList;
import java.util.List;

public class UnbeatablePlayer extends Player {
	private int bestScore = 0;
	
	public int getMove(GameModel game) {
		return minimax(new GameModel(game), 0);
	}
	
	private int minimax(GameModel game, int depth) {
		if(game.isOver())
			return score(game.board, depth);
		
		List<Integer> moves = game.getEmptySpots();
		List<Integer> scores = new ArrayList<Integer>();
		
		for(Integer move : moves){
			game.play(move);
			GameModel copy = new GameModel(game);
			scores.add(minimax(copy, depth+1));
			game.unplay(move);
		}
		
		if(game.currentPlayer.getPiece() == GameToken.X){
			bestScore = -100;
			for(Integer score : scores)
				if(score > bestScore)
					bestScore = score; 
		}else {
			bestScore = 100;
			for(Integer score : scores)
				if(score < bestScore)
					bestScore = score;
		}
		
		if(depth == 0)
			return moves.get(scores.indexOf(bestScore));
		else
			return bestScore;
	}
	
	private int score(Board board, int depth) {
		if (board.win(GameToken.X))
			return 10 - depth;
		else if (board.win(GameToken.O))
			return depth - 10;
		else
			return 0;
	}
}
