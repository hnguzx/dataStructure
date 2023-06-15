package club.test;

import club.designpattern.behavior.visitor.*;
import org.junit.jupiter.api.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 14:20
 * @describe
 */
public class VisitorTest {

    @Test
    public void test(){
        ObjectStructure objectStructure = new ObjectStructure();

        Element elementA = new ConcreteElementA();
        Element elementB = new ConcreteElementB();

        objectStructure.add(elementA);
        objectStructure.add(elementB);

        Visitor visitorA = new ConcreteVisitorA();
        objectStructure.accept(visitorA);

//        Visitor visitorB = new ConcreteVisitorB();
//        objectStructure.accept(visitorB);



    }
}
