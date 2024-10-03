package builder;

// Optional Director class
public class QueryDirector {
    private QueryBuilder builder;

    public QueryDirector(QueryBuilder builder) {
        this.builder = builder;
    }

    public String buildQuery() {
        return builder
                .setSelectFields("*")
                .setTable("employees")
                .setConditions("age > 30")
                .build();
    }
}
