package club.designpattern.creative.factory;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 14:44
 * @describe
 */
public class ConcreteFactory2 implements AbstractFactory {
    @Override
    public Product createProduct() {
        return new Product2();
    }

    @Override
    public Product1 createProduct1() {
        return new Product1();
    }

    @Override
    public Product2 createProduct2() {
        return new Product2();
    }
}
