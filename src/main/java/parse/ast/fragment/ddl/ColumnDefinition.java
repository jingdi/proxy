/**
 * (created at 2012-8-13)
 */
package parse.ast.fragment.ddl;

import parse.ast.ASTNode;
import parse.ast.expression.Expression;
import parse.ast.expression.primary.literal.LiteralString;
import parse.ast.fragment.ddl.datatype.DataType;
import parse.visitor.SQLASTVisitor;

/**
 * NOT FULL AST
 */
public class ColumnDefinition implements ASTNode {
    private final DataType dataType;
    private final boolean notNull;
    private final Expression defaultVal;
    private final boolean autoIncrement;
    private final SpecialIndex specialIndex;
    private final LiteralString comment;
    private final ColumnFormat columnFormat;
    /**
     * @param dataType
     * @param notNull
     * @param defaultVal    might be null
     * @param autoIncrement
     * @param specialIndex  might be null
     * @param comment       might be null
     * @param columnFormat  might be null
     */
    public ColumnDefinition(DataType dataType, boolean notNull, Expression defaultVal, boolean autoIncrement,
                            SpecialIndex specialIndex, LiteralString comment, ColumnFormat columnFormat) {
        if (dataType == null) throw new IllegalArgumentException("data type is null");
        this.dataType = dataType;
        this.notNull = notNull;
        this.defaultVal = defaultVal;
        this.autoIncrement = autoIncrement;
        this.specialIndex = specialIndex;
        this.comment = comment;
        this.columnFormat = columnFormat;
    }

    public DataType getDataType() {
        return dataType;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public Expression getDefaultVal() {
        return defaultVal;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public SpecialIndex getSpecialIndex() {
        return specialIndex;
    }

    public LiteralString getComment() {
        return comment;
    }

    public ColumnFormat getColumnFormat() {
        return columnFormat;
    }

    @Override
    public void accept(SQLASTVisitor visitor) {
        visitor.visit(this);
    }

    public static enum SpecialIndex {
        PRIMARY,
        UNIQUE,
    }

    public static enum ColumnFormat {
        FIXED,
        DYNAMIC,
        DEFAULT,
    }

}
