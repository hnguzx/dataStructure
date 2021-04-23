package club.test.singleton;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/23 11:45
 * @describe 有限的多例模式
 */
public class Multitcm {
    private static List<Multitcm> list = new ArrayList<Multitcm>();

    private static int maxNums = 10;

    private Multitcm() {
    }

    static {
        for (int i = 0; i < maxNums; i++) {
            list.add(new Multitcm());
        }
    }

    public static Multitcm getInstance() {
        return list.get(new Random().nextInt(10));
    }
}
