package club.designpattern.structural.adapter;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/16 18:41
 * @describe
 */
public class TargetImplement implements Target {
    @Override
    public void newMethod() {
        System.out.println("新的方法");
    }
}
