package club.designpattern.structural.bridge;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 9:46
 * @describe
 */
public class ConcreteImplementor implements Implementor {
    @Override
    public void OperationImpl() {
        System.out.println("具体实现类");
    }
}
