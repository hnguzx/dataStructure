package club.designpattern.behavior.responsibility;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/21 14:43
 * @describe
 */
public abstract class Handler {
    private Handler next;

    public void setNext(Handler next){
        this.next = next;
    }

    public Handler getNext() {
        return next;
    }

    public abstract void handleRequest(String request);
}
