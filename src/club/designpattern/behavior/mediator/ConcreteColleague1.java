package club.designpattern.behavior.mediator;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 9:50
 * @describe
 */
public class ConcreteColleague1 extends Colleague {
    @Override
    public void receive() {
        System.out.println("具体同事1收到请求");
    }

    @Override
    public void send() {
        System.out.println("具体同事1发出请求");
        mediator.relay(this);
    }
}
