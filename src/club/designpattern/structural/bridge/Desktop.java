package club.designpattern.structural.bridge;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:17
 * @describe
 */
public class Desktop extends Computer {

    public Desktop(ComputerBrand brand, ComputerColor color) {
        super(brand, color);
    }

    @Override
    public void computerRun() {
        brand.getName();
        color.getColor();
        System.out.println("台式机运行了");
    }
}
