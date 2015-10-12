import java.util.ArrayList;
import java.util.List;

public class Board {
	private GameToken [] spots;
	
	public Board (int size){
		spots = new GameToken[size];
		clearAllSpots();
	}
	
	private void clearAllSpots() {
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
}
