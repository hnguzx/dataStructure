package club.designpattern.behavior.visitor;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 11:36
 * @describe
 */
public class ConcreteVisitorB implements Visitor {
    @Override
    public void visit(ConcreteElementA elementA) {
        System.out.println("具体访问者B访问A元素");
        elementA.operationA();
    }

    @Override
    public void visit(ConcreteElementB elementB) {
        System.out.println("具体访问者B访问B元素");
        elementB.operationB();
    }
}
