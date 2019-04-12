
package cave.domain;

/**
 * The class Room represents a room in the maze. 
 * The room gets its north-west corner as x,y coordinates and size from the
 * sleeves populateSleeve method.
 * rooms are only created when invoked by a construction of a sleeve.
 * 
 * @author strohm
 */
public class Room {

    private int x;
    private int y;
    int size;
    
    public Room(int x, int y, int size) {
        this.size = size;
        this.x = x;
        this.y = y;
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
}
