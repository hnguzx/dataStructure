package club.designpattern.structural.decorator;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:47
 * @describe
 */
public class ConcreteDecorator extends Decorator {
    public ConcreteDecorator(Component component) {
        super(component);
    }

    @Override
    public void operation() {
        super.operation();
        addFunction();
    }

    public void addFunction() {
        System.out.println("添加的额外功能");
    }
}
