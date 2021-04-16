package club.test;

import club.designpattern.creative.builder.Builder;
import club.designpattern.creative.builder.Computer;
import club.designpattern.creative.builder.ConcreteBuilder;
import club.designpattern.creative.builder.Director;
import org.junit.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 15:32
 * @describe
 */
public class BuilderTest {

    @Test
    public void test(){
        Builder concreteBuilder = new ConcreteBuilder();
        Director director = new Director(concreteBuilder);
        Computer computer = director.construct();
        computer.show();
    }
}
