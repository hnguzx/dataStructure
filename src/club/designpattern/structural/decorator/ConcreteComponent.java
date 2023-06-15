package club.designpattern.structural.decorator;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:47
 * @describe
 */
public class ConcreteComponent implements Component {

    public ConcreteComponent(){
        System.out.println("创建具体构建角色");
    }

    @Override
    public void operation() {
        System.out.println("调用具体构建角色中的operation方法--0");
    }
}
