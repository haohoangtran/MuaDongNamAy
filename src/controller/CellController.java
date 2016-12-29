package controller;

import models.CellModel;
import models.Model;
import utils.Utils;
import views.CellView;
import views.View;

import java.awt.*;

/**
 * Created by tranh on 12/19/2016.
 */
public class CellController {
    private CellModel model;
    TowerController towerController;

    public TowerController getTowerController() {
        return towerController;
    }

    public void setTowerController(TowerController towerController) {
        this.towerController = towerController;
    }

    public CellController(CellModel model) {
        this.model = model;
    }

    public CellModel getModel() {
        return model;
    }

    public void run() {

    }

    public void drawView(Graphics g) {
        if (model.isRoad())
            g.setColor(Color.red);
        else if (model.isCanBuild())
            g.setColor(Color.green);
        else
            g.setColor(Color.red);
        g.drawRect(model.getX(), model.getY(), model.getWidth(), model.getHeight());
    }


    public void drawTower(Graphics g) {
        //view.draw(g, model);
        towerController.drawView(g);
    }

    public static CellController createCell(int x, int y) {
        return new CellController(new CellModel(x, y, 50, 50));
    }

}
