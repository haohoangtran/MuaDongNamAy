package models;

/**
 * Created by DUC THANG on 12/17/2016.
 */
public class Model {
    private int x, y;
    private int width, height;
    private boolean isAlive = true;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    private void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
