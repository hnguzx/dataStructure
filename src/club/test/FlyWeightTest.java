package club.test;

import club.designpattern.structural.flyweight.Flyweight;
import club.designpattern.structural.flyweight.FlyweightFactory;
import club.designpattern.structural.flyweight.UnsharableFlyweight;
import org.junit.jupiter.api.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 17:08
 * @describe
 */
public class FlyWeightTest {

    @Test
    public void test(){
        FlyweightFactory flyweightFactory = new FlyweightFactory();

        Flyweight flyweight1 = flyweightFactory.getFlyweight("a");
        Flyweight flyweight2 = flyweightFactory.getFlyweight("a");
        Flyweight flyweight3 = flyweightFactory.getFlyweight("a");
        Flyweight flyweight4 = flyweightFactory.getFlyweight("b");
        Flyweight flyweight5 = flyweightFactory.getFlyweight("b");
        Flyweight flyweight6 = flyweightFactory.getFlyweight("b");

        flyweight1.operation(new UnsharableFlyweight("第一次调用a"));
        flyweight1.operation(new UnsharableFlyweight("第二次调用a"));
    }
}
