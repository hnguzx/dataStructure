package club.designpattern.structural.bridge;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:15
 * @describe
 */
public class Asus implements ComputerBrand {
    @Override
    public void getName() {
        System.out.println("华硕电脑");
    }
}
