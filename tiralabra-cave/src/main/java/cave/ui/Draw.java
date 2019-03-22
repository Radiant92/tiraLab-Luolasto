
package cave.ui;

import cave.domain.Room;
import cave.domain.Sleeve;
import java.awt.BorderLayout;
import java.util.*;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

/**
 * The class Draw is an early visual concept of the cave complex.
 * By the end of the project it will provide tools for the Ui and draw caverns.
 * For now it shows all rooms in red.
 * @author strohm
 */
public class Draw extends JFrame {

    private final JFrame window = new JFrame();
    private List<Sleeve> sleeves;
    private Graphics graphics;

    public Draw(int x, int y, String name, List sleeves) {

        this.sleeves = sleeves;

        window.setSize(x, y);
        window.setResizable(false);
        window.setFocusable(true);
        window.setVisible(true);
        window.setTitle(name);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);
        
        this.graphics = window.getGraphics();

        drawRooms();

    }

    public void drawRooms() {

        sleeves.forEach(sleeve -> drawRoom(sleeve));
    }

    public void drawRoom(Sleeve sleeve) {
        graphics.setColor(Color.RED);
        Room r = sleeve.getRoom();
        int x = r.getX() + 300;
        int y = r.getY() + 300;
        int size = r.getSize();
        graphics.fillRect(x, y, size, size);
        try {
            Thread.sleep(5);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
