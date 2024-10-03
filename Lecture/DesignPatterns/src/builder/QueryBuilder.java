package builder;

// Abstract builder class
public abstract class QueryBuilder {
    protected String table;
    protected String selectFields;
    protected String conditions;

    public QueryBuilder setTable(String table) {
        this.table = table;
        return this;
    }

    public QueryBuilder setSelectFields(String selectFields) {
        this.selectFields = selectFields;
        return this;
    }

    public QueryBuilder setConditions(String conditions) {
        this.conditions = conditions;
        return this;
    }

    // Abstract method to build the query
    public abstract String build();
}

