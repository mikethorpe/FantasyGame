package playerclasses;

import itemsTests.Potion;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ClericTest {

	Cleric cleric;
	@Before
	public void before(){
		cleric = new Cleric();
	}

	@Test
	public void canAddPotion(){
		Potion potion = new Potion();
		cleric.addPotion(potion);
		assertEquals(potion, cleric.getPotion());
	}
}