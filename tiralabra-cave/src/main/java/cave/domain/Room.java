package cave.domain;

import cave.util.MyList;

/**
 * The class Room represents a room in the cavern. The room gets its north-west
 * corner as x,y coordinates and size from the Sleeve classes populateSleeve
 * method. rooms are only created when invoked by a construction of a sleeve.
 *
 * Rooms have appendages to other rooms representing the paths between the
 * rooms.
 *
 * All methods are O(1)
 *
 * @author strohm
 */
public class Room {

    /**
     * x coordinate of the north-west corner of the room.
     */
    private int x;
    /**
     * y coordinate of the north-west corner of the room.
     */
    private int y;
    /**
     * x coordinate of the middle of the room.
     */
    private int middleX;
    /**
     * y coordinate of the middle of the room.
     */
    private int middleY;
    /**
     * Represents the size of the room
     */
    int size;
    private MyList<Room> appendages;

    /**
     * 
     * @param x coordinate for the north-west corner of the room
     * @param y coordinate for the north-west corner of the room
     * @param size size of the room 
     */
    public Room(int x, int y, int size) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.appendages = new MyList<>(new Room(), 10);
    }

    /**
     * Constructs an empty Room object so that a Room can have a list of Rooms.
     */
    public Room() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getSize() {
        return size;
    }

    public void setMiddleX(int x) {
        middleX = x;
    }

    public void setMiddleY(int y) {
        middleY = y;
    }

    public int getMiddleX() {
        return middleX;
    }

    public int getMiddleY() {
        return middleY;
    }

    /**
     * adds a path to a neighbouring room.
     *
     * @param room the room where the appendage "path" leads
     */
    public void addAppendage(Room room) {
        appendages.addRoom(room);
    }

    public MyList<Room> getAppendages() {
        return this.appendages;
    }
}
