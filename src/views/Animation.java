package views;

import controller.Controller;
import models.CheckPoint;
import models.Model;
import utils.Utils;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Hieu It on 12/17/2016.
 */
public class Animation {
    private Vector<Image> imageVector = new Vector<>();
    private int index = 0;
    private int time = 0;

    public Animation(String path) {
        String[] split = path.split(",");
        CheckPoint[] checkPoints=Utils.createCheckpoint();

        for (int i = 0; i < split.length; i++) {
            Image image = Utils.loadImage(split[i]);
            imageVector.add(image);
        }
    }

//    public void creatAnimationRight(){
//        String path = "res/Enemy/bahamut/bahamutRight1.png,res/Enemy/bahamut/bahamutRight2.png,res/Enemy/bahamut/bahamutRight3.png,res/Enemy/bahamut/bahamutRight4.png";
//        String[] split = path.split(",");
//        for (int i = 0; i < split.length; i++) {
//            Image image = Utils.loadImage(split[i]);
//            imageVector.add(image);
//        }
//    }

    public void draw(Graphics g, Model model) {
        if (imageVector != null) {
            Image image = imageVector.get(index);
            g.drawImage(image, model.getX() + 5, model.getY() - 5, 60, 60, null);
            time++;
            if (time / 10 == 1) {
                time = 0;
                index++;
                if (index == imageVector.size()) {
                    //imageVector = null;
                    index = 0;
                }
            }
        }
    }
}
