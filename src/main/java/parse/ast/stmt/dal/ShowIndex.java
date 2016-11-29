/**
 * (created at 2011-5-20)
 */
package parse.ast.stmt.dal;

import parse.ast.expression.primary.Identifier;
import parse.visitor.SQLASTVisitor;

/**

 */
public class ShowIndex extends DALShowStatement {
    private final Type type;
    private final Identifier table;
    public ShowIndex(Type type, Identifier table, Identifier database) {
        this.table = table;
        this.table.setParent(database);
        this.type = type;
    }

    public ShowIndex(Type type, Identifier table) {
        this.table = table;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public Identifier getTable() {
        return table;
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    public static enum Type {
        INDEX,
        INDEXES,
        KEYS
    }
}
