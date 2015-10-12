import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class BoardTest {
	Board board;
	
	@Before
	public void setUp() throws Exception {
		board = new Board(9);
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
	public void testGetsEmptySpaces() {
		board.putMove(1, GameToken.X);
		board.putMove(2, GameToken.O);
		
		ArrayList<Integer> expectedSpots = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 6, 7, 8, 9));
		assertEquals(expectedSpots, board.getEmptySpots());
	}
}

