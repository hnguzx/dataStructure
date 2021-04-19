package club.designpattern.structural.flyweight;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 16:46
 * @describe 负责创建和管理享元角色。
 * 当客户对象请求一个享元对象时，享元工厂检査系统中是否存在符合要求的享元对象，如果存在则提供给客户；
 * 如果不存在的话，则创建一个新的享元对象。
 */
public class FlyweightFactory {
    private HashMap<String ,Flyweight> flyweightHashMap = new HashMap<String, Flyweight>();

    public Flyweight getFlyweight(String key){
        Flyweight flyweight = flyweightHashMap.get(key);
        if (!Objects.isNull(flyweight)){
            System.out.println("具体享元" + key + "已经存在，被成功获取！");
        }else{
            flyweight = new ConcreteFlyweight(key);
            flyweightHashMap.put(key, flyweight);
        }
        return flyweight;
    }
}
