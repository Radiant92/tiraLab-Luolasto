package cave.ui;

import cave.domain.*;
import cave.util.MyList;
import java.awt.Color;
import java.util.*;

/**
 * The Ui class will provide options on how the caverns will be created. For now
 * the ui automatically creates a list of sleeves which contain rooms and then
 * calls the Draw class to draw a crude visual of their placement. The Ui
 * chooses the rooms randomly and later the number of rooms can be fixed.
 *
 * adjusting the deep value let's you control the depth of the cave in
 * increments of 100.
 *
 * currently it is fixed as 200 until i finish the UI and path drawing.
 *
 * @author strohm
 */
public class Ui {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("How deep should we dig? (100, 200, 300... n*100)");
        int deep = 200;

        CaveMapper cMapper = new CaveMapper(deep);
        Draw d = new Draw(1920, 1200, "Cavern");

        List mainCaves = cMapper.mainCaves();
        d.drawRooms(Color.RED, mainCaves);

        List subCaves = cMapper.subCaves();
        d.drawRooms(Color.GREEN, subCaves);

        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.exit(0);
    }
}
