package controller;

import models.CheckPoint;
import models.Model;
import utils.Utils;
import views.Animation;
import views.View;

import java.awt.*;
import java.util.List;

/**
 * Created by Khuong Duy on 12/17/2016.
 */
public class EnemyController extends Controller{


    public EnemyController(Model model, Animation animation) {
        super(model, animation);
    }

    public static final Animation rightAnimation = new Animation("res/Enemy/bahamut/bahamutRight1.png,res/Enemy/bahamut/bahamutRight2.png,res/Enemy/bahamut/bahamutRight3.png,res/Enemy/bahamut/bahamutRight4.png");
    public static final Animation downAnimation = new Animation("res/Enemy/bahamut/bahamutDown1.png,res/Enemy/bahamut/bahamutDown2.png,res/Enemy/bahamut/bahamutDown3.png,res/Enemy/bahamut/bahamutDown4.png");
    public static final Animation upAnimation = new Animation("res/Enemy/bahamut/bahamutUp1.png,res/Enemy/bahamut/bahamutUp2.png,res/Enemy/bahamut/bahamutUp3.png,res/Enemy/bahamut/bahamutUp4.png");



    public void run() {
            CheckPoint[] checkPoints= Utils.createCheckpoint();
            if (this.getModel().getX()<checkPoints[1].getX()&&this.model.getY()<checkPoints[2].getY()){
                this.getModel().move(2,0);
                System.out.println("vào 1");
            }else if (this.getModel().getY()<checkPoints[2].getY()&&this.model.getX()<checkPoints[3].getX()){
                this.model.move(0,2);
                this.animation = downAnimation;
                System.out.println("vào 2");

            }else if (this.getModel().getX()<checkPoints[3].getX()){
                this.getModel().move(2,0);
                this.animation = rightAnimation;
                System.out.println("vào 3");

            }else if (this.getModel().getY()>checkPoints[4].getY()&&this.getModel().getX()>checkPoints[3].getX()){
                this.getModel().move(0,-2);
                this.animation = upAnimation;
                System.out.println("vào 4");
            }else {
                this.model.move(2,0);
                this.animation = rightAnimation;
            }
    }
    public static EnemyController createEnemy(){
        CheckPoint[] checkPoints=Utils.createCheckpoint();
        EnemyController enemyController = new EnemyController(new Model(checkPoints[0].getX(),
                checkPoints[0].getY(),33,48,false,5,2,1,10 ),
                new Animation("res/Enemy/bahamut/bahamutRight1.png,res/Enemy/bahamut/bahamutRight2.png,res/Enemy/bahamut/bahamutRight3.png,res/Enemy/bahamut/bahamutRight4.png"));
        return enemyController;
    }

}
