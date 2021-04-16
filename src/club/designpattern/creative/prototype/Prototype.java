package club.designpattern.creative.prototype;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 14:05
 * @describe 原型模式
 */
public class Prototype implements Cloneable {

    public Prototype() {
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}
