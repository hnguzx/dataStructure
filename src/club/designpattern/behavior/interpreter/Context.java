package club.designpattern.behavior.interpreter;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 16:29
 * @describe
 */
public class Context {
    private AbstractExpression expression;

    public Context(){
        // 数据初始化
    }

    public void operation(String info){
        // 调用相关表达式类的解释方法
    }
}
