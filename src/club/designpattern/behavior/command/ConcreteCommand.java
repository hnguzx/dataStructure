package club.designpattern.behavior.command;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/20 16:09
 * @describe
 */
public class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand() {
        receiver = new Receiver();
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
