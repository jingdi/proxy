/**
 * (created at 2011-1-23)
 */
package parse.ast.expression.primary.function.info;

import parse.ast.expression.Expression;
import parse.ast.expression.primary.function.FunctionExpression;

import java.util.List;

/**

 */
public class CurrentUser extends FunctionExpression {
    public CurrentUser() {
        super("CURRENT_USER", null);
    }

    @Override
    public FunctionExpression constructFunction(List<Expression> arguments) {
        return new CurrentUser();
    }

}
