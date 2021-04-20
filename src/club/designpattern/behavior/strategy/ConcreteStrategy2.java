package club.designpattern.behavior.strategy;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/20 10:16
 * @describe
 */
public class ConcreteStrategy2 implements Strategy {
    @Override
    public void strategyMethod() {
        System.out.println("具体策略2被访问了");
    }
}
