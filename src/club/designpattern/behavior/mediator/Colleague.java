package club.designpattern.behavior.mediator;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 9:50
 * @describe
 */
public abstract class Colleague {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public abstract void receive();

    public abstract void send();
}
