package club.test;

import club.designpattern.structural.proxy.*;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/16 16:58
 * @describe
 */
public class ProxyTest {

    @Test
    public void staticTest() {
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.show();
    }

    @Test
    public void dynamicTest() {
//        InvocationHandler handler = new DynamicProxy(new RealSubject());
//        Subject subject = (Subject) Proxy.newProxyInstance(Subject.class.getClassLoader(),new Class[]{Subject.class},handler);
//        subject.show();

        DynamicProxy proxy = new DynamicProxy();
        Subject instance = proxy.getInstance(new RealSubject());
        instance.show();

    }

    @Test
    public void cglibTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject2.class);
        enhancer.setCallback(new MyMethodInterceptor());
        RealSubject2 realSubject = (RealSubject2) enhancer.create();
        realSubject.show();
    }
}
