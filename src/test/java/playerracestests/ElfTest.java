package playerracestests;

import org.junit.Before;
import org.junit.Test;
import playerraces.Elf;

import static org.junit.Assert.assertEquals;

public class ElfTest {

    private Elf elf;

    @Before
    public void before(){
        elf = new Elf();
    }

    @Test
    public void canGetTitle(){
        assertEquals("Elven", elf.getRaceTitle());
    }
}
