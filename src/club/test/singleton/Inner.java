package club.test.singleton;

import club.designpattern.creative.singleton.InnerSingleton;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/6/4 11:51
 * @describe
 */
public class Inner {
    public static void main(String[] args) {
        InnerSingleton instance = InnerSingleton.getInstance();
        InnerSingleton instance2 = InnerSingleton.getInstance();
        System.out.println(instance.equals(instance2));
    }
}
