package club.designpattern.behavior.interpreter;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 16:29
 * @describe 非终结符表达式
 */
public class NonterminalExpression implements AbstractExpression {

    private AbstractExpression expression;

    @Override
    public Object interpret(String info) {
        // 对非终结表达式进行处理
        return null;
    }
}
