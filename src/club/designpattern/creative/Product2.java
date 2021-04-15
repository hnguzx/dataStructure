package club.designpattern.creative;

import lombok.Data;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 14:27
 * @describe
 */
public class Product2 implements Product {

    @Override
    public String show() {
        System.out.println("product 2");
        return null;
    }
}
