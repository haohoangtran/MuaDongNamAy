package models;

/**
 * Created by DUC THANG on 12/17/2016.
 */
public class Model {
    private int x, y;
    private int width, height;
    private boolean isAlive = true;
    private boolean isFly=false;
    private int speed;
    private int hp;
    private int atk;
    private int money;

    public Model(int x, int y, int width, int height, boolean isFly, int speed, int hp, int atk, int money) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isFly = isFly;
        this.speed = speed;
        this.hp = hp;
        this.atk = atk;
        this.money = money;
    }

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
