import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnbeatablePlayerTest {
	UnbeatablePlayer p1, p2;
	Board board;
	GameModel game;
	
	@Before
	public void setUp() throws Exception {
		p1 = new UnbeatablePlayer();
		p1.setPiece(GameToken.X);
		
		p2 = new UnbeatablePlayer();
		p2.setPiece(GameToken.O);
		
		board = new ThreeByThreeBoard();
		
		game = new GameModel(board, p1, p2);
	}
	
	@After
	public void clearBoard(){
		game.board.clearAll();
	}
	
	@Test
	public void testIfReturn3OnSmartMove(){
		game.play(2);
		game.switchTurns();
		game.play(7);
		game.switchTurns();
		game.play(6);
		game.switchTurns();
		game.play(8);
		game.switchTurns();
		game.play(9);
		game.switchTurns();
		
		assertEquals(3, game.currentPlayer.getMove(game));
	}
}
