package itemstests;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class SwordTest {

	Sword sword;

	@Before
	public void before(){
		sword = new Sword();
	}

	@Test
	public void canGetAttackPoints(){
		assertEquals(5, sword.getAttackPoints());
	}

	@Test
	public void canGetName(){
		assertEquals("Sword", sword.getName());
	}
}
