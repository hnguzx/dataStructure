package club.designpattern.behavior.responsibility;

import java.util.Objects;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/21 14:43
 * @describe
 */
public class ConcreteHandler2 extends Handler {
    @Override
    public void handleRequest(String request) {
        if ("two".equals(request)) {
            System.out.println("由第二个具体处理类处理");
        } else {
            if (getNext() != null) {
                this.getNext().handleRequest(request);
            } else {
                System.out.println("没有处理器可以处理该请求！");
            }
        }
    }
}
