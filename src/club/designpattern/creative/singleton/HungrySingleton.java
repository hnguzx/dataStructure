package club.designpattern.creative.singleton;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 11:03
 * @describe
 */
public class HungrySingleton {
    private static HungrySingleton instance = new HungrySingleton();

    private HungrySingleton() {
    }

    public static HungrySingleton getInstance() {
        return instance;
    }
}
