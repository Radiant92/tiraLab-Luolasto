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
    public void correctCoordinates(){
        assertEquals(1, small.getX());
        assertEquals(2, small.getY());
    }
    @Test
    public void correctSize(){
        assertEquals(3, small.getSize());
    }

}
