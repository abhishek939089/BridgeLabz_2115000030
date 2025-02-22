public class DatabaseConnection {
    private boolean isConnected = false;

    public void connect() {
        isConnected = true;
        System.out.println("Connected to database");
    }

    public void disconnect() {
        isConnected = false;
        System.out.println("Disconnected from database");
    }

    public boolean isConnected() {
        return isConnected;
    }
}