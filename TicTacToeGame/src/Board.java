import java.util.ArrayList;
import java.util.List;

abstract class Board {
	private GameToken [] spots;
	protected int [][] winIndexes = null;
	
	public Board (int size){
		spots = new GameToken[size];
		clearAll();
	}
	
	protected void clearAll() {
		for(int index = 1; index <= spots.length; index++)
			spots[index-1] = GameToken.EMPTY;
	}

	protected void putMove(int index, GameToken piece) {
		spots[index-1] = piece;
	}
	
	protected GameToken getMove(int index) {
		return spots[index-1];
	}
	
	protected List<Integer> getEmptySpots() {
		List<Integer> emptySpots = new ArrayList<Integer>();
		
		for(int index = 0; index < spots.length; index++)
			if(spots[index] == GameToken.EMPTY)
				emptySpots.add(index+1);
		
		return emptySpots;
	}

	protected boolean win(GameToken piece) {
		for(int[] indexes: winIndexes)
			if(isGameWinningLineup(indexes, piece))
				return true;
				
		return false;
	}
	
	protected boolean isGameWinningLineup(int[] indexes, GameToken piece){
		for(int index : indexes)
			if(spots[index-1] != piece)
				return false;
		
		return true;
	}
}
