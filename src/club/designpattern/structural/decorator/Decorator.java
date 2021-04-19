package club.designpattern.structural.decorator;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/19 14:47
 * @describe
 */
public class Decorator implements Component {

    private Component component;

    public Decorator(Component component){
        this.component = component;
    }

    @Override
    public void operation() {
        component.operation();
    }
}
