package club.designpattern.behavior.memento;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 14:42
 * @describe 备忘录
 */
public class Memento {
    private String state;

    public Memento(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
