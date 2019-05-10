/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cave.util;

import cave.domain.*;
import org.junit.After;

import org.junit.Before;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author strohm
 */
public class MyListTest {

    MyList<Sleeve> sleeveList;
    MyList<Integer> intList;
    MyList<Room> roomList;
    Sleeve s;
    Room r;

    public MyListTest() {
    }

    @Before
    public void setUp() {
        s = new Sleeve(1);
        r = new Room(1, 1, 3);
        sleeveList = new MyList<Sleeve>(s, 1);
        intList = new MyList<Integer>(1, 1);
        roomList = new MyList<Room>(r, 1);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void canInitiateAllThreeList() {
        assertEquals(0, roomList.size());
        assertEquals(0, intList.size());
        assertEquals(0, sleeveList.size());
    }

    @Test
    public void iniatedListIsEmpty() {
        assertEquals(0, sleeveList.size());
    }

    @Test
    public void severalObjectsCanBeAddedIntoList() {
        for (int i = 0; i < 100; i++) {
            sleeveList.addSleeve(s);
        }
        assertEquals(100, sleeveList.size());
    }

    @Test
    public void removeWorks() {
        intList.addInteger(0);
        intList.addInteger(1);
        intList.addInteger(2);

        intList.remove(1);

        assertEquals(2, intList.getInteger(1));

        assertEquals(2, intList.size());
    }

    @Test
    public void removeWorksForAll() {
        intList.addInteger(0);
        for (int i = 0; i < 100; i++) {
            roomList.addRoom(r);
        }
        sleeveList.addSleeve(s);

        intList.remove(0);
        roomList.remove(0);
        sleeveList.remove(0);

        assertEquals(0, intList.size());
        assertEquals(99, roomList.size());
        assertEquals(0, intList.size());
    }

    @Test
    public void forEachWorks() {
        for (int i = 0; i < 100; i++) {
            intList.addInteger(i);
        }
        for (int k = 0; k < 100; k++) {
            int v = intList.getInteger(k);
            assertEquals(v, k);
        }
    }

    @Test
    public void arraySizeWillAdjust() {
        for (int i = 0; i < 1000000; i++) {
            intList.addInteger(i);
            roomList.addRoom(r);
            sleeveList.addSleeve(s);
        }
        assertEquals(1000000, intList.size());
        assertEquals(1000000, roomList.size());
        assertEquals(1000000, sleeveList.size());
    }

    @Test
    public void getWorksForAll() {
        intList.addInteger(1);
        roomList.addRoom(r);
        sleeveList.addSleeve(s);

        assertEquals(1, intList.getInteger(0));
        assertEquals(r, roomList.getRoom(0));
        assertEquals(s, sleeveList.getSleeve(0));
    }

    @Test
    public void containsWorks() {
        intList.addInteger(44);
        roomList.addRoom(r);
        sleeveList.addSleeve(s);

        assertTrue(intList.contains(44));
        assertTrue(sleeveList.contains(s));
        assertTrue(roomList.contains(r));
        intList.remove(0);
        sleeveList.remove(0);
        roomList.remove(0);
        assertFalse(intList.contains(44));
        assertFalse(roomList.contains(r));
        assertFalse(sleeveList.contains(s));
    }

}
