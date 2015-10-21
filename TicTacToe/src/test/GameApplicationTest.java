package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import main.CommandLineInterface;
import main.GameApplication;
import main.GameToken;

public class GameApplicationTest {
	ByteArrayOutputStream stream;
	GameApplication app;
	
	@Before
	public void setUp() throws Exception {
		stream = new ByteArrayOutputStream();
		PrintStream output = new PrintStream(stream);
		System.setOut(output);
	}

	@Test
	public void testIfPromptsForGameModeUponCreation() {
		CommandLineInterface view = new CommandLineInterface(new Scanner("1"), System.out);
		
		app = new GameApplication(view);
		
		assertTrue(stream.toString().contains("Please select a game mode:"));
	}
	
	@Test
	public void testIfPrintsGameMode1(){
		CommandLineInterface view = new CommandLineInterface(new Scanner("1 "), System.out);
		
		app = new GameApplication(view);
		
		assertTrue(stream.toString().contains("Game Mode: Human vs Human"));
	}

	@Test
	public void testIfPrintsGameMode2(){
		CommandLineInterface view = new CommandLineInterface(new Scanner("2 "), System.out);
		
		app = new GameApplication(view);
		
		assertTrue(stream.toString().contains("Game Mode: Human vs Computer"));
	}
	
	@Test
	public void testIfPrintsGameMode3(){
		CommandLineInterface view = new CommandLineInterface(new Scanner("10 3 "), System.out);
		
		app = new GameApplication(view);
		
		assertTrue(stream.toString().contains("Game Mode: Computer vs Computer"));
	}
	
	@Test
	public void testCreatePlayersForMode1(){
		CommandLineInterface view = new CommandLineInterface(new Scanner("1 "), System.out);
		
		app = new GameApplication(view);

		assertTrue(app.p1.getPiece() == GameToken.X);
		assertTrue(app.p2.getPiece() == GameToken.O);
	}
}
