package Model.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseConnection {

    private static Connection connection;
    public static Connection getConnection(){
        if (connection == null){
            try {
                Class.forName("com.mysql.jdbc.Driver");

            }
            catch (ClassNotFoundException e){
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void main(String[] args) {
        DatabaseConnection.getConnection();
    }
}
