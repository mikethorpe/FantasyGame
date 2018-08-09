package playerclasses;

import itemsTests.Potion;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ClericTest {

	Cleric cleric;
	@Before
	public void before(){
		cleric = new Cleric("Jim");
	}

	@Test
	public void canGetName(){
		assertEquals("Jim", cleric.getName());
	}

	@Test
	public void canGetHealthPoints(){
		assertEquals(100, cleric.getHealthPoints());
	}

	@Test
	public void canAddPotion(){
		Potion potion = new Potion();
		cleric.addPotion(potion);
		assertEquals(potion, cleric.getPotion());
	}
}