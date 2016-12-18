import controller.BodyManager;
import controller.EnemyController;
import controller.HouseController;
import controller.Manager.EnemyManager;
import controller.TowerController;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/17/2016.
 */
public class GameWindow extends Frame implements Runnable {
    Image background;
    BufferedImage backBuffer;
    EnemyManager enemyManager;
    HouseController houseController;
    TowerController towerController;

    public GameWindow() {
        setVisible(true);
        setResizable(false);
        towerController = TowerController.createTower(80, 100);
        enemyManager = new EnemyManager();
        setSize(930, 690);
        backBuffer = new BufferedImage(930, 690, BufferedImage.TYPE_3BYTE_BGR);
        background = loadImage("res/Map1.png");
        houseController = HouseController.create(850, 220);
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
        backBufferGraphics.drawImage(background, 0, 0, 930, 690, null);
        enemyManager.draw(backBufferGraphics);
        houseController.drawView(backBufferGraphics);
        towerController.drawView(backBufferGraphics);
        g.drawImage(backBuffer, 0, 0, 930, 690, null);
    }

    @Override
    public void run() {
        while (true) {
            this.repaint();
            try {
                Thread.sleep(17);
                enemyManager.run();
                towerController.run();
                BodyManager.instance.checkContact();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
