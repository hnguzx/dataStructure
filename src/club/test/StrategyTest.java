package club.test;

import club.designpattern.behavior.strategy.ConcreteStrategy1;
import club.designpattern.behavior.strategy.ConcreteStrategy2;
import club.designpattern.behavior.strategy.Context;
import club.designpattern.behavior.strategy.Strategy;
import org.junit.jupiter.api.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/20 10:55
 * @describe
 */
public class StrategyTest {

    @Test
    public void test(){
        Context context = new Context();
        Strategy strategy1 = new ConcreteStrategy1();
        Strategy strategy2 = new ConcreteStrategy2();

        context.setStrategy(strategy1);
        context.strategyMethod();

        context.setStrategy(strategy2);
        context.strategyMethod();
    }
}
