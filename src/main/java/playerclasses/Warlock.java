package playerclasses;

import creatures.Pet;
import player.Player;

public class Warlock extends Player {

	private Pet pet;

	public Warlock(String name) {
		super(name);
	}

	public Pet getPet() {
		return pet;
	}

	public void addPet(Pet pet){
		this.pet = pet;
	}
}
