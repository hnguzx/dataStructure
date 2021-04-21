package club.test;

import club.designpattern.behavior.observer.*;
import org.junit.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/21 18:01
 * @describe
 */
public class ObserverTest {

    @Test
    public void test(){
        Subject subject = new ConcreteSubject();
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        subject.add(observer1);
        subject.add(observer2);

        subject.notifyObserver();
    }
}
