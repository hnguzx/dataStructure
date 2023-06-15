package club.test;

import club.designpattern.behavior.iterator.Aggregate;
import club.designpattern.behavior.iterator.ConcreteAggregate;
import club.designpattern.behavior.iterator.Iterator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 11:14
 * @describe
 */
public class IteratorTest {

    @Test
    public void test(){
        Aggregate aggregate = new ConcreteAggregate();
        aggregate.add("湖南");
        aggregate.add("广东");
        aggregate.add("湖北");
        Iterator iterator = aggregate.getIterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o.toString());
        }
        System.out.println(iterator.first().toString());
    }
}
