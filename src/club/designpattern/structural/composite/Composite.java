package club.designpattern.structural.composite;

import java.util.ArrayList;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 17:58
 * @describe
 */
public class Composite implements Component {
    ArrayList<Component> children = new ArrayList<>();

    @Override
    public void add(Component component) {
        children.add(component);
        System.out.println("分支节点添加组件");
    }

    @Override
    public void remove(Component component) {
        children.remove(component);
        System.out.println("分支节点移除组件");
    }

    @Override
    public Component getChild(int id) {
        System.out.println("分支节点获取子节点");
        return children.get(id);
    }

    @Override
    public void operation() {
        System.out.println("分支节点的具体操作");
        for (Component component:children){
            component.operation();
        }
    }
}
