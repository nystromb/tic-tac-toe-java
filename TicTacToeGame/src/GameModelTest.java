import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GameModelTest {
	Board board;
	Player p1, p2;
	GameModel game;
	
	@Before
	public void setUp() throws Exception {
		board = new ThreeByThreeBoard();
		
		p1 = new Human();
		p1.setPiece(GameToken.X);
		
		p2 = new Human();
		p2.setPiece(GameToken.O);
		
		game = new GameModel(board, p1, p2);
	}
	
	@After
	public void clearBoard(){
		board.clearAll();
	}
	
	@Test
	public void testGetGameBoardInstance(){
		assertEquals(game.board, board);
	}
	
	@Test
	public void testGetsEmptySpaces() {
		game.play(1);
		game.play(2);
		
		ArrayList<Integer> expectedSpots = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 6, 7, 8, 9));
		assertEquals(expectedSpots, game.getEmptySpots());
	}
	
	
	@Test
	public void testGameIsNotOverWhenNewGame() {
		assertFalse(game.isOver());
	}
	
	@Test
	public void testPlayerXCanWin(){
		game.play(1);
		game.play(2);
		game.play(3);
		
		assertTrue(game.isOver());
	}

	@Test
	public void testPlayerOCanWin() {
		
	}
}
