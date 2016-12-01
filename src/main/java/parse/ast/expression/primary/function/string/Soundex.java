/**
 * (created at 2011-1-23)
 */
package parse.ast.expression.primary.function.string;

import parse.ast.expression.Expression;
import parse.ast.expression.primary.function.FunctionExpression;

import java.util.List;

/**

 */
public class Soundex extends FunctionExpression {
    public Soundex(List<Expression> arguments) {
        super("SOUNDEX", arguments);
    }

    @Override
    public FunctionExpression constructFunction(List<Expression> arguments) {
        return new Soundex(arguments);
    }

}