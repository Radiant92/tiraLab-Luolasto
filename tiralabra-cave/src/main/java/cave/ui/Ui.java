package cave.ui;

import cave.domain.*;
import cave.util.MyList;
import java.awt.Color;

/**
 * The user interface class will provide options on how the caverns will be
 * created. For now the user interface automatically creates a list of sleeves
 * which contain rooms and then calls the Draw class to draw a crude visual of
 * their placement. The user interface chooses the rooms randomly and later the
 * number of rooms can be fixed. adjusting the deep value let's you control the
 * depth of the cave in increments of 100. currently it is fixed as 200 until i
 * finish the user interface and path drawing.
 *
 * @author strohm
 */
public class Ui {

    public static void main(String[] args) {
        int deep = 200;

        CaveMapper cMapper = new CaveMapper(deep);
        Draw d = new Draw(1920, 1200, "Cavern");

        long time = System.currentTimeMillis();
        MyList mainCaves = cMapper.mainCaves();
        time = System.currentTimeMillis() - time;
        System.out.println("time " + time);
        d.drawRooms(Color.RED, mainCaves);
        long entireTime = time;

        time = System.currentTimeMillis();
        MyList subCaves = cMapper.subCaves();
        time = System.currentTimeMillis() - time;
        d.drawRooms(Color.GREEN, subCaves);

        System.out.println("sub-room buid time: " + time);
        entireTime += time;
        System.out.println("entire time: " + entireTime);

        //Paths paths = new Paths(mainCaves, subCaves, deep);
       
        d.drawPaths(mainCaves, Color.BLUE);
        d.drawPaths(subCaves, Color.PINK);

        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.exit(0);
    }
}
