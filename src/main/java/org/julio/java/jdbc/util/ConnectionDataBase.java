package org.julio.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The type Connection data base.
 */
public class ConnectionDataBase {
   private static String url = "jdbc:mysql://localhost:3306/java_course?serverTimezone=UTC";
    private static String username = "root";
    private static String password = "1234";
    private static Connection connection;

    /**
     * Gets instance.
     *
     * @return the instance
     * @throws SQLException the sql exception
     */
    public static  Connection getInstance() throws SQLException {

        if(connection == null){
            connection = DriverManager.getConnection(url, username, password);
        }
        return connection;

    }


}
