package cave.ui;

import cave.domain.Room;
import cave.domain.Sleeve;
import java.util.*;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

/**
 * The class Draw is an early visual concept of the cave complex. By the end of
 * the project it will provide tools for the Ui and draw caverns. For now it
 * shows all rooms in red, and sub-rooms in yellow.
 *
 * @author strohm
 */
public class Draw extends JFrame {

    private final JFrame window = new JFrame();
    private Graphics graphics;

    public Draw(int x, int y, String name) {

        window.setSize(x, y);
        window.setResizable(false);
        window.setFocusable(true);
        window.setVisible(true);
        window.setTitle(name);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLocationRelativeTo(null);

        this.graphics = window.getGraphics();
    }

    public void drawRooms(Color color, List<Sleeve> sleeves) {
        graphics.setColor(color);
        sleeves.forEach(sleeve -> drawRoom(sleeve));
    }

    public void drawRoom(Sleeve sleeve) {

        Room r = sleeve.getRoom();
        int x = r.getX() * 5 + 500;
        int y = r.getY() * 8;
        int size = r.getSize();
        graphics.fillRect(x, y, size * 2, size * 2);
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
