package controller.manager;

import controller.Controller;
import controller.EnemyController;
import controller.TowerController;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Songt on 12/18/2016.
 */
public class EnemyManager extends Manager {

    public EnemyController chooseFire(TowerController towerController) {
        int pos = 0;
        if (controllers.size() == 0) {
            return null;
        }
        for (int i = 0; i < controllers.size(); i++) {
            int a = (controllers.get(i).getModel().getX() - towerController.getModel().getX());
            int b = (controllers.get(i).getModel().getY() - towerController.getModel().getY());

            int c = (int) Math.sqrt(a * a - b * b);

            if (c <= towerController.getModel().getRadiusFire()) {
                return (EnemyController) controllers.get(pos);
            }else
                return null;
        }
        return null;
    }

    public boolean isEmpty() {
        return controllers.size() == 0;
    }

    @Override
    public void run() {
        super.run();
        Iterator<Controller> iterator = controllers.iterator();
        while (iterator.hasNext()) {
            Controller controller = iterator.next();
            if (controller.getModel().getX() > 850) {
                iterator.remove();
            }
            if (!controller.getModel().isAlive())
                iterator.remove();
        }

    }
}
