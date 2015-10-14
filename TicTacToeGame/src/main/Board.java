package main;

public abstract class Board {
	protected int [][] winIndexes = null;
	public GameToken [] spots;
	
	public Board (int size){
		spots = new GameToken[size];
		clearAll();
	}
	
	public void clearAll() {
		for(int index = 1; index <= spots.length; index++)
			spots[index-1] = GameToken.EMPTY;
	}

	public void putMove(int index, GameToken piece) {
		spots[index-1] = piece;
	}
	
	public GameToken getMove(int index) {
		return spots[index-1];
	}

	public boolean win(GameToken piece) {
		for(int[] indexes : winIndexes)
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

	public int getCellCount() {
	 	return spots.length;
	}
}