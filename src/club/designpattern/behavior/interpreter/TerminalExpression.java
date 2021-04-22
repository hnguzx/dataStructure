package club.designpattern.behavior.interpreter;

/**
 * @author Guzx
 * @version 1.0
 * @date 2021/4/22 16:29
 * @describe 终结符表达式
 */
public class TerminalExpression implements AbstractExpression {
    @Override
    public Object interpret(String info) {
        // 对终结表达式进行处理
        return null;
    }
}
