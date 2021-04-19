package club.designpattern.structural.flyweight;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 16:46
 * @describe 所有的具体享元类的基类，为具体享元规范需要实现的公共接口，非享元的外部状态以参数的形式通过方法传入。
 */
public interface Flyweight {

    public void operation(UnsharableFlyweight unsharableFlyweight);
}
