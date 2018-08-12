package playerracestests;

import org.junit.Before;
import org.junit.Test;
import playerraces.Human;

import static org.junit.Assert.assertEquals;

public class HumanTest {

    Human human;

    @Before
    public void before(){
        human = new Human();
    }

    @Test
    public void canGetTitle(){
        assertEquals("Human", human.getRaceTitle());
    }
}
