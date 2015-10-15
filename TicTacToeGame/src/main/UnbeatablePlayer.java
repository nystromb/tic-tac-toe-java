package main;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class UnbeatablePlayer extends Player {
	Entry<Integer, Integer> bestEntry;
	int bestMove = 0;
	int bestScore = 0;
	
	public int getMove(GameModel game) {
		return minimax(new GameModel(game), 0);
	}
	
	private int minimax(GameModel game, int depth) {
		if(game.isOver())
			return score(game.board, depth);
	
		Map<Integer, Integer> scores = new LinkedHashMap<Integer, Integer>();
		
		for(Integer move : game.getEmptySpots()){
			game.play(move);
			GameModel copy = new GameModel(game);
			scores.put(move, minimax(copy, depth+1));
			game.unplay(move);
			
		}

		if(game.currentPlayer.getPiece() == GameToken.X) {
			for(Entry<Integer, Integer> entry : scores.entrySet())
				if(bestEntry == null || entry.getValue() >= bestEntry.getValue())
					bestEntry = entry;
		}
		else {
			for(Entry<Integer, Integer> entry : scores.entrySet())
				if(bestEntry == null || entry.getValue() <= bestEntry.getValue())
					bestEntry = entry;
		}
		
		if(depth == 0){
			return bestEntry.getKey();
		}
		else
			return bestEntry.getValue();
		
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
