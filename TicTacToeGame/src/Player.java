
public class Player {
	private GameToken playerToken;
	
	public Player () {
	
	}
	
	public void setPiece(GameToken piece) {
		this.playerToken = piece;
	}
	
	public GameToken getPiece() {
		return this.playerToken;
	}
}
