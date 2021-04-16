package club.designpattern.structural.proxy;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/16 16:54
 * @describe
 */
public class RealSubject implements Subject {
    @Override
    public void show() {
        System.out.println("真实的实现");
    }
}
