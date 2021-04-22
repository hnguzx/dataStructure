package club.designpattern.behavior.mediator;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 10:26
 * @describe
 */
public class SimpleConcreteColleague1 implements SimpleColleague {

    public SimpleConcreteColleague1() {
        SimpleMediator simpleMediator = SimpleMediator.getSimpleMediator();
        simpleMediator.register(this);
    }

    @Override
    public void receive() {
        System.out.println("具体简单同事1收到请求");
    }

    @Override
    public void send() {
        SimpleMediator simpleMediator = SimpleMediator.getSimpleMediator();
        System.out.println("具体简单同事1发出请求");
        simpleMediator.relay(this);
    }
}
