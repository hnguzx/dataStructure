package club.designpattern.structural.bridge;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:20
 * @describe
 */
public class Laptop extends Computer {

    public Laptop(ComputerBrand brand, ComputerColor color) {
        super(brand, color);
    }

    @Override
    public void computerRun() {
        brand.getName();
        color.getColor();
        System.out.println("笔记本运行了");
    }
}
