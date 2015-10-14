 package test;


import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Board;
import main.CommandLineInterface;
import main.GameModel;
import main.GameToken;
import main.Human;
import main.Player;
import main.ThreeByThreeBoard;

public class GameModelTest {
	Board board;
	Player p1, p2;
	GameModel game;
	
	@Before
	public void setUp() throws Exception {
		board = new ThreeByThreeBoard();
		
		p1 = new Human(new Scanner(System.in));
		p1.setPiece(GameToken.X);
		 
		p2 = new Human(new Scanner(System.in));
		p2.setPiece(GameToken.O);
		
		game = new GameModel(board, p1, p2);
		
		game.addObserver(new CommandLineInterface(new Scanner(System.in)));
	}

	@After
	public void clearBoard(){
		game.board.clearAll();
	}
	
	@Test
	public void testForCloneGameModel(){ 
		GameModel copy = game.newGameState(1);
		
		assertNotEquals(game, copy);
	}
	
	@Test 
	public void testForNewGameState(){
		GameModel newGame = game.newGameState(1);
		
		assertEquals(GameToken.X, newGame.board.getMove(1));
		assertEquals(GameToken.O, newGame.currentPlayer.getPiece());
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
		game.play(1); // X
		game.play(3); // O
		game.play(2); // X
		game.play(4); // O
		game.play(6); // X
		game.play(5); // O
		game.play(7); // X
		game.play(8); // O
		game.play(9); // X
		
		assertTrue(game.isOver());
	}
}
