package club.designpattern.structural.bridge;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:00
 * @describe
 */
public class ConcreteImplementor2 implements Implementor {
    @Override
    public void OperationImpl() {
        System.out.println("第二个具体实现类");
    }
}
