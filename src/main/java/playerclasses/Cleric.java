package playerclasses;

import itemsTests.Potion;
import player.Player;

public class Cleric extends Player {

	private Potion potion;

	public Cleric(String name) {
		super(name);
	}

	public Potion getPotion() {
		return potion;
	}

	public void addPotion(Potion potion){
		this.potion = potion;
	}
}
