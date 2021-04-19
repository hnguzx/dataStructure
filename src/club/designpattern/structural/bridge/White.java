package club.designpattern.structural.bridge;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:12
 * @describe
 */
public class White implements ComputerColor {
    @Override
    public void getColor() {
        System.out.println("这是一个白色电脑");
    }
}
