package club.test.prototype;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/23 14:09
 * @describe
 */
public class ShallowClone implements Cloneable {

    public ShallowClone() {
    }

    @Override
    protected ShallowClone clone() throws CloneNotSupportedException {
        return (ShallowClone) super.clone();
    }
}
