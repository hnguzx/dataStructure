package club.designpattern.creative.factory;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 14:27
 * @describe
 */
public class Product1 implements Product {

    @Override
    public String show() {
        System.out.println("product 1");
        return null;
    }
}
