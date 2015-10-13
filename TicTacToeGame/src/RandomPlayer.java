import java.util.List;
import java.util.Random;

public class RandomPlayer extends Player {
	
	public int getMove(GameModel game){
		List<Integer> availableMoves = game.getEmptySpots();
		
		int index = new Random().nextInt(availableMoves.size());
		
		return availableMoves.get(index);
	}
}