package club.designpattern.behavior.memento;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 14:41
 * @describe 发起人
 */
public class Originator {
    private String state;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Memento createMemento() {
        return new Memento(state);
    }

    public void restoreMemento(Memento memento) {
        this.setState(memento.getState());
    }
}
