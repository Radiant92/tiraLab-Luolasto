
package cave.util;

import java.util.ArrayList;

/**
 * Utility Class "MyList" creates a dynamic list that can be initiated the same
 * way as an ArrayList by calling 
 * MyList<insert class> name = new MyList<insert class>();
 * 
 * currently it uses a Object[] to store elements.
 * It can be used to add, remove and get elements and asked size() for the
 * amount of elements it contains.
 * removing and getting elements require it to be given an corresponding index.
 * 
 * @author strohm
 */
public class MyList<E> {

    private Object[] array;
    private int counter;
    private int head;

    public MyList() {
    
        this.array = new Object[100];
        this.counter = 100;
        this.head = 0;
    }

    public void add(E e) {

            if (counter == head) {
                array = doubleSize();
            }
            this.array[this.head] = e;
            this.head++;
        }
    

    public Object[] doubleSize() {
        int increase = 0;
        if (counter * 2 > Integer.MAX_VALUE) {
            increase = Integer.MAX_VALUE;
        } else {
            increase = counter * 2;
        }
        Object[] bigger = new Object[increase];

        for (int i = 0; i < counter; i++) {
            bigger[i] = array[i];
        }
        counter = increase;
        return bigger;
    }

    public Object get(int index) {
        if (index >= 0 && index <= head) {
            return this.array[index];
        }
        return null;
    }

    public void remove(int index) {
        moveLeft(index);
        head--;
    }

    public void moveLeft(int index) {
        for (int i = index; i <= this.head; i++) {
            this.array[i] = this.array[i + 1];
        }
        this.array[head] = null;
    }

    public int size() {
        return head;
    }
}
