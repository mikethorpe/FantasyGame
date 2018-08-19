package playerracestests;

import org.junit.Before;
import org.junit.Test;
import models.playerraces.Dwarf;

import static org.junit.Assert.assertEquals;

public class DwarfTest {

    Dwarf dwarf;

    @Before
    public void before(){
        dwarf = new Dwarf();
    }

    @Test
    public void canGetTitle(){
        assertEquals("Dwarven", dwarf.getRaceTitle());
    }

}
