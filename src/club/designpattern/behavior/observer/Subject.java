package club.designpattern.behavior.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/21 18:03
 * @describe
 */
public abstract class Subject {
    protected List<Observer> observers = new ArrayList<Observer>();

    public void add(Observer observer) {
        observers.add(observer);
    }

    public void remove(Observer observer) {
        observers.remove(observer);
    }

    public abstract void notifyObserver();
}
