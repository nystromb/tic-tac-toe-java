import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UnbeatablePlayerTest {
	UnbeatablePlayer player;
	Board board;
	
	@Before
	public void setUp() throws Exception {
		player = new UnbeatablePlayer();
		board = new ThreeByThreeBoard();
	}

	@Test
	public void testUnbeatablePlayerScoreGameWhenXWins() {
		board.putMove(1, GameToken.X);
		board.putMove(2, GameToken.X);
		board.putMove(3, GameToken.X);
		
		assertEquals(10, player.score(board, 0));
	}
	
	@Test
	public void testUnbeatableScoreGameWhenOWins() {
		board.putMove(7, GameToken.O);
		board.putMove(8, GameToken.O);
		board.putMove(9, GameToken.O);
		
		assertEquals(-10, player.score(board, 0));
	}
	
	@Test
	public void testUnbeatableScoreDrawGame(){
		board.putMove(1, GameToken.X);
		board.putMove(2, GameToken.O);
		board.putMove(3, GameToken.X);
		board.putMove(5, GameToken.O);
		board.putMove(8, GameToken.X);
		board.putMove(6, GameToken.O);
		board.putMove(4, GameToken.X);
		board.putMove(7, GameToken.O);
		board.putMove(9, GameToken.X);
		
		assertEquals(0, player.score(board, 0));
	}

	
}
