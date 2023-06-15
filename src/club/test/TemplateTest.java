package club.test;

import club.designpattern.behavior.template.AbstractClass;
import club.designpattern.behavior.template.ConcreteClass;
import org.junit.jupiter.api.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/20 10:04
 * @describe
 */
public class TemplateTest {

    @Test
    public void test() {
        AbstractClass abstractClass = new ConcreteClass();
        abstractClass.template();
    }
}
