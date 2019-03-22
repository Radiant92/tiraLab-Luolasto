
package cave.domain;

import java.util.*;

/**
 * The class Sleeve works as a "sleeve" that can hold a room in its space.
 * Each sleeve is the same size and when populated generates a room somewhere
 * inside its space which can vary in size but no smaller than 3x3 or bigger
 * than the sleeves.
 * the x, y coordinates represent the sleeves starting point in a x,y table, so
 * that the sleeves are in rows of 10 sleeves.
 * 
 * @author strohm
 * 
 */
public class Sleeve {

    private int number;
    private Room room;
    private int x;
    private int y;

    public Sleeve(int number) {
        this.number = number;
        this.x = (number % 10) * 7;
        this.y = (number / 10) * 7;
        populateSleeve();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getNumber() {
        return number;
    }

    public Room getRoom() {
        return room;
    }

    public void populateSleeve() {
        Random random = new Random();
        int size = random.nextInt(3);
        int roomX = 0;
        int roomY = 0;

        if (size == 0) {
            roomX = random.nextInt(5) + x;
            roomY = random.nextInt(5) + y;
            size = 3;
        } else if (size == 1) {
            roomX = random.nextInt(3) + x;
            roomY = random.nextInt(3) + y;
            size = 5;
        } else {
            roomX = x;
            roomY = y;
            size = 7;
        }
        this.room = new Room(roomX, roomY, size);
    }
}
