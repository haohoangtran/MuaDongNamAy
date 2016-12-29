package controller.manager;

import controller.CellController;
import views.View;

import java.awt.*;
import java.util.Vector;

/**
 * Created by tranh on 12/19/2016.
 */
public class CellManager {
    Vector<CellController> cellControllers;
    private static int WIDTH=900;
    private static int HEIGHT=900;

    private int[] road = {19, 34, 49, 64, 79, 94, 95, 96, 97, 98, 99, 114, 129, 144, 159, 174, 189, 204, 203, 202, 217, 232};
    int[] build = {17, 32, 47, 62, 77, 107, 18, 33, 48, 63, 78, 93, 108, 123, 124, 110, 125, 111, 112, 128, 143, 20, 35, 50, 36, 51, 37, 52,
            21, 22, 23, 38, 53, 68, 83, 39, 54, 69, 84, 55, 70, 85, 160, 205, 220, 219, 218, 233,
            157, 172, 158, 173, 171, 200, 215, 199, 214, 109};

    public CellManager() {
        cellControllers = new Vector<>();
        int posX = 10;
        int posY = 35;
        while (posX < WIDTH) {
            cellControllers.add(CellController.createCell(posX, 35));
            posX += 60;
        }
        int size = cellControllers.size();
        System.out.println("size = " + size);
        for (int i = 0; i < size; i++) {
            while (posY < HEIGHT) {
                this.cellControllers.add(CellController.createCell(cellControllers.get(i).getModel().getX(), posY));
                posY += 60;
            }
            posY = 35;
        }
        System.out.println("cellControllers = " + cellControllers.size());
        for (int i = 0; i < road.length; i++) {
            cellControllers.get(road[i]).getModel().setRoad(true);
        }
        for (int i = 0; i < build.length; i++) {
            cellControllers.get(build[i]).getModel().setCanBuild(true);
        }
    }

    public void add(CellController c) {
        this.cellControllers.add(c);
    }

    public void remove(CellController c) {
        this.cellControllers.remove(c);
    }

    public void draw(Graphics g) {
        for (int i = 0; i < cellControllers.size(); i++) {
            cellControllers.get(i).drawView(g);
        }
    }

    public CellController findCell(int x, int y) {
        for (int i = 0; i < cellControllers.size(); i++) {
            if (x >= cellControllers.get(i).getModel().getX() && x <= cellControllers.get(i).getModel().getRight() &&
                    y <= cellControllers.get(i).getModel().getBottom() && y >= cellControllers.get(i).getModel().getY()) {
                return cellControllers.get(i);
            }
        }
        return null;
    }
}
