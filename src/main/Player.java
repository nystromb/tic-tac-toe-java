package main;

public abstract class Player {
	protected GameToken playerToken;
	
	public void setPiece(GameToken piece) {
		this.playerToken = piece;
	}
	
	public GameToken getPiece() {
		return this.playerToken;
	}

	public abstract int getMove(GameModel game);
}