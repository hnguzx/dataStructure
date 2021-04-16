package club.designpattern.structural.adapter;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/16 18:27
 * @describe
 */
public class ObjectAdapter implements Target {

    private Adaptee adaptee;

    public ObjectAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    @Override
    public void newMethod() {
        adaptee.oldMethod();
    }
}
