package controller;

import models.CheckPoint;
import models.Model;
import utils.Utils;
import views.Animation;
import views.View;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Khuong Duy on 12/17/2016.
 */
public class TowerController extends Controller {
    private Vector<BulletTower> bulletTowers;
    private static int timeCount = 0;

    public TowerController(Model model, Animation animation) {
        super(model, animation);
        bulletTowers = new Vector<>();
    }

    public TowerController(Model model, View view) {
        super(model, view);

        bulletTowers = new Vector<>();
    }

    public int sell() {
        this.model.setAlive(false);
        return (int) (this.model.getMoney() * 0.6);
    }

    @Override
    public void run() {
        timeCount++;
        if (timeCount > 30) {
            shoot();
            timeCount = 0;
        }
        Iterator<BulletTower> iterator=bulletTowers.iterator();
        for (BulletTower bulletTower : bulletTowers) {
            bulletTower.run();
        }
        while (iterator.hasNext()){
            BulletTower bulletTower=iterator.next();
            if (!bulletTower.model.isAlive()){
                iterator.remove();
            }
        }

    }

    private void shoot() {
        bulletTowers.add(BulletTower.createBullet(this.model.getMidX(), this.model.getY()));
    }

    public static TowerController createTower(int x, int y) {
        return new TowerController(new Model(x, y, 45, 50, 0, 1), new View(Utils.loadImage("res/PNG/Towers (grey)/tower_00.png")));
    }

    @Override
    public void drawView(Graphics g) {
        super.drawView(g);
        for (BulletTower bulletTower : bulletTowers) {
            if (bulletTower.model.isAlive()) {
                bulletTower.drawView(g);
            }
        }
    }
}
