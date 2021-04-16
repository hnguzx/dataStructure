package club.designpattern.structural.adapter;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/16 18:38
 * @describe
 */
public class TwoAdapter implements AdapteeInterface,Target{

    private Adaptee adaptee;
    private TargetImplement targetImplement;

    public TwoAdapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }

    public TwoAdapter(TargetImplement targetImplement){
        this.targetImplement = targetImplement;
    }

    @Override
    public void oldMethod() {
        targetImplement.newMethod();
    }

    @Override
    public void newMethod() {
        adaptee.oldMethod();
    }
}
