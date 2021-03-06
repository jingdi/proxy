/**
 * (created at 2011-1-23)
 */
package parse.ast.expression.primary.function.encryption;

import parse.ast.expression.Expression;
import parse.ast.expression.primary.function.FunctionExpression;

import java.util.List;

/**

 */
public class OldPassword extends FunctionExpression {
    public OldPassword(List<Expression> arguments) {
        super("OLD_PASSWORD", arguments);
    }

    @Override
    public FunctionExpression constructFunction(List<Expression> arguments) {
        return new OldPassword(arguments);
    }

}
