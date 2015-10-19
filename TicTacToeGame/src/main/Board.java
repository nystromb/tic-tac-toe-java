package main;
import java.lang.reflect.InvocationTargetException;

public abstract class Board {
	public GameToken [] spots;
	protected int[][] winningIndexes;
	
	public Board (int size, int[][] indexes){
		spots = new GameToken[size];
		winningIndexes = indexes;
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
		for(int[] indexes : winningIndexes)
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
	
	public Board clone(){
		try {
			Board b = getClass().getConstructor().newInstance();
			return b;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}