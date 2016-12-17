package controller;

import models.CheckPoint;
import models.Model;
import utils.Utils;
import views.Animation;
import views.View;

import java.awt.*;

/**
 * Created by Khuong Duy on 12/17/2016.
 */
public class TowerController extends Controller{


    public TowerController(Model model, Animation animation) {
        super(model, animation);
    }

    public TowerController(Model model, View view) {
        super(model, view);
    }
}
