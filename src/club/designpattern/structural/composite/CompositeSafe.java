package club.designpattern.structural.composite;

import java.util.ArrayList;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 18:16
 * @describe
 */
public class CompositeSafe implements ComponentSafe {
    ArrayList<ComponentSafe> children = new ArrayList<>();

    public void add(ComponentSafe component) {
        children.add(component);
        System.out.println("分支节点添加组件");
    }

    public void remove(ComponentSafe component) {
        children.remove(component);
        System.out.println("分支节点移除组件");
    }

    public ComponentSafe getChild(int id) {
        System.out.println("分支节点获取子节点");
        return children.get(id);
    }

    @Override
    public void operation() {
        System.out.println("分支节点的具体操作");
        for (ComponentSafe component : children) {
            component.operation();
        }
    }
}
