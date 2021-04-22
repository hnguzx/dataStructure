package club.test;

import club.designpattern.behavior.memento.Caretaker;
import club.designpattern.behavior.memento.Originator;
import org.junit.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 14:46
 * @describe
 */
public class MementoTest {

    @Test
    public void test(){
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        // 设置发起人的状态
        originator.setState("状态1");
        System.out.println("初始状态"+originator.getState());
        // 1,将状态保存到备忘录中
        // 2,将备忘录保存到管理者中
        caretaker.setMemento(originator.createMemento());

        // 修改发起人的状态
        originator.setState("状态2");
        System.out.println("修改后状态"+originator.getState());

        // 修改发起人的状态
        originator.setState("状态3");
        System.out.println("修改后状态"+originator.getState());

        // 1,从管理者中取出备忘录
        // 2,将发起人的状态恢复为备忘录中的状态
        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复后状态"+originator.getState());

        originator.restoreMemento(caretaker.getMemento());
        System.out.println("恢复后状态"+originator.getState());

    }
}
