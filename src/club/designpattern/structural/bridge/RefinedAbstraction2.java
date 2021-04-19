package club.designpattern.structural.bridge;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 13:56
 * @describe
 */
public class RefinedAbstraction2 extends Abstraction {

    public RefinedAbstraction2(Implementor implementor){
        super(implementor);
    }

    @Override
    public void Operation() {
        System.out.println("第二个抽象类");
        implementor.OperationImpl();
    }
}
