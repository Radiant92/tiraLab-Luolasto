package cave.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author strohm
 */
public class SleeveTest {

    Sleeve s0;
    Sleeve s39;

    public SleeveTest() {
    }

    @Before
    public void setUp() {
        s0 = new Sleeve(0);
        s39 = new Sleeve(39);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void coordinatesAreCorrect() {
        assertEquals(0, s0.getX());
        assertEquals(0, s0.getY());

        assertEquals(63, s39.getX());
        assertEquals(21, s39.getY());

    }

    @Test
    public void numberIsCorrect() {
        assertEquals(0, s0.getNumber());
        assertEquals(39, s39.getNumber());
    }
    @Test
    public void roomIsInTheRange() {
        Room r0 = s0.getRoom();
        Room r39 = s39.getRoom();
        
        assertTrue(r0.getX() >= 0 && r0.getX() <= 4);
        assertTrue(r0.getY() >= 0 && r0.getY() <= 4);
        
        assertTrue(r39.getX() >= 63 && r39.getX() <= 67);
        assertTrue(r39.getY() >= 21 && r39.getY() <= 25);
        
    }
}
