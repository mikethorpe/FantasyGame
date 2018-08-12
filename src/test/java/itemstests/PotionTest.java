package itemstests;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PotionTest {

	Potion potion;

	@Before
	public void before(){
		potion = new Potion();
	}


	@Test
	public void canGetName(){
		assertEquals("Potion", potion.getName());
	}

	@Test
	public void canGetHealthPointsFromPotion(){
		assertEquals(10, potion.giveHealthPoints());
	}
}
