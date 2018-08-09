package playerclasses;

import creatures.Pet;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WarlockTest {

	Warlock warlock;
	@Before
	public void before(){
		warlock = new Warlock();
	}

	@Test
	public void canAddWeapon(){
		Pet pet = new Pet();
		warlock.addPet(pet);
		assertEquals(pet, warlock.getPet());
	}
}
