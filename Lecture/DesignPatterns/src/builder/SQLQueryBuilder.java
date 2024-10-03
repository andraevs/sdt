package builder;

// Concrete builder for SQL queries
public class SQLQueryBuilder extends QueryBuilder {
    @Override
    public String build() {
        StringBuilder query = new StringBuilder();
        query.append("SELECT ").append(selectFields).append(" FROM ").append(table);
        if (conditions != null && !conditions.isEmpty()) {
            query.append(" WHERE ").append(conditions);
        }
        return query.toString();
    }
}
