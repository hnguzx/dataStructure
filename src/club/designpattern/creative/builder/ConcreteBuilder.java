package club.designpattern.creative.builder;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 15:12
 * @describe
 */
public class ConcreteBuilder extends Builder {

    @Override
    public void buildPartA() {
        computer.setPartA("构建A部分");
    }

    @Override
    public void buildPartB() {
        computer.setPartB("构建B部分");
    }

    @Override
    public void buildPartC() {
        computer.setPartC("构建c部分");
    }
}
