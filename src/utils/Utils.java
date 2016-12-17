package utils;

import models.CheckPoint;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by DUC THANG on 12/17/2016.
 */
public class Utils {
    public static Image loadImage(String url) {
        try {
            Image image = ImageIO.read(new File(url));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static CheckPoint[] createCheckpoint(){
        CheckPoint[] checkPoints=new CheckPoint[6];
        checkPoints[0]=new CheckPoint(8,180);
        checkPoints[1]=new CheckPoint(322,195);
        checkPoints[2]=new CheckPoint(330,482);
        checkPoints[3]=new CheckPoint(720,502);
        checkPoints[4]=new CheckPoint(735,325);
        checkPoints[5]=new CheckPoint(907,345);
        return checkPoints;
    }
}
