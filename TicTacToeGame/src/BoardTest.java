import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;
	
	@Before
	public void setUp() throws Exception {
		board = new ThreeByThreeBoard();
	}

	@Test
	public void testEmptyBoardSpot() {		
		assertEquals(GameToken.EMPTY, board.getMove(1));
	}
	
	@Test
	public void testCanMakeMove() {
		board.putMove(1, GameToken.X);
		
		assertEquals(GameToken.X, board.getMove(1));
	}
	
	@Test
	public void testBoardWinFalseWhenNewGame(){
		assertFalse(board.win(GameToken.O));
	}
	
	@Test
	public void testWhenGameTokenXWinsAt123(){
		board.putMove(1, GameToken.X);
		board.putMove(2, GameToken.X);
		board.putMove(3, GameToken.X);
		
		assertTrue(board.win(GameToken.X));
	}
	
	@Test
	public void testWhenGameTokenOWinsAt159(){
		board.putMove(1, GameToken.O);
		board.putMove(5, GameToken.O);
		board.putMove(9, GameToken.O);
		
		assertTrue(board.win(GameToken.O));
	}
}

