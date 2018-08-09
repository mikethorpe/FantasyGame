package enemyclassestests;

import enemyclasses.Goblin;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class GoblinTest {

	Goblin goblin;
	@Before
	public void before(){
		goblin = new Goblin();
	}

	@Test
	public void canGetHealthPoints(){
		assertEquals(100, goblin.getHealthPoints());
	}

	@Test
	public void canTakeDamaage(){
		goblin.takeDamage(50);
		assertEquals(50, goblin.getHealthPoints());
	}

	@Test
	public void canReturnDamageTaken(){
		assertEquals("Ouch, that hurt by exactly 10 points!", goblin.takeDamage(10));
	}
}
