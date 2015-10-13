import java.util.ArrayList;
import java.util.List;

public class GameModel {
	Board board;
	Player player1, player2, currentPlayer;
	
	public GameModel(Board board){
		this.board = board;
	}

	public GameModel(Board board, Player player1, Player player2) {
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
		this.currentPlayer = player1;
	}

	public GameModel(GameModel game) {
		this.board = game.board;
		this.player1 = game.player1;
		this.player2 = game.player2;
		this.currentPlayer = game.currentPlayer;
	}

	public void play(int index) {
		board.putMove(index, this.currentPlayer.getPiece());
	}
	
	protected List<Integer> getEmptySpots() {
		List<Integer> emptySpots = new ArrayList<Integer>();
		
		for(int index = 1; index <= board.getCellCount(); index++)
			if(board.getMove(index) == GameToken.EMPTY)
				emptySpots.add(index);
		
		return emptySpots;
	}

	public boolean isOver() {
		if (board.win(GameToken.X) || board.win(GameToken.O) || (getEmptySpots().size() == 0))
			return true;
		
		return false;
	}

	public void switchTurns() {
		if(this.currentPlayer == this.player1){
			this.currentPlayer = this.player2;
		}else
			this.currentPlayer = this.player1;
	}
}
