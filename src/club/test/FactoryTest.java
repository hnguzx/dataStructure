package club.test;

import club.designpattern.creative.factory.*;
import org.junit.jupiter.api.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 14:33
 * @describe
 */
public class FactoryTest {

    @Test
    public void testSimpleFactory() {
        Product product = SimpleFactoryProduct.createProduct(2);
        product.show();
    }

    @Test
    public void testMethodFactory() {
        AbstractFactory factory = new ConcreteFactory1();
        Product product = factory.createProduct();
        product.show();
    }

    @Test
    public void testAbstractFactory() {
        AbstractFactory factory = new ConcreteFactory1();
        Product1 product1 = factory.createProduct1();
        Product2 product2 = factory.createProduct2();
        product1.show();
        product2.show();
    }
}
