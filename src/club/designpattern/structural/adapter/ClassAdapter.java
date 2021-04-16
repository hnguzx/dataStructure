package club.designpattern.structural.adapter;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/16 18:17
 * @describe
 */
public class ClassAdapter extends Adaptee implements Target {

    @Override
    public void newMethod() {
        oldMethod();
    }
}
