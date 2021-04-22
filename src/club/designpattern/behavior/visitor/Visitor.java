package club.designpattern.behavior.visitor;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 11:36
 * @describe 访问者接口
 */
public interface Visitor {
    public void visit(ConcreteElementA elementA);

    public void visit(ConcreteElementB elementB);
}
