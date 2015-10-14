package test;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import main.Board;
import main.GameModel;
import main.GameToken;
import main.Human;
import main.Player;
import main.ThreeByThreeBoard;

public class PlayerTest {
	Player player;
	Board board;
	GameModel game;
	
	@Before
	public void setUp() throws Exception {
		player = new Human(new Scanner(System.in));
		board = new ThreeByThreeBoard();
		game = new GameModel(board, player, player);
	}
	
	@Test
	public void testFirstPlayerGamePiece() {
		player.setPiece(GameToken.X);
		
		assertEquals("Player can have an X game piece", GameToken.X, player.getPiece());
	}
	
	@Test
	public void testSecondPlayerGamePiece() {
		player.setPiece(GameToken.O);
		
		assertEquals("Player can have an O game piece", GameToken.O, player.getPiece());
	}
}