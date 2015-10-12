import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RandomPlayerTest {
	Player player;
	Board board;
	
	@Before
	public void setUp() throws Exception {
		player = new RandomPlayer();
		board = new ThreeByThreeBoard();
	}

	@Test
	public void testGetRandomMoveFromBoard() {
		int move = player.getMove(board);
		
		assertTrue(move >= 1 && move <= board.getCellCount());
	}
	
	@Test
	public void testRandomMoveIs9(){
		board.putMove(1, GameToken.X);
		board.putMove(2, GameToken.X);
		board.putMove(3, GameToken.X);
		board.putMove(4, GameToken.X);
		board.putMove(5, GameToken.X);
		board.putMove(6, GameToken.X);
		board.putMove(7, GameToken.X);
		board.putMove(8, GameToken.X);
		
		int move = player.getMove(board);
		
		assertEquals(9, move);
	}

	@Test
	public void testRandomMoveIs5(){
		board.putMove(1, GameToken.X);
		board.putMove(2, GameToken.X);
		board.putMove(3, GameToken.X);
		board.putMove(4, GameToken.X);
		
		board.putMove(6, GameToken.X);
		board.putMove(7, GameToken.X);
		board.putMove(8, GameToken.X);
		board.putMove(9, GameToken.X);
		
		int move = player.getMove(board);
		
		assertEquals(5, move);
	}
}
