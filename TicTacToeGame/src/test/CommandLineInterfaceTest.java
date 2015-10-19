package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import main.CommandLineInterface;
import main.GameModel;
import main.GameToken;
import main.Human;
import main.Player;
import main.ThreeByThreeBoard;

public class CommandLineInterfaceTest {
	ByteArrayOutputStream stream;
	CommandLineInterface cli;
	GameModel game;
	
	@Before
	public void setUp() throws Exception {
		stream = new ByteArrayOutputStream();
		PrintStream output = new PrintStream(stream);
		System.setOut(output);
		
		cli = new CommandLineInterface(new Scanner(System.in), System.out);
				 
		Player p1 = new Human(cli);
		p1.setPiece(GameToken.X);
		 
		Player p2 = new Human(cli);
		p2.setPiece(GameToken.O);
		
		game = new GameModel(new ThreeByThreeBoard(), p1, p2);
	}
	
	@Test 
	public void testIfPrintsGameBoard(){
		cli.update(game, game.board);
		
		assertTrue(stream.toString().contains("1|2|3\n4|5|6\n7|8|9\n"));
		 
		game.play(1);
		
		cli.update(game, game.board);
		
		assertTrue(stream.toString().contains("X|2|3\n4|5|6\n7|8|9\n"));
		
		game.play(2);
		
		cli.update(game, game.board);
		
		assertTrue(stream.toString().contains("X|O|3\n4|5|6\n7|8|9\n"));
		
		game.play(3);
		
		cli.update(game, game.board);
		
		assertTrue(stream.toString().contains("X|O|X\n4|5|6\n7|8|9\n"));
		
		game.play(4);
		
		cli.update(game, game.board);
		
		assertTrue(stream.toString().contains("X|O|X\nO|5|6\n7|8|9\n"));
	} 
	
	@Test
	public void testGetGameInput(){
		cli = new CommandLineInterface(new Scanner("some invalid input 1"), System.out);
		
		assertEquals(1, cli.getGameInput());
	}

}
