package club.designpattern.structural.decorator;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:47
 * @describe
 */
public class ConcreteAfterDecorator1 extends Decorator {
    public ConcreteAfterDecorator1(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addFunction();
    }

    public void addFunction() {
        System.out.println("在实际调用之后添加的额外功能--1");
    }
}
