package club.designpattern.structural.bridge;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:09
 * @describe
 */
public abstract class Computer {
    protected ComputerBrand brand;
    protected ComputerColor color;

    protected Computer(ComputerBrand brand, ComputerColor color) {
        this.brand = brand;
        this.color = color;
    }

    public abstract void computerRun();

}
