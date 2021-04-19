package club.designpattern.structural.composite;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 17:58
 * @describe
 */
public interface Component {
    public void add(Component component);
    public void remove(Component component);
    public Component getChild(int id);
    public void operation();
}
