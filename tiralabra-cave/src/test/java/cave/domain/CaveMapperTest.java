package cave.domain;

import java.util.*;
import java.util.stream.Collectors;
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

    public CaveMapperTest() {
    }

    @Before
    public void setUp() {
        cm = new CaveMapper(100);
        c = new CaveMapper(1000);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void cavernSize100HasOver9Sleeves() {
        List<Sleeve> sleeves = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            sleeves = cm.mainCaves();
            assertTrue(sleeves.size() > 9);
        }
    }

    @Test
    public void cavernSize1000HasOver99Sleeves() {
        List<Sleeve> sleeves = new ArrayList<>();
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
        List<Sleeve> sleeves = new ArrayList<>();
        for (int k = 0; k < 1000; k++) {
            sleeves = c.mainCaves();
            for (int i = 1; i < sleeves.size(); i++) {
                assertTrue(sleeves.get(i - 1).getNumber() != sleeves.get(i).getNumber());
            }
        }
    }

    @Test
    public void noDuplicateSubCaves() {
        List<Sleeve> sleeve = new ArrayList<>();
        for (int k = 0; k < 1000; k++) {
            c.habitedSleeves.clear();
            c.needNeighbours.clear();
            c.mainCaves();
            sleeve = c.subCaves();
            for (int i = 1; i < sleeve.size(); i++) {
                assertTrue(sleeve.get(i - 1).getNumber() != sleeve.get(i).getNumber());
            }
        }
    }

    @Test
    public void mainAndSubCavesDontCross() {
        List<Sleeve> sleeves = new ArrayList<>();
        List<Sleeve> subSleeves = new ArrayList<>();
        List<Integer> subNums = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            c.habitedSleeves.clear();
            c.needNeighbours.clear();
            sleeves = c.mainCaves();
            subSleeves = c.subCaves();
            subNums = subSleeves.stream().map(a -> a.getNumber()).collect(Collectors.toList());

            for (Sleeve sleeve : sleeves) {
                if (subNums.contains(sleeve.getNumber())) {

                }
                assertFalse(subNums.contains(sleeve.getNumber()));
            }
        }
    }
}
