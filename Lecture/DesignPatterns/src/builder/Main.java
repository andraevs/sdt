package builder;

public class Main {
    public static void main(String[] args) {
        // SQL Query Example
        QueryBuilder sqlBuilder = new SQLQueryBuilder()
                .setSelectFields("name, age")
                .setTable("employees")
                .setConditions("age > 30");
        System.out.println("SQL Query: " + sqlBuilder.build());

        // MongoDB Query Example
        QueryBuilder mongoBuilder = new MongoQueryBuilder()
                .setSelectFields("'name': 1, 'age': 1")
                .setTable("employees")
                .setConditions("'age': { '$gt': 30 }");
        System.out.println("MongoDB Query: " + mongoBuilder.build());

        // Using the Director (Optional)
        QueryDirector director = new QueryDirector(new SQLQueryBuilder());
        System.out.println("SQL Query from Director: " + director.buildQuery());
    }
}
