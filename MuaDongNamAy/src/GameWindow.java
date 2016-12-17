import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/17/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    BufferedImage backBuffer;

    GameWindow() {
        setVisible(true);
        setResizable(false);
        setSize(620, 460);
        backBuffer = new BufferedImage(620, 460, BufferedImage.TYPE_3BYTE_BGR);
        background = loadImage("res/Map1.png");
        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }


    public void update(Graphics g) {
        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(background,0, 0, 620, 460, null);
        g.drawImage(backBuffer, 0, 0, 620, 460, null);
    }

    @Override
    public void run() {
        while(true) {
            this.repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
