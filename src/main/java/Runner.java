import db.DBHelper;
import models.character.Character;
import models.playerclasses.Barbarian;
import models.playerraces.Dwarf;

public class Runner {

	public static void main(String[] args) {

		Dwarf dwarf = new Dwarf();
		Barbarian barbarian = new Barbarian();
		Character vicky = new Character("Vicky", dwarf, barbarian);
		DBHelper.save(vicky);
	}
}
