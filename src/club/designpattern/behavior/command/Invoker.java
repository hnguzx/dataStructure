package club.designpattern.behavior.command;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/20 16:09
 * @describe
 */
public class Invoker {

    private Command command;

    public Invoker(Command command) {
        this.command = command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void call() {
        System.out.println("调用者执行command");
        command.execute();
    }
}
