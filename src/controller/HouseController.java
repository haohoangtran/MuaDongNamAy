package controller;

import models.Model;
import utils.Utils;
import views.View;

import java.awt.*;

/**
 * Created by DUC THANG on 12/17/2016.
 */
public class HouseController extends Controller implements Body{
    public HouseController(Model model, View view) {
        super(model, view);
    }

    @Override
    public void drawView(Graphics g) {
        super.drawView(g);
    }

    public static HouseController create(int x, int y) {
        return new HouseController(new Model(x, y-20, 150, 150, false, 0, 10, 0, 0),
                new View(Utils.loadImage("res/house2.png")));
    }

    @Override
    public void onContact(Body other) {

    }
}
