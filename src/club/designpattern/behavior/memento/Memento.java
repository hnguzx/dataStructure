package club.designpattern.behavior.memento;

import java.util.HashMap;
import java.util.Stack;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 14:42
 * @describe 备忘录
 */
public class Memento {
//    private String state;
    private Stack stateStack = new Stack();

    public Memento(String state) {
//        this.state = state;
        stateStack.push(state);
    }

    public String getState() {
//        return state;
        return (String) stateStack.pop();
    }

    public void setState(String state) {
//        this.state = state;
        stateStack.push(state);
    }
}
