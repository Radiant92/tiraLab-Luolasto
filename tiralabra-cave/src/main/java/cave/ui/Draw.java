package cave.ui;

import cave.domain.Room;
import cave.domain.Sleeve;
import cave.util.MyList;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;

/**
 * The class Draw is an early visual concept of the cave complex. By the end of
 * the project it will provide tools for the user interface and draw caverns.
 * For now it shows all rooms in red, and sub-rooms in yellow.
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

    public void drawRooms(Color color, MyList<Sleeve> sleeves) {
        graphics.setColor(color);
        for (int i = 0; i < sleeves.size(); i++) {
            drawRoom(sleeves.getSleeve(i));
        }

    }

    public void drawRoom(Sleeve sleeve) {

        Room r = sleeve.getRoom();
        int x = r.getX() * 5 + 500;
        int y = r.getY() * 8;

        int size = r.getSize();
        r.setMiddleX(x + size);
        r.setMiddleY(y + size);
        size *= 2;
        graphics.fillRect(x, y, size, size);
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void drawPaths(MyList<Sleeve> sleeves, Color color) {
        graphics.setColor(color);
        for (int i = 0; i < sleeves.size() - 1; i++) {
            Room r1 = sleeves.getSleeve(i).getRoom();
            MyList<Room> app = r1.getAppendages();
            for (int a = 0; a < app.size(); a++) {
                Room r2 = app.getRoom(a);
                graphics.drawLine(r1.getMiddleX(), r1.getMiddleY(), r2.getMiddleX(), r2.getMiddleY());
            }
        }
    }
}
