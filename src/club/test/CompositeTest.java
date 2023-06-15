package club.test;

import club.designpattern.structural.composite.*;
import org.junit.jupiter.api.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 18:07
 * @describe
 */
public class CompositeTest {

    @Test
    public void test(){
        Component component1 = new Leaf("叶子1");
        Component component2 = new Leaf("叶子2");
        component1.operation();
        Component component3 = new Composite();
        component3.add(component1);
        component3.add(component2);
        component3.operation();
    }

    @Test
    public void safeTest(){
        ComponentSafe component1 = new LeafSafe("叶子1");
        component1.operation();

        CompositeSafe component = new CompositeSafe();
        component.add(component1);
        component.operation();
    }
}
