package club.designpattern.structural.proxy;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/16 16:49
 * @describe
 */
public class StaticProxy implements Subject{
    private RealSubject realSubject;

    public StaticProxy(){
        this.realSubject = new RealSubject();
    }

    @Override
    public void show() {
        if(realSubject==null){
            realSubject = new RealSubject();
        }
        System.out.println("代理的调用");
        realSubject.show();
    }
}
