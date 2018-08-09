package playertests;

import org.junit.Before;
import org.junit.Test;
import player.Player;
import playerclasses.Barbarian;

import static junit.framework.TestCase.assertEquals;

public class PlayerTest {


	Player player;
	Barbarian barbarian;

	@Before
	public void before(){
		barbarian = new Barbarian();
		player = new Player("Vicky", barbarian);
	}

	@Test
	public void canGetNameAndTitle(){
		assertEquals("Vicky", player.getName());
	}

	@Test
	public void canGetHealthPoints(){
		assertEquals(100, player.getHealthPoints());
	}

	@Test
	public void canGetPlayerType(){
		assertEquals(barbarian, player.getPlayerType());
	}
}
