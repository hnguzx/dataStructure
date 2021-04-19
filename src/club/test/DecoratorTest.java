package club.test;

import club.designpattern.structural.decorator.Component;
import club.designpattern.structural.decorator.ConcreteComponent;
import club.designpattern.structural.decorator.ConcreteDecorator;
import org.junit.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:53
 * @describe
 */
public class DecoratorTest {

    @Test
    public void test(){

        Component component1 = new ConcreteComponent();
        component1.operation();

        Component component2 = new ConcreteDecorator(component1);
        component2.operation();
    }
}
