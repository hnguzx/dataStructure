package club.test;

import club.designpattern.creative.singleton.HungrySingleton;
import club.designpattern.creative.singleton.LazySingleton;
import org.junit.Test;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 11:06
 * @describe
 */
public class SingletonTest {

    @Test
    public void test(){
        LazySingleton lazySingleton = LazySingleton.getInstance();
        System.out.println(lazySingleton);
        System.out.println(lazySingleton);

        HungrySingleton hungrySingleton = HungrySingleton.getInstance();
        System.out.println(hungrySingleton);
        System.out.println(hungrySingleton);
    }
}
