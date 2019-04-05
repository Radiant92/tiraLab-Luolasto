/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cave.util;

import cave.domain.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author strohm
 */
public class MyListTest {

    MyList<Sleeve> sleeveList;
    MyList<Integer> intList;
    Sleeve s;

    public MyListTest() {
    }

    @Before
    public void setUp() {
        s = new Sleeve(1);
        sleeveList = new MyList<Sleeve>();
        intList = new MyList<Integer>();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void canInitiateAIntegerAndStringLists() {
        int i = 0;
        String s = "0";

        MyList<String> strList = new MyList<String>();

        intList.add(i);
        strList.add(s);

        assertEquals(1, strList.size());
        assertEquals(1, intList.size());
    }

    @Test
    public void iniatedListIsEmpty() {
        assertEquals(0, sleeveList.size());
    }

    @Test
    public void severalObjectsCanBeAddedIntoList() {
        for (int i = 0; i < 100; i++) {
            sleeveList.add(s);
        }
        assertEquals(100, sleeveList.size());
    }

    @Test
    public void removeWorks() {
        intList.add(0);
        intList.add(1);
        intList.add(2);

        intList.remove(1);

        assertEquals(2, intList.get(1));

        assertEquals(2, intList.size());
    }

    /*
    @Test
    public void forEachTesti(){
        for (int i = 0; i<100;i++){
            intList.add(i);
        }
        for(int k = 0; k<100; k++){
            k = intList.get(k);
        }
    }
     */
    @Test
    public void arraySizeWillAdjust() {
        for (int i = 0; i < 1000000; i++) {
            intList.add(i);
        }
        assertEquals(1000000, intList.size());
    }
}
