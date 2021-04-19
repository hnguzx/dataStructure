package club.designpattern.structural.composite;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 17:58
 * @describe
 */
public class Leaf implements Component{

    private String name;

    public Leaf(String name){
        this.name = name;
    }

    @Override
    public void add(Component component) {
        System.out.println("叶子的新增方法");
    }

    @Override
    public void remove(Component component) {
        System.out.println("叶子的移除方法");
    }

    @Override
    public Component getChild(int id) {
        System.out.println("叶子的获取子节点点方法");
        return null;
    }

    @Override
    public void operation() {
        System.out.println("叶子的具体方法");
    }
}
