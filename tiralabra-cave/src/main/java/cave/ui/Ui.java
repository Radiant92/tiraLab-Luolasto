package cave.ui;

import cave.domain.*;
import java.util.*;

/**
 * The Ui class will provide options on how the caverns will be created. For now
 * the ui automatically creates a list of sleeves which contain rooms and then
 * calls the Draw class to draw a crude visual of their placement. The Ui
 * chooses the rooms randomly and later the number of rooms can be fixed.
 *
 * @author strohm
 */
public class Ui {

    public static void main(String[] args) {
        List sleeves = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            if (random.nextInt(15) % 5 == 0) {
                sleeves.add(new Sleeve(i));
            }
        }
        Draw d = new Draw(600, 600, "Cavern", sleeves);
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            System.out.println(e);
        }
        System.exit(0);
    }
}
