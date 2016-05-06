package logic.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    private static Connection connection;

    public static Connection getSimpleConnection() {
        //See your driver documentation for the proper format of this string :
        String DB_CONN_STRING = "jdbc:mysql://localhost:3306/lethal_weapon";
        //Provided by your driver documentation. In this case, a MySql driver is used :
        String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
        String USER_NAME = "root";
        String PASSWORD = "123222";

        /*if (connection == null) {
            try {
                Class.forName(DRIVER_CLASS_NAME).newInstance();
            } catch (Exception ex) {
                System.err.println("Loading class failed!");
            }
            try {
                connection = DriverManager.getConnection(DB_CONN_STRING, USER_NAME, PASSWORD);
            } catch (SQLException e) {
                System.err.println("Creating connection failed!");
            }
        }
        return connection;*/




        try {
            return DriverManager.getConnection(DB_CONN_STRING, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("fgdfgdsfgdfgdfgdfgdfgdfgdfgdfg");
            e.printStackTrace();
        }
        return null;
    }

}
