package test;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import main.CommandLineInterface;
import main.GameModel;
import main.GameToken;
import main.Human;
import main.Player;
import main.ThreeByThreeBoard;

public class PlayerTest {
	Player player;
	GameModel game;
	
	@Before
	public void setUp() throws Exception {
		CommandLineInterface cli = new CommandLineInterface(new Scanner(System.in), System.out);
		player = new Human(cli);
		game = new GameModel(new ThreeByThreeBoard(), player, player);
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
	
	@Test
	public void testGetMoveFromHumanPlayer(){
		this.player = new Human(new CommandLineInterface(new Scanner("some garbage input 10 1"), System.out));
		
		int move = player.getMove(game);
		
		assertTrue(game.moveIsValid(move));
	}
}