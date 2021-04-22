package club.designpattern.behavior.memento;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 14:42
 * @describe 管理者
 */
public class Caretaker {

    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
