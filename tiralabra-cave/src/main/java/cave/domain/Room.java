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

    private int x;
    private int y;
    private int middleX;
    private int middleY;
    int size;
    private MyList<Room> appendages;

    public Room(int x, int y, int size) {
        this.size = size;
        this.x = x;
        this.y = y;
        this.appendages = new MyList<Room>(new Room(), 10);
    }

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
