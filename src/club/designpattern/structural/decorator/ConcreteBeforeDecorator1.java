package club.designpattern.structural.decorator;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:47
 * @describe
 */
public class ConcreteBeforeDecorator1 extends Decorator {
    public ConcreteBeforeDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        addFunction();
        super.operation();
    }

    public void addFunction() {
        System.out.println("在实际调用之前添加的额外功能--1");
    }
}
