/**
 * (created at 2011-1-23)
 */
package parse.ast.expression.primary.function.groupby;

import parse.ast.expression.Expression;
import parse.ast.expression.primary.function.FunctionExpression;
import parse.visitor.SQLASTVisitor;

import java.util.List;

/**

 */
public class Max extends FunctionExpression {
    private final boolean distinct;

    public Max(Expression expr, boolean distinct) {
        super("MAX", wrapList(expr));
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    @Override
    public FunctionExpression constructFunction(List<Expression> arguments) {
        throw new UnsupportedOperationException("function of char has special arguments");
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
