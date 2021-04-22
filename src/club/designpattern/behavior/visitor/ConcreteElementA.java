package club.designpattern.behavior.visitor;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 11:36
 * @describe
 */
public class ConcreteElementA implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    public void operationA() {
        System.out.println("元素A的具体操作");
    }
}
