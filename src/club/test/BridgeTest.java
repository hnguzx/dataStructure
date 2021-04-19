package club.test;

import club.designpattern.structural.bridge.*;
import org.junit.Test;

import javax.swing.*;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 9:53
 * @describe 桥接模式，可以用电脑来做示例，
 * 抽象类为电脑，实现类有联想电脑，小米电脑，苹果电脑，
 * 区分笔记本和台式以及一体机，
 * 区分颜色有白色，黑色，红色。
 */
public class BridgeTest {

    @Test
    public void test() {
        Implementor implementor1 = new ConcreteImplementor();
        Abstraction abstraction1 = new RefinedAbstraction(implementor1);

        Implementor implementor2 = new ConcreteImplementor2();
        Abstraction abstraction2 = new RefinedAbstraction2(implementor2);

        abstraction1.Operation();
        abstraction2.Operation();

    }

    @Test
    public void customTest(){
        ComputerColor computerColor = new White();
        ComputerBrand computerBrand = new XiaoMi();
        Computer computer = new Desktop(computerBrand,computerColor);
        computer.computerRun();

        Computer computer1 = new Laptop(computerBrand,computerColor);
        computer1.computerRun();
    }
}
