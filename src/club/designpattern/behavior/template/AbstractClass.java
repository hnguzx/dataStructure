package club.designpattern.behavior.template;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/20 9:58
 * @describe
 */
public abstract class AbstractClass {
    public void template() {
        if (abstractMethod1()) {
            specific();
        } else {
            abstractMethod2();
        }
    }

    public void specific() {
        System.out.println("父类中的具体方法");
    }

    public abstract boolean abstractMethod1();


    public abstract void abstractMethod2();


}
