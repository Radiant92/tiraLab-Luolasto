
package cave.domain;

import cave.util.MyList;

/**
 * TÄMÄ LUOKKA EI TEE MITÄÄN JA POISTUU TODENNÄKÖISESTI PIAN!
 * @author strohm
 */
public class Paths {

    private Sleeve important;
    private int level;
    final int deep;
    final int[][] path;

    public Paths(MyList<Sleeve> mainCaves, MyList<Sleeve> subCaves, int deep) {
        this.level = 7;
        this.deep = deep;
        this.path = new int[deep][deep];

        mapRooms(mainCaves);
        mapRooms(subCaves);
    }

    public void mapRooms(MyList<Sleeve> sleeves) {
        for (int i = 0; i < sleeves.size(); i++) {
            Sleeve s = sleeves.getSleeve(i);
            Room r = s.getRoom();
            path[r.getMiddleX()][r.getMiddleY()] = 1;
        }
    }

    public int[][] getPath() {
        return path;
    }
}
