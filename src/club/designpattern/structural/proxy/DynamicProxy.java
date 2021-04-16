package club.designpattern.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/16 17:07
 * @describe
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public DynamicProxy(){}

    public DynamicProxy(Object o){
        this.target = o;
    }

    public Subject getInstance(Subject subject){
        this.target = subject;
        Class<?> clazz = target.getClass();
        return (Subject) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理");
        method.invoke(target,args);
        return null;
    }
}
