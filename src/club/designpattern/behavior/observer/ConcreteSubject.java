package club.designpattern.behavior.observer;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/21 18:03
 * @describe
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyObserver() {
        System.out.println("通知所有的观察者");
        for (Observer observer : observers) {
            observer.response();
        }
    }
}
