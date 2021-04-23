package club.designpattern.creative.prototype;

import lombok.Data;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/15 14:05
 * @describe 原型模式
 */
@Data
public class Prototype implements Cloneable {

    private String name;
    private int id;

    public Prototype() {
    }

    @Override
    public Prototype clone() throws CloneNotSupportedException {
        return (Prototype) super.clone();
    }
}
