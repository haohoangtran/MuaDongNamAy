package models;

/**
 * Created by tranh on 12/19/2016.
 */
public class CellModel {
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean isRoad;

    public boolean isRoad() {
        return isRoad;
    }

    public boolean isCanBuild() {
        return canBuild;
    }

    public void setCanBuild(boolean canBuild) {
        this.canBuild = canBuild;
    }

    private boolean canBuild;

    public void setRoad(boolean road) {
        isRoad = road;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    public int getBottom(){
        return y+height;
    }

    public CellModel(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getRight(){
        return x+width;

    }
}
