package cave.domain;

import cave.util.MyList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author strohm
 */
public class CaveMapperTest {

    CaveMapper cm;
    CaveMapper c;
    Sleeve s;

    public CaveMapperTest() {
    }

    @Before
    public void setUp() {
        cm = new CaveMapper(100);
        c = new CaveMapper(1000);
        s = new Sleeve(-1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void cavernSize100HasOver9Sleeves() {
        MyList<Sleeve> sleeves = new MyList<Sleeve>(s, 100);
        for (int i = 0; i < 100; i++) {
            sleeves = cm.mainCaves();
            assertTrue(sleeves.size() > 9);
        }
    }

    @Test
    public void cavernSize1000HasOver99Sleeves() {
        MyList<Sleeve> sleeves = new MyList<Sleeve>(s, 1000);
        for (int i = 0; i < 100; i++) {
            sleeves = c.mainCaves();
            assertTrue(sleeves.size() > 99);
        }
    }

    @Test
    public void subCaves25For100() {
        cm.mainCaves();
        assertEquals(25, cm.subCaves().size());

    }

    @Test
    public void subCaves250For1000() {
        c.mainCaves();
        assertEquals(250, c.subCaves().size());

    }

    @Test
    public void noDuplicateMainCaves() {
        MyList<Sleeve> sleeves = new MyList<Sleeve>(s, 1000);
        for (int k = 0; k < 1000; k++) {
            sleeves = c.mainCaves();
            for (int i = 1; i < sleeves.size(); i++) {
                assertTrue(sleeves.getSleeve(i - 1).getNumber() != sleeves.getSleeve(i).getNumber());
            }
        }
    }

    @Test
    public void noDuplicateSubCaves() {
        MyList<Sleeve> sleeve = new MyList<Sleeve>(s, 1000);
        for (int k = 0; k < 1000; k++) {
            c = new CaveMapper(1000);
            c.mainCaves();
            sleeve = c.subCaves();
            for (int i = 1; i < sleeve.size(); i++) {
                assertTrue(sleeve.getSleeve(i - 1).getNumber() != sleeve.getSleeve(i).getNumber());
            }
        }
    }

    @Test
    public void mainAndSubCavesDontCross() {
        MyList<Sleeve> sleeves = new MyList<Sleeve>(s, 1000);
        MyList<Sleeve> subSleeves = new MyList<Sleeve>(s, 1000);
        for (int i = 0; i < 1000; i++) {
            c = new CaveMapper(1000);
            sleeves = c.mainCaves();
            subSleeves = c.subCaves();
            MyList<Integer> subNums = new MyList<Integer>(1, 1000);
            for (int z = 0; z < subSleeves.size(); z++) {
                subNums.addInteger(subSleeves.getSleeve(z).getNumber());
            }
            for (int l = 0; l < sleeves.size(); l++) {
                assertFalse(subNums.contains(sleeves.getSleeve(l).getNumber()));
            }
        }
    }
}
