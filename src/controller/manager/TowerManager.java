package controller.manager;

import controller.TowerController;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Songt on 12/18/2016.
 */
public class TowerManager {
    Vector<TowerController> towerControllers;

    public TowerManager() {
        towerControllers=new Vector<>();
    }
    public void draw(Graphics g){
        for (TowerController towerController : towerControllers) {
            towerController.drawView(g);
        }
    }
    public void run(){
        for (int i = 0; i < towerControllers.size(); i++) {
            towerControllers.get(i).run();
        }
    }
    public void add(TowerController t){
        this.towerControllers.add(t);
    }
    public void remove(TowerController t){
        this.towerControllers.remove(t);
    }
}