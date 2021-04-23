package club.test.singleton;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/23 11:41
 * @describe
 */
public class Hungry {

    private static final Hungry instance = new Hungry();

    private Hungry() {
    }

    public Hungry getInstance() {
        return instance;
    }
}
