package club.designpattern.structural.proxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/23 15:25
 * @describe
 */
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("方法执行之前");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("方法执行之后");
        return o1;
    }
}
