package club.designpattern.creative.singleton;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/6/4 11:48
 * @describe
 */
public class InnerSingleton {

    private InnerSingleton() {
    }

    private static class Singleton {
        private static InnerSingleton singleton = new InnerSingleton();
    }

    public static InnerSingleton getInstance() {
        return Singleton.singleton;
    }
}
