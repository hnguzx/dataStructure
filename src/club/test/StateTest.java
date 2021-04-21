package club.test;

import club.designpattern.behavior.state.ConcreteStateA;
import club.designpattern.behavior.state.ConcreteStateB;
import club.designpattern.behavior.state.Context;
import club.designpattern.behavior.state.State;
import org.junit.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/21 17:17
 * @describe
 */
public class StateTest {

    @Test
    public void test(){
        Context context = new Context();
        State stateA = new ConcreteStateA();
        State stateB = new ConcreteStateB();

        context.setState(stateA);
        context.handle();

        stateA.handle(context);
    }
}
