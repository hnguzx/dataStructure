package club.designpattern.structural.flyweight;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 16:46
 * @describe 不可以共享的外部状态，它以参数的形式注入具体享元的相关方法中。
 */
public class UnsharableFlyweight {

    private String info;

    public UnsharableFlyweight(String info){
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
