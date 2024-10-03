package object_pool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class ConnectionPool {
    private BlockingQueue<DatabaseConnection> availableConnections;

    public ConnectionPool(int maxPoolSize, String connectionString) {
        // Initialize the BlockingQueue with a capacity equal to maxPoolSize
        availableConnections = new LinkedBlockingQueue<>(maxPoolSize);

        // Populate the pool with available connections
        for (int i = 0; i < maxPoolSize; i++) {
            availableConnections.offer(new DatabaseConnection(connectionString));
        }
    }

    // Get a connection from the pool
    public DatabaseConnection getConnection() throws InterruptedException {
        // This will block if no connections are available
        DatabaseConnection connection = availableConnections.take();

        if (!connection.isConnected()) {
            connection.connect();  // Ensure it's connected before returning
        }
        System.out.println("Retrieving connection from the pool.");
        return connection;
    }

    // Return the connection back to the pool
    public void returnConnection(DatabaseConnection connection) {
        availableConnections.offer(connection);  // This will not block since it won't exceed the capacity
        System.out.println("Returning connection to the pool.");
    }

    // Shutdown the pool and close all connections
    public void shutdownPool() {
        while (!availableConnections.isEmpty()) {
            DatabaseConnection connection = availableConnections.poll();
            if (connection != null) {
                connection.disconnect();  // Disconnect when shutting down the pool
            }
        }
        System.out.println("Connection pool is shut down.");
    }
}
