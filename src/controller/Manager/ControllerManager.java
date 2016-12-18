package controller.manager;

import controller.Controller;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Khuong Duy on 12/17/2016.
 */
public class ControllerManager {
    protected Vector<Controller> controllers;

    public ControllerManager() {
        controllers = new Vector<>();

    }

    public void draw(Graphics g) {
        if (controllers != null) {
            for (Controller controller : controllers) {
                controller.drawView(g);
            }
        }
    }

    public void run() {
        for (Controller controller : controllers) {
            controller.run();
        }
        Iterator<Controller> iterator = this.controllers.iterator();
        while (iterator.hasNext()) {
            Controller controller = iterator.next();
            if (controller.getModel().isAlive() == false) {
                iterator.remove();
            }
        }
    }

    public void add(Controller controller) {
        controllers.add(controller);
    }

    public void remove(Controller controller) {
        controllers.remove(controller);
    }
}
