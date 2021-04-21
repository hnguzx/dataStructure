package club.designpattern.behavior.state;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/21 15:17
 * @describe
 */
public class Context {
    private State state;

    public Context() {
        this.state = new ConcreteStateA();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void handle() {
        state.handle(this);
    }
}
