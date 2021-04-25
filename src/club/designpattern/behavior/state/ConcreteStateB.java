package club.designpattern.behavior.state;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/21 15:17
 * @describe
 */
public class ConcreteStateB extends State {
    @Override
    public void handle(Context context) {
        System.out.println("当前是状态B");
        System.out.println("这是B状态时执行的程序");
        System.out.println("B状态执行后将状态转化为A状态");
        context.setState(new ConcreteStateA());
    }
}
