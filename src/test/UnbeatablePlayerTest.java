package test;


import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

import main.Board;
import main.GameModel;
import main.GameToken;
import main.ThreeByThreeBoard;
import main.UnbeatablePlayer;

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
		
		game = new GameModel(new ThreeByThreeBoard(), p1, p2);		
	}
	
	@Test
	public void testMakesSecondMoveAt5IfFirstIs1(){
		game.play(1);
		
		assertEquals(5, game.currentPlayer.getMove(game));
	}
	
	@Test
	public void testMakesSecondMoveAt5IfFirstIs3(){
		game.play(3);
		
		assertEquals(5, game.currentPlayer.getMove(game));
	}
	
	@Test
	public void testMakesSecondMoveAt5IfFirstIs7(){
		game.play(7);
		
		assertEquals(5, game.currentPlayer.getMove(game));
	}
	
	@Test
	public void testMakesSecondMoveAt5IfFirstIs9(){
		game.play(9);
		
		assertEquals(5, game.currentPlayer.getMove(game));
	}
	
	
	@Test
	public void testIfReturn3OnSmartMove(){
	 	game.play(2);
		game.play(7);
		game.play(6);
		game.play(8); 
		game.play(9);
		
		assertEquals(3, game.currentPlayer.getMove(game));
	}
	
	@Test
	public void testIfBlocksMoveIfXHasTwoLinedUp(){
		game.play(1);
		game.play(5);
		game.play(3);
		
		assertEquals(2, game.currentPlayer.getMove(game));
	}
}
