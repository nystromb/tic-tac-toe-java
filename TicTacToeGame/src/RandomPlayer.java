import java.util.List;
import java.util.Random;

public class RandomPlayer extends Player {
	
	public int getMove(Board board){
		List<Integer> availableMoves = board.getEmptySpots();
		
		int index = new Random().nextInt(availableMoves.size());
		
		return availableMoves.get(index);
	}
}
