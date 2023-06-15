package club.test;

import club.designpattern.structural.proxy.*;
import net.sf.cglib.proxy.Enhancer;
import org.junit.jupiter.api.Test;

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
        Subject staticProxy = new StaticProxy();
        staticProxy.show();
    }

    @Test
    public void dynamicTest() {
        RealSubject realSubject = new RealSubject();
        DynamicProxy proxy = new DynamicProxy(realSubject);
        Subject instance = proxy.getInstance();
        instance.show();

    }

    @Test
    public void cglibTest() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(RealSubject.class);
        enhancer.setCallback(new MyMethodInterceptor());
        RealSubject realSubject = (RealSubject) enhancer.create();
        realSubject.show();
    }
}
