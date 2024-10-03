package object_pool;

class DatabaseConnection {
    private String connectionString;
    private boolean isConnected = false;  // Track connection state

    public DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
    }

    public void connect() {
        if (!isConnected) {
            System.out.println("Establishing connection to " + connectionString);
            isConnected = true;
        } else {
            System.out.println("Connection to " + connectionString + " is already established.");
        }
    }

    public void query(String sql) {
        if (!isConnected) {
            throw new IllegalStateException("Cannot execute query. Not connected.");
        }
        System.out.println("Executing query: " + sql);
    }

    public void disconnect() {
        if (isConnected) {
            System.out.println("Disconnecting from " + connectionString);
            isConnected = false;
        }
    }

    public boolean isConnected() {
        return isConnected;
    }
}
