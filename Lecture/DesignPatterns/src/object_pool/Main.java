package object_pool;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        // Create a connection pool with a maximum of 3 connections
        ConnectionPool connectionPool = new ConnectionPool(3, "jdbc:mysql://localhost:3306/mydb");

        // Get connections from the pool
        DatabaseConnection connection1 = connectionPool.getConnection();
        DatabaseConnection connection2 = connectionPool.getConnection();
        DatabaseConnection connection3 = connectionPool.getConnection();

        // Use the connections
        connection1.query("SELECT * FROM users");
        connection2.query("SELECT * FROM orders");
        connection3.query("SELECT * FROM products");

        // Return connections back to the pool
        connectionPool.returnConnection(connection1);
        connectionPool.returnConnection(connection2);
        connectionPool.returnConnection(connection3);

        // Shutdown the pool (disconnect all connections)
        connectionPool.shutdownPool();
    }
}
