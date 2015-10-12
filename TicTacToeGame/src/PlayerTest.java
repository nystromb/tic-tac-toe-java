import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
	Player player;
	
	@Before
	public void setUp() throws Exception {
		player = new Human();
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
