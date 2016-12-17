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

<<<<<<< HEAD
=======
    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isFly() {
        return isFly;
    }

    public void setFly(boolean fly) {
        isFly = fly;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

>>>>>>> 9e577036bee08730db4a65fa87378df9edbccd2a
    public void move(int dx, int dy) {
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
