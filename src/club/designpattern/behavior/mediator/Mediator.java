package club.designpattern.behavior.mediator;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 9:49
 * @describe
 */
public interface Mediator {
    public void register(Colleague colleague);

    public void relay(Colleague colleague);
}
