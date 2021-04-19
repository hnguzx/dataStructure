package club.designpattern.structural.bridge;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:16
 * @describe
 */
public class Mac implements ComputerBrand {
    @Override
    public void getName() {
        System.out.println("苹果电脑");
    }
}
