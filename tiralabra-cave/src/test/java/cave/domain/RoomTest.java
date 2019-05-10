/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cave.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author strohm
 */
public class RoomTest {

    Room small;

    public RoomTest() {
    }

    @Before
    public void setUp() {
        small = new Room(1, 2, 3);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void correctCoordinates() {
        assertEquals(1, small.getX());
        assertEquals(2, small.getY());
    }

    @Test
    public void correctSize() {
        assertEquals(3, small.getSize());
    }

    @Test
    public void middleCoordinateGettersAndSettersWork() {
        small.setMiddleX(3);
        small.setMiddleY(4);
        assertEquals(3, small.getMiddleX());
        assertEquals(4, small.getMiddleY());
    }

    @Test
    public void getAppendagesWorks() {
        small.addAppendage(new Room(3, 2, 3));
        small.addAppendage(new Room(50, 10000, 5));

        assertEquals(2, small.getAppendages().size());
        assertEquals(50, small.getAppendages().getRoom(1).getX());
    }

}
