package builder;

// Concrete builder for MongoDB queries
public class MongoQueryBuilder extends QueryBuilder {
    @Override
    public String build() {
        StringBuilder query = new StringBuilder();
        query.append("{ 'find': '").append(table).append("', ");
        if (selectFields != null && !selectFields.isEmpty()) {
            query.append("'projection': { ").append(selectFields).append(" }, ");
        }
        if (conditions != null && !conditions.isEmpty()) {
            query.append("'filter': { ").append(conditions).append(" } ");
        }
        query.append("}");
        return query.toString();
    }
}
