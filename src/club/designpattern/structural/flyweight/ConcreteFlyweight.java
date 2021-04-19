package club.designpattern.structural.flyweight;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 16:46
 * @describe 实现抽象享元角色中所规定的接口
 */
public class ConcreteFlyweight implements Flyweight{
    private String key;

    public ConcreteFlyweight(String key){
        this.key = key;
        System.out.println("具体享元："+key+" 被创建");
    }

    @Override
    public void operation(UnsharableFlyweight unsharableFlyweight) {
        System.out.print("具体享元" + key + "被调用，");
        System.out.println("非享元信息是:" + unsharableFlyweight.getInfo());
    }
}
