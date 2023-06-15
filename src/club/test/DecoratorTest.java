package club.test;

import club.designpattern.structural.decorator.*;
import org.junit.jupiter.api.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:53
 * @describe
 */
public class DecoratorTest {

    @Test
    public void test() {
        // 如果是实际方法调用前的装饰类，在外层就先调用
        // 如果是实际方法调用后的装饰类，在内层就先调用
        Component component = new ConcreteAfterDecorator2(new ConcreteBeforeDecorator1(new ConcreteAfterDecorator1(new ConcreteBeforeDecorator2(new ConcreteComponent()))));
        component.operation();
    }
}
