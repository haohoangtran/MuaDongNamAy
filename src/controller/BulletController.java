package controller;

import models.Model;
import utils.Utils;
import views.View;

/**
 * Created by Khuong Duy on 12/17/2016.
 */
public class BulletController extends Controller{
    public static final int WIDTH =30;
    public static final int HEIGHT =30;


    public BulletController(Model model, View view) {
        super(model, view);
    }

    @Override
    public void run() {

    }

    public static BulletController createBullet(int x, int y){
        BulletController bulletController = new BulletController(new Model(x,y,WIDTH,HEIGHT,5, 5 ),new View(Utils.loadImage("")));
        return bulletController;
    }
}
