package controller;

import models.Model;
import utils.Utils;
import views.View;

import java.awt.*;

/**
 * Created by DUC THANG on 12/17/2016.
 */
public class HouseController extends Controller {
    public HouseController(Model model, View view) {
        super(model, view);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    public static HouseController create(int x, int y) {
        return new HouseController(new Model(x, y, 150, 150, false, 0, 10, 0, 0),
                new View(Utils.loadImage("res/house2.png")));
    }
}
