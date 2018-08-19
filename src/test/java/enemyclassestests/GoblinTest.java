package enemyclassestests;

import models.enemyclasses.Goblin;
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
	public void canGetExperiencePointsToAward(){
		assertEquals(25, goblin.getExperiencePointsToAward());
	}

	@Test
	public void canTakeDamage(){
		goblin.takeDamage(50);
		assertEquals(50, goblin.getHealthPoints());
	}

	@Test
	public void canReturnDamageTaken(){
		assertEquals("You hit the enemy and reduced its health by 10 points!", goblin.takeDamage(10));
	}
}
