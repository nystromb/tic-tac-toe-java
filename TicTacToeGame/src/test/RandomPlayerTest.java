package test;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import main.Board;
import main.GameModel;
import main.GameToken;
import main.Player;
import main.RandomPlayer;
import main.ThreeByThreeBoard;

public class RandomPlayerTest {
	Player p1, p2;
	Board board;
	GameModel game;
	
	@Before
	public void setUp() throws Exception {
		p1 = new RandomPlayer();
		p1.setPiece(GameToken.X);
		
		p2 = new RandomPlayer();
		p2.setPiece(GameToken.O);
				
		game = new GameModel(new ThreeByThreeBoard(), p1, p2);
	}

	@Test
	public void testGetRandomMoveFromBoard() {
		int move = p1.getMove(game);
		
		assertTrue(game.moveIsValid(move));
	}
	
	@Test
	public void testRandomMoveIs9(){
		game.play(1);
		game.play(2); 
		game.play(3);
		game.play(4);
		game.play(5);
		game.play(6);
		game.play(8);
		game.play(7);
		
		int move = p1.getMove(game);
		
		assertEquals(9, move);
	}

	@Test
	public void testRandomMoveIs5(){
		game.play(1);
		game.play(2);
		game.play(3);
		game.play(4);
		game.play(6);
		game.play(7);
		game.play(8);
		game.play(9);
		
		
		int move = p1.getMove(game);
		
		assertEquals(5, move);
	}
}