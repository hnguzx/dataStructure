package club.designpattern.structural.adapter;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/16 18:17
 * @describe
 */
public class Adaptee implements AdapteeInterface{
    @Override
    public void oldMethod(){
        System.out.println("原有的方法");
    }
}
