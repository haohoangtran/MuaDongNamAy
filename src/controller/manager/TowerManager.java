package controller.manager;

import controller.Controller;
import controller.TowerController;

import java.util.Vector;

/**
 * Created by Songt on 12/18/2016.
 */
public class TowerManager extends Manager {

    public TowerManager(){
        TowerController towerController = TowerController.createTower(80, 100);
        TowerController towerController1 = TowerController.createTower(500,500);
        towerController.getModel().setRadiusFire(25);
        towerController1.getModel().setRadiusFire(50);

        controllers.add(towerController);
        controllers.add(towerController1);
        System.out.println(controllers.size());
    }
    @Override
    public void run() {
        super.run();
    }

}