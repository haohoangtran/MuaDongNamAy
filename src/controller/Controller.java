package controller;

import models.CheckPoint;
import models.Model;
import views.Animation;
import views.View;

import java.awt.*;

/**
 * Created by Khuong Duy on 12/17/2016.
 */
public class Controller {
    protected Model model;
    protected Animation animation;

    public Controller(Model model, Animation animation) {
        this.model = model;
        this.animation = animation;
    }

    public Model getModel() {
        return model;
    }

    public void run() {

    }

    public void draw(Graphics g) {
        animation.draw(g, model);
    }

}
