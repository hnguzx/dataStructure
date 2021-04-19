package club.designpattern.structural.composite;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 18:15
 * @describe
 */
public class LeafSafe implements ComponentSafe {

    private String name;

    public LeafSafe(String name) {
        this.name = name;
    }

    @Override
    public void operation() {
        System.out.println("叶子" + name + "的具体操作");
    }
}
