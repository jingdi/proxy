/**
 * (created at 2011-5-17)
 */
package parse.ast.stmt.dml;

import parse.ast.expression.Expression;
import parse.ast.expression.primary.Identifier;
import parse.ast.fragment.Limit;
import parse.ast.fragment.OrderBy;
import parse.ast.fragment.tableref.TableReferences;
import parse.visitor.SQLASTVisitor;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

/**

 */
public class DMLDeleteStatement extends DMLStatement {
    private final boolean lowPriority;
    private final boolean quick;
    private final boolean ignore;
    /**
     * tableName[.*]
     */
    private final List<Identifier> tableNames;
    private final TableReferences tableRefs;
    private final Expression whereCondition;
    private final OrderBy orderBy;
    private final Limit limit;

    //------- single-row delete------------
    public DMLDeleteStatement(boolean lowPriority, boolean quick, boolean ignore, Identifier tableName)
            throws SQLSyntaxErrorException {
        this(lowPriority, quick, ignore, tableName, null, null, null);
    }

    public DMLDeleteStatement(boolean lowPriority, boolean quick, boolean ignore, Identifier tableName, Expression where)
            throws SQLSyntaxErrorException {
        this(lowPriority, quick, ignore, tableName, where, null, null);
    }

    public DMLDeleteStatement(boolean lowPriority, boolean quick, boolean ignore, Identifier tableName,
                              Expression where, OrderBy orderBy, Limit limit) throws SQLSyntaxErrorException {
        this.lowPriority = lowPriority;
        this.quick = quick;
        this.ignore = ignore;
        this.tableNames = new ArrayList<Identifier>(1);
        this.tableNames.add(tableName);
        this.tableRefs = null;
        this.whereCondition = where;
        this.orderBy = orderBy;
        this.limit = limit;

        this.stmtType = StmtType.DML_DELETE;
    }

    //------- multi-row delete------------
    public DMLDeleteStatement(boolean lowPriority, boolean quick, boolean ignore, List<Identifier> tableNameList,
                              TableReferences tableRefs) throws SQLSyntaxErrorException {
        this(lowPriority, quick, ignore, tableNameList, tableRefs, null);
    }

    public DMLDeleteStatement(boolean lowPriority, boolean quick, boolean ignore, List<Identifier> tableNameList,
                              TableReferences tableRefs, Expression whereCondition) throws SQLSyntaxErrorException {
        this.lowPriority = lowPriority;
        this.quick = quick;
        this.ignore = ignore;
        if (tableNameList == null || tableNameList.isEmpty()) {
            throw new IllegalArgumentException("argument 'tableNameList' is empty");
        } else if (tableNameList instanceof ArrayList) {
            this.tableNames = tableNameList;
        } else {
            this.tableNames = new ArrayList<Identifier>(tableNameList);
        }
        if (tableRefs == null) {
            throw new IllegalArgumentException("argument 'tableRefs' is null");
        }
        this.tableRefs = tableRefs;
        this.whereCondition = whereCondition;
        this.orderBy = null;
        this.limit = null;

        this.stmtType = StmtType.DML_DELETE;
    }

    public List<Identifier> getTableNames() {
        return tableNames;
    }

    public TableReferences getTableRefs() {
        return tableRefs;
    }

    public Expression getWhereCondition() {
        return whereCondition;
    }

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public Limit getLimit() {
        return limit;
    }

    public boolean isLowPriority() {
        return lowPriority;
    }

    public boolean isQuick() {
        return quick;
    }

    public boolean isIgnore() {
        return ignore;
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }
}
