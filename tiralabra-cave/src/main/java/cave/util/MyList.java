package cave.util;

import cave.domain.*;

/**
 * Utility Class "MyList" creates a dynamic list that can be initiated in a
 * similar way as an ArrayList by calling MyList<insert class> name = new
 * MyList<insert class>(insert an integer, Room or Sleeve and the initial size
 * of the list);
 *
 * It can be used to add, remove and get elements and asked size() for the
 * amount of elements it contains and contains(Object o) to get a boolean value
 * whether the list contains the object or not. removing and getting elements
 * require it to be given an corresponding index.
 *
 * @author strohm
 */
public class MyList<E> {

    private int[] intArray;
    private Room[] roomArray;
    private Sleeve[] sleeveArray;
    /**
     * represents the current array in use with values either 1, 2 and 3
     */
    final int inUse;
    /**
     * size of the array in use
     */
    private int counter;
    /**
     * index of the last element
     */
    private int head;

    /**
     * Constructs an array of Integers, Rooms or Sleeves depending on the
     * initial element given. Depending on the element the constructor assigns a
     * value to inUse and sets head as 0 and counter as the initial size. Time
     * complexity: O(1)
     *
     * @param e represents the elements that the list will contain.
     * @param initialSize represents the initial size of the array.
     */
    public MyList(E e, int initialSize) {
        if (e.getClass() == Integer.class) {
            this.intArray = new int[initialSize];
            inUse = 1;
        } else if (e.getClass() == Room.class) {
            this.roomArray = new Room[initialSize];
            inUse = 2;
        } else {
            this.sleeveArray = new Sleeve[initialSize];
            inUse = 3;
        }
        this.counter = initialSize;
        this.head = 0;
    }

    /**
     * first checks to see if current array is large enough for the new integer.
     * If not, increases the size of the array and then adds the integer
     *
     * Time complexity: If array is big enough O(1) else O(n)
     *
     * @param i the integer to be added.
     */
    public void addInteger(int i) {
        if (counter == head) {
            this.intArray = doubleSizeInteger();
        }
        this.intArray[this.head] = i;
        this.head++;
    }

    /**
     * first checks to see if current array is large enough for the new room. If
     * not, increases the size of the array and then adds the integer
     *
     * Time complexity: If array is big enough O(1) else O(n)
     *
     * @param r the room to be added.
     */
    public void addRoom(Room r) {
        if (counter == head) {
            this.roomArray = doubleSizeRoom();
        }
        this.roomArray[this.head] = r;
        this.head++;
    }

    /**
     * first checks to see if current array is large enough for the new sleeve.
     * If not, increases the size of the array and then adds the integer
     *
     * Time complexity: If array is big enough O(1) else O(n)
     *
     * @param s the sleeve to be added.
     */
    public void addSleeve(Sleeve s) {
        if (counter == head) {
            this.sleeveArray = doubleSizeSleeve();
        }
        this.sleeveArray[this.head] = s;
        this.head++;
    }

    /**
     * checks if the increased size will exeed the maximum integer value, if not
     * the method will double the size of the array and return it to caller
     *
     * Time complexity O(n)
     *
     * @return a bigger array
     */
    public int[] doubleSizeInteger() {
        int increase = 0;
        if (counter >= Integer.MAX_VALUE / 2) {
            increase = Integer.MAX_VALUE;
        } else {
            increase = counter * 2;
        }
        int[] bigger = new int[increase];

        for (int i = 0; i < counter; i++) {
            bigger[i] = intArray[i];
        }
        counter = increase;
        return bigger;
    }

    /**
     * checks if the increased size will exceed the maximum integer value, if
     * not the method will double the size of the array and return it to caller
     *
     * Time complexity O(n)
     *
     * @return a bigger array
     */
    public Room[] doubleSizeRoom() {
        int increase = 0;
        if (counter >= Integer.MAX_VALUE / 2) {
            increase = Integer.MAX_VALUE;
        } else {
            increase = counter * 2;
        }
        Room[] bigger = new Room[increase];

        for (int i = 0; i < counter; i++) {
            bigger[i] = roomArray[i];
        }
        counter = increase;
        return bigger;
    }

    /**
     * checks if the increased size will exceed the maximum integer value, if
     * not the method will double the size of the array and return it to caller
     *
     * Time complexity O(n)
     *
     * @return a bigger array
     */
    public Sleeve[] doubleSizeSleeve() {
        int increase = 0;
        if (counter >= Integer.MAX_VALUE / 2) {
            increase = Integer.MAX_VALUE;
        } else {
            increase = counter * 2;
        }
        Sleeve[] bigger = new Sleeve[increase];

        for (int i = 0; i < counter; i++) {
            bigger[i] = sleeveArray[i];
        }
        counter = increase;
        return bigger;
    }

    public int getInteger(int index) {
        if (index >= 0 && index <= head) {
            return this.intArray[index];
        }
        return -1;
    }

    public Room getRoom(int index) {
        if (index >= 0 && index <= head) {
            return this.roomArray[index];
        }
        return null;
    }

    public Sleeve getSleeve(int index) {
        if (index >= 0 && index <= head) {
            return this.sleeveArray[index];
        }
        return null;
    }

    /**
     * removes the element of the array corresponding to the given index.
     *
     * Time complexity O(n)
     *
     * @param index which element to remove
     */
    public void remove(int index) {
        if (inUse == 1) {
            moveLeftInt(index);
        } else if (inUse == 2) {
            moveLeftRoom(index);
        } else {
            moveLeftSleeve(index);
        }
        head--;
    }

    /**
     * moves all the elements of the array left coming after the removed element
     *
     * Time complexity O(n)
     *
     * @param index represents the element that is removed
     */
    public void moveLeftInt(int index) {
        for (int i = index; i < this.head - 1; i++) {
            this.intArray[i] = this.intArray[i + 1];
        }
        this.intArray[head - 1] = 0;
    }

    /**
     * moves all the elements of the array left coming after the removed element
     * Time complexity O(n)
     *
     * @param index represents the element that is removed
     */
    public void moveLeftRoom(int index) {
        for (int i = index; i < this.head - 1; i++) {
            this.roomArray[i] = this.roomArray[i + 1];
        }
        this.roomArray[head - 1] = null;
    }

    /**
     * moves all the elements of the array left coming after the removed element
     * Time complexity O(n)
     *
     * @param index represents the element that is removed
     */
    public void moveLeftSleeve(int index) {
        for (int i = index; i < this.head - 1; i++) {
            this.sleeveArray[i] = this.sleeveArray[i + 1];
        }
        this.sleeveArray[head - 1] = null;
    }

    public int size() {
        return head;
    }

    /**
     * Time complexity O(n)
     *
     * @param o the object that is being searched
     * @return true or false if the object is found.
     */
    public boolean contains(Object o) {
        if (inUse == 1) {
            for (int i = 0; i < head; i++) {
                if (o.equals(this.intArray[i])) {
                    return true;
                }
            }
        } else if (inUse == 2) {
            for (int i = 0; i < head; i++) {
                if (o.equals(this.roomArray[i])) {
                    return true;
                }
            }
        } else {
            for (int i = 0; i < head; i++) {
                if (o.equals(this.sleeveArray[i])) {
                    return true;
                }
            }
        }
        return false;
    }
}
