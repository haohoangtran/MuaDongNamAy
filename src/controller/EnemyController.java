package controller;

import models.CheckPoint;
import models.Model;
import utils.Utils;
import views.View;

import java.awt.*;
import java.util.List;

/**
 * Created by Khuong Duy on 12/17/2016.
 */
public class EnemyController extends Controller{


    public EnemyController(Model model, View view) {
        super(model, view);
    }


    public void run() {
            CheckPoint[] checkPoints= Utils.createCheckpoint();
            if (this.getModel().getX()<checkPoints[1].getX()&&this.model.getY()<checkPoints[2].getY()){
                this.getModel().move(2,0);
                System.out.println("vào 1");
            }else if (this.getModel().getY()<checkPoints[2].getY()&&this.model.getX()<checkPoints[3].getX()){
                this.model.move(0,2);
                System.out.println("vào 2");

            }else if (this.getModel().getX()<checkPoints[3].getX()){
                this.getModel().move(2,0);
                System.out.println("vào 3");

            }else if (this.getModel().getY()>checkPoints[4].getY()&&this.getModel().getX()>checkPoints[3].getX()){
                this.getModel().move(0,-2);
                System.out.println("vào 4");
            }else {
                this.model.move(2,0);
            }
    }
    public static EnemyController createEnemy(){
        CheckPoint[] checkPoints=Utils.createCheckpoint();
        EnemyController enemyController = new EnemyController(new Model(checkPoints[0].getX(),
                checkPoints[0].getY(),33,48,false,5,2,1,10 ), new View(Utils.loadImage("res/shiva-demo.jpg")));
        return enemyController;
    }

}
