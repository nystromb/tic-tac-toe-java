
public class UnbeatablePlayer extends Player implements MiniMax {

	public int getMove(Board board) {
		return minimax(board, 0);
	}
	
	public int minimax(Board board, int depth) {
		
		return 0;
	}
	
	public int score(Board board, int depth) {
		if (board.win(GameToken.X)) {
			return 10 - depth;
		} else if (board.win(GameToken.O)) {
			return depth - 10;
		} else {
			return 0;
		}
	}
}
