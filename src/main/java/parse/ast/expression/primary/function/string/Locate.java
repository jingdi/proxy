/**
 * (created at 2011-1-23)
 */
package parse.ast.expression.primary.function.string;

import parse.ast.expression.Expression;
import parse.ast.expression.primary.function.FunctionExpression;
import parse.visitor.SQLASTVisitor;

import java.util.List;

/**

 */
public class Locate extends FunctionExpression {
    public Locate(List<Expression> arguments) {
        super("LOCATE", arguments);
    }

    @Override
    public FunctionExpression constructFunction(List<Expression> arguments) {
        return new Locate(arguments);
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
