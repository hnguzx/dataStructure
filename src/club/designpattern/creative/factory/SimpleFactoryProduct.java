package club.designpattern.creative.factory;

import club.designpattern.creative.factory.Product;
import club.designpattern.creative.factory.Product1;
import club.designpattern.creative.factory.Product2;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 14:26
 * @describe 简单工厂模式
 */
public class SimpleFactoryProduct {

    public static Product createProduct(Integer productType) {
        switch (productType) {
            case 1:
                return new Product1();
            case 2:
                return new Product2();
            default:
                return null;
        }
    }
}
