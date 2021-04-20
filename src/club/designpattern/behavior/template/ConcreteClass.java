package club.designpattern.behavior.template;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/20 9:59
 * @describe
 */
public class ConcreteClass extends AbstractClass {
    @Override
    public boolean abstractMethod1() {
        System.out.println("可以通过这里反向控制父类的执行");
        return true;
    }

    @Override
    public void abstractMethod2() {
        System.out.println("只执行了子类的方法");
    }
}
