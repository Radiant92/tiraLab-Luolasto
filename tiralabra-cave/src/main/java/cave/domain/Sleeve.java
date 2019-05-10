package cave.domain;

import java.util.Random;

/**
 * The class Sleeve works as a "sleeve" that can hold a room in it's space. Each
 * sleeve is the same size 7x7 and when populated a room is generated somewhere
 * inside it's space which can vary in size but no smaller than 3x3 or bigger
 * than the sleeves. the x, y coordinates represent the sleeves north-west
 * corner in a x,y table, so that the sleeves are in rows of 10 sleeves.
 *
 * All methods are O(1)
 *
 * @author strohm
 *
 */
public class Sleeve {

    int number;
    Room room;
    /**
     * a coordinate to represent where the starting point of the sleeve is
     */
    int x;
    /**
     * a coordinate to represent where the starting point of the sleeve is
     */
    int y;

    /**
     * the constructor determines the space of the sleeve and then populates it.
     *
     * @param number identifying the sleeve
     */
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

    /**
     * depending on the random size the method decides where in the sleeve will
     * a room be set and the size of the room.
     */
    public void populateSleeve() {
        Random random = new Random();
        int size = random.nextInt(3);
        switch (size) {
            case 0:
                makeRoom(random.nextInt(5) + x, random.nextInt(5) + y, 3);
                break;
            case 1:
                makeRoom(random.nextInt(3) + x, random.nextInt(3) + y, 5);
                break;
            default:
                makeRoom(x, y, 7);
                break;
        }
    }

    /**
     * creates a new Room that will be inside the sleeve.
     *
     * @param x coordinate for the north-west corner of the room
     * @param y coordinate for the north-west corner of the room
     * @param size size of the room
     */
    public void makeRoom(int x, int y, int size) {
        this.room = new Room(x, y, size);
    }
}
