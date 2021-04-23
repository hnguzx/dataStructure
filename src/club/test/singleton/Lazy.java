package club.test.singleton;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/23 11:32
 * @describe
 */
public class Lazy {
    private static volatile Lazy instance = null;

    private Lazy() {
    }

    public static synchronized Lazy getInstance() {
        if (instance == null) {
            instance = new Lazy();
        }
        return instance;
    }
}
