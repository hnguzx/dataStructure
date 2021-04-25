package club.designpattern.behavior.strategy;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/20 10:16
 * @describe
 */
public class Context {
    private Strategy strategy;

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void strategyMethod() {
        strategy.strategyMethod();
    }
}
