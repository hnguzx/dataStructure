package club.test;

import club.designpattern.behavior.responsibility.ConcreteHandler1;
import club.designpattern.behavior.responsibility.ConcreteHandler2;
import club.designpattern.behavior.responsibility.Handler;
import org.junit.Test;
import sun.reflect.Reflection;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/21 14:51
 * @describe
 */
public class ResponsibilityTest {

    @Test
    public void test(){
        Handler handler1 = new ConcreteHandler1();
        Handler handler2 = new ConcreteHandler2();

        handler1.setNext(handler2);
        handler1.handleRequest("one");
        handler1.handleRequest("two");
        handler1.handleRequest("three");
    }

    @Test
    public void childClassTest(){
        // 通过自定义注解，获取所有有这个注解的类，然后遍历所有的类，将类加入链表中
        // 可查看mybatis中如何实现的
    }
}
