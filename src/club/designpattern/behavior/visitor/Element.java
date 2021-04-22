package club.designpattern.behavior.visitor;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 11:36
 * @describe
 */
public interface Element {

    public void accept(Visitor visitor);
}
