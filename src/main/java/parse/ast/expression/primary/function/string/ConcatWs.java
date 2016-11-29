/**
 * (created at 2011-1-23)
 */
package parse.ast.expression.primary.function.string;

import parse.ast.expression.Expression;
import parse.ast.expression.primary.function.FunctionExpression;

import java.util.List;

/**

 */
public class ConcatWs extends FunctionExpression {
    public ConcatWs(List<Expression> arguments) {
        super("CONCAT_WS", arguments);
    }

    @Override
    public FunctionExpression constructFunction(List<Expression> arguments) {
        return new ConcatWs(arguments);
    }

}
