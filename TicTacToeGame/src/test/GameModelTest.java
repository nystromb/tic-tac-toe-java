 package test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import main.CommandLineInterface;
import main.GameModel;
import main.GameToken;
import main.Human;
import main.Player;
import main.ThreeByThreeBoard;

public class GameModelTest {
	Player p1, p2;
	GameModel game;
	
	@Before
	public void setUp() throws Exception {
		CommandLineInterface cli = new CommandLineInterface(new Scanner(System.in), System.out);
		p1 = new Human(cli);
		p1.setPiece(GameToken.X);
		 
		p2 = new Human(cli);
		p2.setPiece(GameToken.O);
		
		game = new GameModel(new ThreeByThreeBoard(), p1, p2);
		
		//game.addObserver(new CommandLineInterface(new Scanner(System.in)));
	}
	
	@Test
	public void testCanPutAMoveAt9(){
		game.play(9);
		assertEquals(GameToken.X, game.board.getMove(9));	
	}
	
	@Test
	public void testCannotPutAMoveAt10(){
		assertEquals(game.player1, game.currentPlayer);
		
		game.play(10);
		
		assertEquals(game.player1, game.currentPlayer);
	}
	
	@Test
	public void testForCloneGameModel(){ 
		GameModel copy = new GameModel(game);
		
		assertNotEquals(game, copy);
	}
	
	@Test 
	public void testForNewGameState(){
		game.play(1);
		
		GameModel newGame = new GameModel(game);
		
		assertEquals(GameToken.X, newGame.board.getMove(1));
		assertEquals(GameToken.O, newGame.currentPlayer.getPiece());
		assertNotEquals(newGame.board, game.board);
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
		game.play(1); // Player X
		game.play(4); // Player O
		game.play(3); // Player X
		game.play(7); // Player O		
		game.play(2); // Player X
		
		assertTrue(game.isOver());
	}

	@Test
	public void testPlayerOCanWin() {		
		game.play(1); // Player X
		game.play(5); // Player O
		game.play(2); // Player X
		game.play(6); // Player O
		game.play(7); // Player X		
		game.play(4); // Player O
		
		assertTrue(game.isOver());
	}
	
	@Test
	public void testGameIsOverAfter9Moves()	{
		game.play(1); // Player X
		game.play(3); // Player O
		game.play(2); // Player X
		game.play(4); // Player O
		game.play(6); // Player X
		game.play(5); // Player O
		game.play(7); // Player X
		game.play(8); // Player O		
		game.play(9); // Player X
		
		assertTrue(game.isOver());
	}
	
	@Test
	public void testUnplayMove(){
		assertEquals(GameToken.X, game.currentPlayer.getPiece());
		assertEquals(GameToken.EMPTY, game.board.getMove(1));
		
		game.play(1);
		
		assertEquals(GameToken.O, game.currentPlayer.getPiece());
		assertEquals(GameToken.X, game.board.getMove(1));
		
		game.unplay(1);
		
		assertEquals(GameToken.X, game.currentPlayer.getPiece());
		assertEquals(GameToken.EMPTY, game.board.getMove(1));
		
	}
}
