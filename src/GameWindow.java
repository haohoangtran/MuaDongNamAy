import controller.BodyManager;
import controller.EnemyController;
import controller.HouseController;
import controller.TowerController;
import controller.manager.EnemyManager;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/17/2016.
 */
public class GameWindow extends Frame implements Runnable {
    public static int timeCount=0;
    Image background;
    BufferedImage backBuffer;
    EnemyManager enemyManager;
    EnemyController e;
    HouseController houseController;
    TowerController towerController;

    public GameWindow() {
        enemyManager=new EnemyManager();
        setVisible(true);
        setResizable(false);
        setTitle("Mùa đông năm ấy - Amita Team");

        setSize(930, 690);

        towerController = TowerController.createTower(80, 100);
        towerController.getModel().setRadiusFire(25);
        e = EnemyController.createEnemy();
        enemyManager.add(e);
        houseController = HouseController.create(850, 220);

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

        backBufferGraphics.drawImage(background, 0, 0, 930, 690, null);
        enemyManager.drawAnimation(backBufferGraphics);
        houseController.drawView(backBufferGraphics);
        towerController.drawView(backBufferGraphics);

        g.drawImage(backBuffer, 0, 0, 930, 690, null);
    }

    @Override
    public void run() {
        while (true) {
            try {

                this.repaint();
                Thread.sleep(17);
                timeCount++;
                if (timeCount>60) {
                    enemyManager.add(EnemyController.createEnemy());
                    timeCount=0;
                }
                enemyManager.run();
                towerController.run();

                BodyManager.instance.checkContact();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
