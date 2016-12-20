import controller.*;
import controller.manager.BodyManager;
import controller.manager.CellManager;
import controller.manager.EnemyManager;
import controller.manager.TowerManager;
import utils.Utils;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

import static utils.Utils.loadImage;

/**
 * Created by DUC THANG on 12/17/2016.
 */
public class GameWindow extends Frame implements Runnable {
    public static int timeCount = 0;
    Image background;
    BufferedImage backBuffer;
    EnemyManager enemyManager;
    EnemyController e;
    HouseController houseController;
    TowerController t;
    TowerManager towerManager;
    Image backgroundBot;
    Image backgroundTop;
    CellManager cellManager;
    boolean check;
    CellController cellController;

    public GameWindow() {
        cellManager = new CellManager();
        enemyManager = new EnemyManager();
        towerManager = new TowerManager();
        backgroundBot = Utils.loadImage("res/backgroundBot.png");
        backgroundTop = Utils.loadImage("res/backgroundTop.jpg");

        setVisible(true);
        setResizable(false);
        setTitle("Mùa đông năm ấy - Amita Team");
        setSize(930, 900);
        // cỡ ảnh 930x690
        e = EnemyController.createEnemy();

        enemyManager.add(e);
        houseController = HouseController.createHpFull(830, 325);

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
        addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("click");

            }

            @Override
            public void mousePressed(MouseEvent e) {
                check = true;
                System.out.println("press");
                cellController = cellManager.findCell(e.getX(), e.getY());
                if (cellController != null && cellController.getModel().isCanBuild()) {
                    t = TowerController.createTower(cellController.getModel().getX(), cellController.getModel().getY());
                    t.getModel().setRadiusFire(100);
                    cellController.setTowerController(t);
                    towerManager.add(t);
                }

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                check = false;
                System.out.println("relase");

            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        });
    }


    public void update(Graphics g) {

        Graphics backBufferGraphics = backBuffer.getGraphics();
        backBufferGraphics.drawImage(backgroundTop, 0, 0, 930, 100, null);
        backBufferGraphics.drawImage(background, 0, 100, 930, 690, null);
        enemyManager.drawAnimation(backBufferGraphics);

        houseController.drawView(backBufferGraphics);
        houseController.drawAnimation(backBufferGraphics);
        towerManager.draw(backBufferGraphics);
        if (check)
            cellManager.draw(backBufferGraphics);
        g.drawImage(backBuffer, 0, 0, 930, 690, null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                this.repaint();
                Thread.sleep(17);
                timeCount++;
                if (timeCount > 15) {
                    enemyManager.add(EnemyController.createEnemy());
                    timeCount = 0;
                }
                enemyManager.run();
                towerManager.run();
                BodyManager.instance.checkContact();

                if (!houseController.isGameOn()) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
