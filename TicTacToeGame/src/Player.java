
public abstract class Player {
	protected GameToken playerToken;
	
	protected void setPiece(GameToken piece) {
		this.playerToken = piece;
	}
	
	protected GameToken getPiece() {
		return this.playerToken;
	}

	public abstract int getMove(GameModel game);
}
