/**
 * (created at 2011-1-23)
 */
package parse.ast.expression.primary.function.datetime;

import parse.ast.expression.Expression;
import parse.ast.expression.primary.function.FunctionExpression;

import java.util.List;

/**

 */
public class UnixTimestamp extends FunctionExpression {
    public UnixTimestamp(List<Expression> arguments) {
        super("UNIX_TIMESTAMP", arguments);
    }

    @Override
    public FunctionExpression constructFunction(List<Expression> arguments) {
        return new UnixTimestamp(arguments);
    }

}
