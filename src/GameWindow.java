import controller.EnemyController;

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
    EnemyController enemyController;

    GameWindow() {
        setVisible(true);
        setResizable(false);

        enemyController=EnemyController.createEnemy();
        setSize(930, 690);
        backBuffer = new BufferedImage(930, 690, BufferedImage.TYPE_3BYTE_BGR);
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
        backBufferGraphics.drawImage(background,0, 0, 930, 690, null);
        enemyController.draw(backBufferGraphics);
        backBufferGraphics.drawString("a",330,502);
        g.drawImage(backBuffer, 0, 0, 930, 690, null);
    }

    @Override
    public void run() {
        while(true) {
            try {

                this.repaint();
                Thread.sleep(17);
                enemyController.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
