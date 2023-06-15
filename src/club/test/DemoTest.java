package club.test;

import org.junit.jupiter.api.Test;

import java.util.Random;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 11:20
 * @describe
 */
public class DemoTest {

    @Test
    public void test() {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

    @Test
    public void mathTest() {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Random().nextInt(10));
        }
    }
}
