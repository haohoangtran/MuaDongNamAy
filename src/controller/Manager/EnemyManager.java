package controller.Manager;

import controller.EnemyController;

import java.awt.*;
import java.util.Vector;


/**
 * Created by Khuong Duy on 12/17/2016.
 */
public class EnemyManager extends ControllerManager {

    private int count = 0;
    private int number = 0;

    public void spawn() {
        if (number == 10) {
            return;
        }
        count++;

        if (count == 30) {
            EnemyController enemyController = EnemyController.createEnemy();
            controllers.add(enemyController);
            number++;
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        spawn();
    }

    @Override
    public void run() {
        super.run();
    }
}
