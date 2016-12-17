package controller;

import models.CheckPoint;
import models.Model;
import views.View;

import java.awt.*;

/**
 * Created by Khuong Duy on 12/17/2016.
 */
public class Controller {
    protected Model model;
    protected View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public Model getModel() {
        return model;
    }

    public void run() {

    }

    public void draw(Graphics g) {
        view.draw(g, model);
    }

}
