package club.designpattern.creative.singleton;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 10:04
 * @describe 懒汉式单例模式
 */
public class LazySingleton {

    private static volatile LazySingleton instance = null;

    private LazySingleton() {
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
