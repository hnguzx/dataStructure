package club.test;

import club.designpattern.structural.adapter.*;
import org.junit.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/16 18:22
 * @describe
 */
public class AdapterTest {

    @Test
    public void classTest(){
        Target target = new ClassAdapter();
        target.newMethod();
    }

    @Test
    public void objectTest(){
        Target target = new ObjectAdapter(new Adaptee());
        target.newMethod();
    }

    @Test
    public void twoTest(){
        TwoAdapter adapter1 = new TwoAdapter(new TargetImplement());
        adapter1.oldMethod();

        TwoAdapter adapter2 = new TwoAdapter(new Adaptee());
        adapter2.newMethod();
    }
}
