package club.test;

import club.designpattern.behavior.command.Command;
import club.designpattern.behavior.command.ConcreteCommand;
import club.designpattern.behavior.command.Invoker;
import org.junit.jupiter.api.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/21 11:51
 * @describe
 */
public class CommandTest {

    @Test
    public void test() {
        Command command = new ConcreteCommand();
        Invoker invoker = new Invoker(command);
        invoker.call();
    }
}
