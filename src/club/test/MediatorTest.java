package club.test;

import club.designpattern.behavior.mediator.*;
import org.junit.jupiter.api.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 10:04
 * @describe
 */
public class MediatorTest {

    @Test
    public void test() {
        Mediator mediator = new ConcreteMediator();

        Colleague colleague1 = new ConcreteColleague1();
        Colleague colleague2 = new ConcreteColleague2();

        mediator.register(colleague1);
        mediator.register(colleague2);

        colleague1.send();
    }

    @Test
    public void simpleTest() {
        SimpleColleague colleague1 = new SimpleConcreteColleague1();
        SimpleColleague colleague2 = new SimpleConcreteColleague2();

        colleague1.send();
    }


}
