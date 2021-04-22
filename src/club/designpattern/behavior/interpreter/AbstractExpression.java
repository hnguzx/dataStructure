package club.designpattern.behavior.interpreter;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 16:29
 * @describe
 */
public interface AbstractExpression {
    /**
     * 解释方法
     * @param info 需要解释的数据
     * @return 解释后的结果
     */
    public Object interpret(String info);
}
