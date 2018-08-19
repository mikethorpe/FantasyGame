package itemstests;

import models.items.Staff;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class StaffTest {

    Staff staff;

    @Before
    public void before(){
        staff = new Staff();
    }

    @Test
    public void canGetAttackPoints(){
        assertEquals(4, staff.getAttackPoints());
    }

    @Test
    public void canGetName(){
        assertEquals("Staff", staff.getName());
    }
}
