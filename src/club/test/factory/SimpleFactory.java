package club.test.factory;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/23 14:11
 * @describe
 */
public class SimpleFactory {

    public static Product createProduct() {
        return new Product();
    }
}
