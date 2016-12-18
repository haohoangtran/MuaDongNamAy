package controller;

import models.Model;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by tranh on 12/17/2016.
 */
public class BodyManager {
    private Vector<Body> bodies;
    public static final BodyManager instance=new BodyManager();
    public void register(Body other){
        bodies.add(other);
    }

    public BodyManager() {

        bodies=new Vector<>();

    }

    public void checkContact() {
        System.out.println(bodies.size());
        for (int i = 0; i < bodies.size() - 1; i++) {

            for (int j = i + 1; j < bodies.size(); j++) {
                Body bodyi = bodies.get(i);
                Body bodyj = bodies.get(j);

                Model modeli = bodyi.getModel();
                Model modelj = bodyj.getModel();

                if (modeli.intersects(modelj)) {
                    bodyi.onContact(bodyj);
                    bodyj.onContact(bodyi);
                }
            }
        }
    }
    public void remove(){
        System.out.println("remove1");
        Iterator<Body> iterator = bodies.iterator();
        while (iterator.hasNext()) {
            System.out.println("remove2");
            Body body = iterator.next();
            if (!body.getModel().isAlive()) {
                iterator.remove();
                System.out.println("remove3");
            }
        }
    }
}
