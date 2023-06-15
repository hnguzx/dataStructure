package club.test;

import club.designpattern.creative.prototype.Prototype;
import org.junit.jupiter.api.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 14:09
 * @describe
 */
public class PrototypeTest {

    @Test
    public void test() throws CloneNotSupportedException {
        Prototype prototype = new Prototype();
        prototype.setId(1);
        prototype.setName("guzhixiong");
        System.out.println(prototype.toString());

        Prototype prototype1 = prototype.clone();
        prototype1.setId(2);
        prototype1.setName("lianghong");
        System.out.println(prototype.toString());
        System.out.println(prototype1.toString());
    }
}
