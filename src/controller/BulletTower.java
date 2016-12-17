package controller;

import models.Model;
import utils.Utils;
import views.View;

/**
 * Created by tranh on 12/17/2016.
 */
public class BulletTower extends Controller implements Body {
    public BulletTower(Model model, View view) {
        super(model, view);
        BodyManager.instance.register(this);
    }
    public static int numberRun=6;

    @Override
    public void run() {
       for (EnemyController enemyController : Utils.enemyControllers) {
            int xE=enemyController.getModel().getX()+enemyController.model.getWidth()/2;
            int yE=enemyController.getModel().getY()+enemyController.model.getHeight()/2;
            int x=Math.abs(xE-this.model.getX());
            int y=Math.abs(yE-this.model.getY());
            this.model.move(x/numberRun,y/numberRun);
        }
    }
    public static BulletTower createBullet(int x,int y){
        return new BulletTower(new Model(x,y,12,12,7,1),new View(Utils.loadImage("res/bullet.png")));
    }

    @Override
    public void onContact(Body other) {
        if (other instanceof EnemyController){
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaa");
            model.setAlive(false);
        }
    }
}
