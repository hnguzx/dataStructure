package club.designpattern.structural.bridge;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 9:45
 * @describe
 */
public abstract class Abstraction {
    protected Implementor implementor;

    public Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    public abstract void Operation();
}
