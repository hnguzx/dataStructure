package club.test;

import club.designpattern.structural.facade.Facade;
import org.junit.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 16:09
 * @describe
 */
public class FacadeTest {

    @Test
    public void test(){
        Facade facade = new Facade();
        facade.allFunction();
    }
}
