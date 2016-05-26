package logic.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static Connection connection;

    public static Connection getSimpleConnection() {
        String DB_CONN_STRING = "jdbc:mysql://localhost:3306/lethal_weapon?autoReconnect=true&useSSL=false&characterEncoding=UTF-8";
        String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
        String USER_NAME = "root";
        String PASSWORD = "artegor";

        if (connection == null) {
            try {
                Class.forName(DRIVER_CLASS_NAME).newInstance();
            } catch (Exception ex) {
                System.err.println("Loading class failed!");
            }
            try {
                connection = DriverManager.getConnection(DB_CONN_STRING, USER_NAME, PASSWORD);
            } catch (SQLException e) {
                System.err.println("Creating connection failed!");
                e.printStackTrace();
            }
        }

        return connection;
    }

}
