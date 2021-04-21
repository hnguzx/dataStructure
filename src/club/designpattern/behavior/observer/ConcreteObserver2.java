package club.designpattern.behavior.observer;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/21 18:03
 * @describe
 */
public class ConcreteObserver2 implements Observer {
    @Override
    public void response() {
        System.out.println("观察者二号收到通知，进行处理");
    }
}
