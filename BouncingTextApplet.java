import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class BouncingTextApplet extends Applet implements Runnable {

    int x = 10;
    int y = 50;
    int dx = 2;
    Thread thread;

    public void start() {
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        while (true) {
            x += dx;
            if (x < 0 || x > getWidth() - 220) {
                dx = -dx;
            }
            repaint();
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {}
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.setFont(new Font("Serif", Font.BOLD, 24));
        g.drawString("Hello from Java Applet!", x, y);
    }
}
