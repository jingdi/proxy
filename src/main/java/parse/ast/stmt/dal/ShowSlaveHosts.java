/**
 * (created at 2011-5-21)
 */
package parse.ast.stmt.dal;

import parse.visitor.SQLASTVisitor;

/**

 */
public class ShowSlaveHosts extends DALShowStatement {

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
