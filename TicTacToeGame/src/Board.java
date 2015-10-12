import java.util.ArrayList;
import java.util.List;

public class Board {
	private GameToken [] spots;
	private int [][] winIndexes = { {1,2,3}, {4,5,6}, {7,8,9}, {1,4,7}, {2,5,8}, {3,6,9}, {1,5,9}, {3,5,7} };
	
	public Board (int size){
		spots = new GameToken[size];
		clearAll();
	}
	
	private void clearAll() {
		for(int index = 1; index <= spots.length; index++)
			spots[index-1] = GameToken.EMPTY;
	}

	public void putMove(int index, GameToken piece) {
		spots[index-1] = piece;
	}
	
	public GameToken getMove(int index) {
		return spots[index-1];
	}
	
	public List<Integer> getEmptySpots() {
		List<Integer> emptySpots = new ArrayList<Integer>();
		
		for(int index = 0; index < spots.length; index++)
			if(spots[index] == GameToken.EMPTY)
				emptySpots.add(index+1);
		
		return emptySpots;
	}

	public boolean win(GameToken piece) {
		for(int[] indexes: winIndexes)
			if(isGameWinningLineup(indexes, piece))
				return true;
				
		return false;
	}
	
	public boolean isGameWinningLineup(int[] indexes, GameToken piece){
		for(int index : indexes)
			if(spots[index-1] != piece)
				return false;
		return true;
	}
}
