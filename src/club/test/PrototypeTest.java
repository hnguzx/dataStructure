package club.test;

import club.designpattern.creative.prototype.Prototype;
import org.junit.Test;

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
        Prototype prototype1 = prototype.clone();
        System.out.println(prototype);
        System.out.println(prototype1);
    }
}
