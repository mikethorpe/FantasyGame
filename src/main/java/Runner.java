import db.DBHelper;
import models.character.Character;
import models.creatures.Pet;
import models.interfaces.IPlayerClass;
import models.items.Potion;
import models.playerclasses.Barbarian;
import models.playerraces.Dwarf;

public class Runner {

	public static void main(String[] args) {

		Dwarf dwarf = new Dwarf();
		Barbarian barbarian = new Barbarian();
		Character vicky = new Character("Vicky", dwarf, barbarian);
		DBHelper.save(vicky);

		IPlayerClass vickysRace = vicky.getPlayerClass();
		vicky.addPotion(new Potion());
		vicky.addPet(new Pet());
		DBHelper.update(vicky);



	}



}
