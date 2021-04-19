package club.designpattern.structural.bridge;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:13
 * @describe
 */
public class Red implements ComputerColor {
    @Override
    public void getColor() {
        System.out.println("这是一个红色电脑");
    }
}
